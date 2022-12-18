package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.member.Attendance;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.member.AttendanceDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class AttendanceMapperImpl implements AttendanceMapper {

    @Override
    public Attendance toEntity(AttendanceDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        LocalDate regDate = null;

        Attendance attendance = new Attendance( id, member, regDate );

        return attendance;
    }

    @Override
    public AttendanceDto toDto(Attendance arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        LocalDate regDate = null;

        AttendanceDto attendanceDto = new AttendanceDto( id, member, regDate );

        return attendanceDto;
    }
}
