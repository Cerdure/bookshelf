package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookDto dto) {
        if ( dto == null ) {
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

        Book book = new Book( id, name, imgPath, category, author, publisher, publishDate, iSBN, originPrice, discountRate, discountPrice, stock, intro, bookIndex, publisherReview );

        return book;
    }

    @Override
    public BookDto toDto(Book entity) {
        if ( entity == null ) {
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

        BookDto bookDto = new BookDto( id, name, imgPath, category, author, publisher, publishDate, iSBN, originPrice, discountRate, discountPrice, stock, intro, bookIndex, publisherReview );

        return bookDto;
    }
}
