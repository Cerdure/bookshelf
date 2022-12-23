package com.cerdure.bookshelf.domain.shelf;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reading_record_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_book_id")
    private ReadingBook readingBook;

    private LocalDate regDate = LocalDate.now();

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    @Builder
    public ReadingRecord(Long id, Member member, ReadingBook readingBook, LocalDate regDate) {
        this.id = id;
        this.member = member;
        this.readingBook = readingBook;
        this.regDate = regDate;
    }
}
