package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.shelf.ReadingRecord;
import com.cerdure.bookshelf.domain.shelf.ShelfEntireBook;
import com.cerdure.bookshelf.dto.shelf.ReadingRecordDto;
import com.cerdure.bookshelf.dto.shelf.ShelfEntireBookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShelfEntireBookMapper extends EntityMapper<ShelfEntireBookDto, ShelfEntireBook> {
    ShelfEntireBookMapper MAPPER = Mappers.getMapper(ShelfEntireBookMapper.class);
}
