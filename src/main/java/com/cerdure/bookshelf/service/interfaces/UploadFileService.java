package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.UploadFileDto;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UploadFileService {
    public String getFullPath(String name);
    public void saveFiles(ReviewDto reviewDto) throws IOException;
    public void saveFiles(InquireDto inquireDto) throws IOException;
    public void saveFile(UploadFile uploadFile, ReviewDto reviewDto) throws IOException;
    private String createStoreFileName(String originalFilename) {
        return null;
    }
    private String extractExt(String originalFilename) {
        return null;
    }
}
