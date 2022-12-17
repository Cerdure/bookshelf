package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.NoticeDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class NoticeMapperImpl implements NoticeMapper {

    @Override
    public Notice toEntity(NoticeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;
        Integer hits = null;

        Notice notice = new Notice( id, member, title, content, regDate, modDate, hits );

        return notice;
    }

    @Override
    public NoticeDto toDto(Notice entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;
        Integer hits = null;

        NoticeDto noticeDto = new NoticeDto( id, member, title, content, regDate, modDate, hits );

        return noticeDto;
    }
}
