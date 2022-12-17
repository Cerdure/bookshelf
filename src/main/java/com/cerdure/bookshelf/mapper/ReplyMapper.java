package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReplyMapper extends EntityMapper<ReplyDto, Reply> {
    ReplyMapper MAPPER = Mappers.getMapper(ReplyMapper.class);
}
