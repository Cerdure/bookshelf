package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Event;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.EventDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper extends EntityMapper<EventDto, Event> {
    EventMapper MAPPER = Mappers.getMapper(EventMapper.class);
}
