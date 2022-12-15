package com.cerdure.bookshelf.domain.shelf;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shelf {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shelf_id")
    private Long id;

    @OneToOne(mappedBy = "shelf", fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "shelf")
    private List<ShelfEntireBook> shelfEntireBooks = new ArrayList<>();

    @OneToMany(mappedBy = "shelf")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "shelf")
    private List<ReadingBook> readingBooks = new ArrayList<>();

    @OneToMany(mappedBy = "shelf")
    private List<ReadingRecord> readingRecords = new ArrayList<>();

    @Builder
    public Shelf(Long id, Member member, List<ShelfEntireBook> shelfEntireBooks, List<Bookmark> bookmarks, List<ReadingBook> readingBooks, List<ReadingRecord> readingRecords) {
        this.id = id;
        this.member = member;
        this.shelfEntireBooks = shelfEntireBooks;
        this.bookmarks = bookmarks;
        this.readingBooks = readingBooks;
        this.readingRecords = readingRecords;
    }
}
