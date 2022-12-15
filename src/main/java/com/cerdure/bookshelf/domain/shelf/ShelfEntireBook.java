package com.cerdure.bookshelf.domain.shelf;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.shelf.Shelf;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShelfEntireBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shelf_entire_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
