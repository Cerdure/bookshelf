package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.util.List;

public interface FileRepository extends JpaRepository<UploadFile, Long> {
    public List<UploadFile> findAllByReviewId(Long reviewId);
    public List<UploadFile> findAllByInquireId(Long inquireId);
}
