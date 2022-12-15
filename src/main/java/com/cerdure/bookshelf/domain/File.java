package com.cerdure.bookshelf.domain;

import com.cerdure.bookshelf.domain.board.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String originFileName;
    private String storeFileName;
    private String fullPath;

    @Builder
    public File(Long id, Review review, String originFileName, String storeFileName, String fullPath) {
        this.id = id;
        this.review = review;
        this.originFileName = originFileName;
        this.storeFileName = storeFileName;
        this.fullPath = fullPath;
    }
}
