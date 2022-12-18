package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:58+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String imgPath = null;
        Integer category = null;
        String author = null;
        String publisher = null;
        String publishDate = null;
        Double iSBN = null;
        Integer originPrice = null;
        Integer discountRate = null;
        Integer discountPrice = null;
        Integer stock = null;
        String intro = null;
        String bookIndex = null;
        String publisherReview = null;

        id = arg0.getId();
        name = arg0.getName();
        imgPath = arg0.getImgPath();
        category = arg0.getCategory();
        author = arg0.getAuthor();
        publisher = arg0.getPublisher();
        publishDate = arg0.getPublishDate();
        iSBN = arg0.getISBN();
        originPrice = arg0.getOriginPrice();
        discountRate = arg0.getDiscountRate();
        discountPrice = arg0.getDiscountPrice();
        stock = arg0.getStock();
        intro = arg0.getIntro();
        bookIndex = arg0.getBookIndex();
        publisherReview = arg0.getPublisherReview();

        Integer sales = null;
        Integer rating = null;

        Book book = new Book( id, name, imgPath, category, author, publisher, publishDate, iSBN, originPrice, discountRate, discountPrice, stock, sales, rating, intro, bookIndex, publisherReview );

        return book;
    }

    @Override
    public BookDto toDto(Book arg0) {
        if ( arg0 == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        return bookDto.build();
    }
}
