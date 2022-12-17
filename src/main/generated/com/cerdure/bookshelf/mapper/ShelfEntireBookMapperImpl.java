package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.ShelfEntireBook;
import com.cerdure.bookshelf.dto.shelf.ShelfEntireBookDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ShelfEntireBookMapperImpl implements ShelfEntireBookMapper {

    @Override
    public ShelfEntireBook toEntity(ShelfEntireBookDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ShelfEntireBook shelfEntireBook = new ShelfEntireBook( id, member, book );

        return shelfEntireBook;
    }

    @Override
    public ShelfEntireBookDto toDto(ShelfEntireBook entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        ShelfEntireBookDto shelfEntireBookDto = new ShelfEntireBookDto( id, member, book );

        return shelfEntireBookDto;
    }
}
