package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.NoticeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.yaml.snakeyaml.events.Event;

@Mapper
public interface InquireMapper extends EntityMapper<InquireDto, Inquire> {
    InquireMapper MAPPER = Mappers.getMapper(InquireMapper.class);
}
