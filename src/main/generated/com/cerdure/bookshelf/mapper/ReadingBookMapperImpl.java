package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import com.cerdure.bookshelf.dto.shelf.ReadingBookDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ReadingBookMapperImpl implements ReadingBookMapper {

    @Override
    public ReadingBook toEntity(ReadingBookDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ReadingBook readingBook = new ReadingBook( id, member, book );

        return readingBook;
    }

    @Override
    public ReadingBookDto toDto(ReadingBook arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ReadingBookDto readingBookDto = new ReadingBookDto( id, member, book );

        return readingBookDto;
    }
}
