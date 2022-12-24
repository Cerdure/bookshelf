package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    public String getFullPath(String name);
    public void saveFiles(ReviewDto reviewDto, Long reviewId) throws IOException;
    public void saveReviewFile(Long reviewId, MultipartFile file) throws IOException;
    private String createStoreFileName(String originalFilename) {
        return null;
    }
    private String extractExt(String originalFilename) {
        return null;
    }
    public void deleteFilesByReviewId(Long reviewId);
}
