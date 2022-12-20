package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.repository.FileRepository;
import com.cerdure.bookshelf.repository.ReviewRepository;
import com.cerdure.bookshelf.service.interfaces.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadFileServiceImpl implements UploadFileService {

    private final FileRepository fileRepository;
    private final ReviewRepository reviewRepository;
    private String fileDir = System.getProperty("user.dir") + "/src/main/resources/static/upload-img/";

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    @Override
    public void saveFiles(ReviewDto reviewDto, Long reviewId) throws IOException {
        for (MultipartFile file : reviewDto.getImageFiles()) {
            saveFile(reviewId, file);
        }
    }

    @Override
    public void saveFiles(InquireDto inquireDto) throws IOException {
        for (MultipartFile file : inquireDto.getFiles()) {
            saveFile(inquireDto, file);
        }
    }

    @Override
    public void saveFile(Long reviewId, MultipartFile file) throws IOException {
        String storeFileName = createStoreFileName(file.getOriginalFilename());
        Review review = reviewRepository.findById(reviewId).get();

        UploadFile uploadFile = UploadFile.builder()
                                        .review(review)
                                        .originalFilename(file.getOriginalFilename())
                                        .storeFileName(storeFileName)
                                        .build();

        fileRepository.save(uploadFile);
        file.transferTo(new File(getFullPath(storeFileName)));
    }

    @Override
    public void saveFile(InquireDto inquireDto, MultipartFile file) throws IOException {
        String storeFileName = createStoreFileName(file.getOriginalFilename());
        Inquire inquire = inquireDto.toEntity();

        UploadFile uploadFile = UploadFile.builder()
                .inquire(inquire)
                .originalFilename(file.getOriginalFilename())
                .storeFileName(storeFileName)
                .build();

        fileRepository.save(uploadFile);
        file.transferTo(new File(getFullPath(storeFileName)));
    }

    private String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    @Override
    public List<UploadFile> findAllByReview(Review review) {
        Long reviewId = review.getId();
        return fileRepository.findAllByReviewId(reviewId);
    }

    @Override
    public void deleteFilesByReviewId(Long reviewId) {
        List<UploadFile> uploadFiles = fileRepository.findAllByReviewId(reviewId);
        uploadFiles.forEach(uploadFile -> new File(uploadFile.getFullPath()).delete());
        uploadFiles.forEach(uploadFile -> fileRepository.delete(uploadFile));
    }

}
