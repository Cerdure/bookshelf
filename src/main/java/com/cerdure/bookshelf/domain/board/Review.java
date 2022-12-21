package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Size(max=10000)
    private String content;

    private String tag;

    private Integer rating;

    private LocalDateTime regDate;

    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    private List<UploadFile> files = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDateTime.now() : this.regDate;
    }

    @Builder
    public Review(Long id, Book book, Member member, String content, String tag, Integer rating, LocalDateTime regDate, List<UploadFile> files) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.content = content;
        this.tag = tag;
        this.rating = rating;
        this.regDate = regDate;
        this.files = files;
    }

    public void changeRating(Integer rating){
        this.rating = rating;
    }
    public void changeTag(String tag){
        this.tag = tag;
    }
    public void changeContent(String content){
        this.content = content;
    }
    public void changeFiles(List<UploadFile> files){
        System.out.println("changeFiles");
        this.files = files;
    }

}
