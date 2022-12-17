package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import com.cerdure.bookshelf.dto.shelf.ReadingBookDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:44+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ReadingBookMapperImpl implements ReadingBookMapper {

    @Override
    public ReadingBook toEntity(ReadingBookDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ReadingBook readingBook = new ReadingBook( id, member, book );

        return readingBook;
    }

    @Override
    public ReadingBookDto toDto(ReadingBook entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ReadingBookDto readingBookDto = new ReadingBookDto( id, member, book );

        return readingBookDto;
    }
}
