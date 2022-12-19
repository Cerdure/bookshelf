package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.UploadFileDto;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.mapper.FileMapper;
import com.cerdure.bookshelf.mapper.ReviewMapper;
import com.cerdure.bookshelf.repository.FileRepository;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.service.interfaces.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private FileRepository fileRepository;

    private String fileDir = "/resources/upload-img/";

    public UploadFileServiceImpl() {
    }

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    @Override
    public void saveFiles(ReviewDto reviewDto) throws IOException {
        if(reviewDto.getFiles() != null) {
            List<UploadFile> uploadFiles = reviewDto.getFiles();

            for (UploadFile uploadFile : uploadFiles) {
                if (uploadFile != null) {
                    saveFile(uploadFile, reviewDto);
                }
            }
        }
    }

    @Override
    public void saveFiles(InquireDto inquireDto) throws IOException {

    }

    @Override
    public void saveFile(UploadFile uploadFile, ReviewDto reviewDto) throws IOException {
        String storeFileName = createStoreFileName(uploadFile.getOriginalFilename());
        Review review = ReviewMapper.MAPPER.toEntity(reviewDto);
        uploadFile.changeStoreFileName(storeFileName);
        uploadFile.changeReview(review);

        new File(getFullPath(storeFileName));
        fileRepository.save(uploadFile);
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

}
