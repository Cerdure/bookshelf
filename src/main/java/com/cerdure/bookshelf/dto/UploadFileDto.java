package com.cerdure.bookshelf.dto;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@NoArgsConstructor
@Data
public class UploadFileDto {

    private Long id;
    private Review review;
    private String originalFilename;
    private String storeFileName;
    private String fileDir = "/upload-img/";
    private String fullPath;

    @Builder
    public UploadFileDto(Long id, Review review, String originalFilename, String storeFileName, String fileDir, String fullPath) {
        this.id = id;
        this.review = review;
        this.originalFilename = originalFilename;
        this.storeFileName = storeFileName;
        this.fileDir = fileDir;
        this.fullPath = fullPath;
    }
}
