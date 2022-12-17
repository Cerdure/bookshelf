package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Event;
import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.dto.board.EventDto;
import com.cerdure.bookshelf.dto.board.NoticeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeMapper extends EntityMapper<NoticeDto, Notice> {
    NoticeMapper MAPPER = Mappers.getMapper(NoticeMapper.class);
}
