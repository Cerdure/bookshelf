package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Event;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.EventDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class EventMapperImpl implements EventMapper {

    @Override
    public Event toEntity(EventDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;

        Event event = new Event( id, member, title, content, regDate, modDate );

        return event;
    }

    @Override
    public EventDto toDto(Event arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;

        EventDto eventDto = new EventDto( id, member, title, content, regDate, modDate );

        return eventDto;
    }
}
