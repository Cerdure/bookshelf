package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.shelf.Bookmark;
import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import com.cerdure.bookshelf.dto.shelf.BookmarkDto;
import com.cerdure.bookshelf.dto.shelf.ReadingBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReadingBookMapper extends EntityMapper<ReadingBookDto, ReadingBook> {
    ReadingBookMapper MAPPER = Mappers.getMapper(ReadingBookMapper.class);
}
