package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.File;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toEntity(ReviewDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Book book = null;
        Member member = null;
        String content = null;
        String tag = null;
        Integer rating = null;
        LocalDate regDate = null;
        List<File> files = null;

        Review review = new Review( id, book, member, content, tag, rating, regDate, files );

        return review;
    }

    @Override
    public ReviewDto toDto(Review arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Book book = null;
        Member member = null;
        String content = null;
        String tag = null;
        Integer rating = null;
        List<File> files = null;

        ReviewDto reviewDto = new ReviewDto( id, book, member, content, tag, rating, files );

        return reviewDto;
    }
}
