package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<UploadFile, Long> {
}
