package com.cerdure.bookshelf.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookDto {

    private Long id;
    private String name;
    private String imgPath;
    private String author;
    private String publisher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    private String ISBN;
    private Integer originPrice;
    private Integer discountRate;
    private Integer discountPrice;
    private Integer stock;
    private String intro;
    private String bookIndex;
    private String publisherReview;
    private String sortOrder;

    private List<Integer> categories;
//    1  북셸프 오리지널
//    2  시 / 에세이
//    3  소설
//    4  인문
//    5  건강
//    6  요리
//    7  경제 / 경영
//    8  자기계발
//    9  정치 / 사회
//    10  역사 / 문화
//    11  만화
//    12  컴퓨터 / IT
//    13  과학
//    14  여행
//    15  예술 / 대중문화
//    16  취미 / 실용 / 스포츠
//    17  종교
//    18  외국어
//    19  철학
//    20  어린이 / 청소년


    @Builder
    public BookDto(Long id, String name, String imgPath, String author, String publisher, LocalDate publishDate, String ISBN, Integer originPrice, Integer discountRate, Integer discountPrice, Integer stock, String intro, String bookIndex, String publisherReview, String sortOrder, List<Integer> categories) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.ISBN = ISBN;
        this.originPrice = originPrice;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.intro = intro;
        this.bookIndex = bookIndex;
        this.publisherReview = publisherReview;
        this.sortOrder = sortOrder;
        this.categories = categories;
    }
}
