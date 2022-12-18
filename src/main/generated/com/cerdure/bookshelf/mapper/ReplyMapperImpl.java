package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ReplyMapperImpl implements ReplyMapper {

    @Override
    public Reply toEntity(ReplyDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Inquire inquire = null;
        Member member = null;
        LocalDateTime regDate = null;
        String content = null;
        int level = 0;
        int seq = 0;

        Reply reply = new Reply( id, inquire, member, regDate, content, level, seq );

        return reply;
    }

    @Override
    public ReplyDto toDto(Reply arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Inquire inquire = null;
        Member member = null;
        LocalDateTime regDate = null;
        String content = null;
        Integer level = null;
        Integer seq = null;

        ReplyDto replyDto = new ReplyDto( id, inquire, member, regDate, content, level, seq );

        return replyDto;
    }
}
