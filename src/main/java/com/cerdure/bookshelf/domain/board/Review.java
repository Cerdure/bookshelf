package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.File;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
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

    private String title;

    @Size(max=10000)
    private String content;

    private String tag;
    private int rating;
    private LocalDate regDate;
    private LocalDate modDate;

    @OneToMany(mappedBy = "review")
    private List<File> files = new ArrayList<>();

    @Builder
    public Review(Long id, Book book, Member member, String title, String content, String tag, int rating, LocalDate regDate, LocalDate modDate, List<File> files) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.title = title;
        this.content = content;
        this.tag = tag;
        this.rating = rating;
        this.regDate = regDate;
        this.modDate = modDate;
        this.files = files;
    }
}
