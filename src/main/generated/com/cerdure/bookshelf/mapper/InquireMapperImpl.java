package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.InquireDto;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class InquireMapperImpl implements InquireMapper {

    @Override
    public Inquire toEntity(InquireDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;
        Answer closed = null;
        String pw = null;
        Integer hits = null;
        Answer reFlag = null;
        List<Reply> replies = null;

        Inquire inquire = new Inquire( id, member, title, content, regDate, modDate, closed, pw, hits, reFlag, replies );

        return inquire;
    }

    @Override
    public InquireDto toDto(Inquire entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        LocalDate modDate = null;
        Answer closed = null;
        String pw = null;
        int hits = 0;
        Answer reFlag = null;
        List<Reply> replies = null;

        InquireDto inquireDto = new InquireDto( id, member, title, content, regDate, modDate, closed, pw, hits, reFlag, replies );

        return inquireDto;
    }
}
