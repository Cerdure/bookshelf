package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.board.Winner;
import com.cerdure.bookshelf.domain.member.Attendance;
import com.cerdure.bookshelf.dto.board.WinnerDto;
import com.cerdure.bookshelf.dto.member.AttendanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttendanceMapper extends EntityMapper<AttendanceDto, Attendance> {
    AttendanceMapper MAPPER = Mappers.getMapper(AttendanceMapper.class);
}
