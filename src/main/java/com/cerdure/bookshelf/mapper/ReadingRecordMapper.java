package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import com.cerdure.bookshelf.domain.shelf.ReadingRecord;
import com.cerdure.bookshelf.dto.shelf.ReadingBookDto;
import com.cerdure.bookshelf.dto.shelf.ReadingRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReadingRecordMapper extends EntityMapper<ReadingRecordDto, ReadingRecord> {
    ReadingRecordMapper MAPPER = Mappers.getMapper(ReadingRecordMapper.class);
}
