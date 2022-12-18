package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.Bookmark;
import com.cerdure.bookshelf.dto.shelf.BookmarkDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class BookmarkMapperImpl implements BookmarkMapper {

    @Override
    public Bookmark toEntity(BookmarkDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        Bookmark bookmark = new Bookmark( id, member, book );

        return bookmark;
    }

    @Override
    public BookmarkDto toDto(Bookmark arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        Book book = null;

        BookmarkDto bookmarkDto = new BookmarkDto( id, member, book );

        return bookmarkDto;
    }
}
