package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.shelf.ShelfEntireBook;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.dto.shelf.ShelfEntireBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper extends EntityMapper<BookDto, Book> {
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
}
