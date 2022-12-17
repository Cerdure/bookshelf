package com.cerdure.bookshelf.dto;

import com.cerdure.bookshelf.domain.File;
import com.cerdure.bookshelf.domain.board.Review;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileDto {
    private Long id;
    private Review review;
    private String fileName;
    private String extension;
    private String fullPath;

    @Builder
    public FileDto(Long id, Review review, String fileName, String extension, String fullPath) {
        this.id = id;
        this.review = review;
        this.fileName = fileName;
        this.extension = extension;
        this.fullPath = fullPath;
    }
}
