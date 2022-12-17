package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Winner;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.WinnerDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T00:46:45+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class WinnerMapperImpl implements WinnerMapper {

    @Override
    public Winner toEntity(WinnerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        String category = null;

        Winner winner = new Winner( id, member, title, content, regDate, category );

        return winner;
    }

    @Override
    public WinnerDto toDto(Winner entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        String title = null;
        String content = null;
        LocalDate regDate = null;
        String category = null;

        WinnerDto winnerDto = new WinnerDto( id, member, title, content, regDate, category );

        return winnerDto;
    }
}
