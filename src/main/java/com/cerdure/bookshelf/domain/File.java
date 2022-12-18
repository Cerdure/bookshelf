package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    private String fileName;

    private String extension;

    private String fullPath;

    @PrePersist
    public void prePersist() {
        this.fullPath = this.fullPath == null ? "/img/review-img/" + fileName + "." + extension : this.fullPath;
    }

    @Builder
    public File(Long id, Review review, String fileName, String fullPath, String extension) {
        this.id = id;
        this.review = review;
        this.fileName = fileName;
        this.extension = extension;
        this.fullPath = fullPath;
    }
}
