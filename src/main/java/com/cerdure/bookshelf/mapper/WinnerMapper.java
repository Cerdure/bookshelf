package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.board.Winner;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.dto.board.WinnerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WinnerMapper extends EntityMapper<WinnerDto, Winner> {
    WinnerMapper MAPPER = Mappers.getMapper(WinnerMapper.class);
}
