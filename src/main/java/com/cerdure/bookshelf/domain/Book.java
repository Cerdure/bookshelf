package com.cerdure.bookshelf.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String name;
    private String category;
    private String publisher;
    private int originPrice;
    private int discountRate;
    private int discountPrice;
    private int stock;
    private String intro;
    private String index;
    private String publisherReview;

    @Builder
    public Book(Long id, String name, String category, String publisher, int originPrice, int discountRate, int discountPrice, int stock, String intro, String index, String publisherReview) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
        this.originPrice = originPrice;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.intro = intro;
        this.index = index;
        this.publisherReview = publisherReview;
    }
}
