package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFile {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    private String originalFilename;

    private String storeFileName;

    private String fileDir;

    private String fullPath;


    @PrePersist
    public void prePersist() {
        this.fileDir = this.fileDir == null ? "/upload-img/" : this.fileDir;
        this.originalFilename = this.originalFilename == null ? this.storeFileName : this.originalFilename;
        this.fullPath = this.fullPath == null ? this.fileDir + this.storeFileName : this.fullPath;
    }

    @Builder
    public UploadFile(Long id, Review review, String originalFilename, String storeFileName, String fileDir, String fullPath) {
        this.id = id;
        this.review = review;
        this.originalFilename = originalFilename;
        this.storeFileName = storeFileName;
        this.fileDir = fileDir;
        this.fullPath = fullPath;
    }

    public void changeReview(Review review){
        this.review = review;
    }

    public void changeStoreFileName(String storeFileName){
        this.storeFileName = storeFileName;
    }

    public void changeFullPath(String fullPath){
        this.fullPath = fullPath;
    }
}
