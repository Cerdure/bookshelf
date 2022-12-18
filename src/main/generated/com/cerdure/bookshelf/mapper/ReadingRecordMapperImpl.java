package com.cerdure.bookshelf.mapper;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import com.cerdure.bookshelf.domain.shelf.ReadingRecord;
import com.cerdure.bookshelf.dto.shelf.ReadingRecordDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-18T20:14:59+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Oracle Corporation)"
)
public class ReadingRecordMapperImpl implements ReadingRecordMapper {

    @Override
    public ReadingRecord toEntity(ReadingRecordDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        ReadingBook readingBook = null;
        LocalDate regDate = null;

        ReadingRecord readingRecord = new ReadingRecord( id, member, readingBook, regDate );

        return readingRecord;
    }

    @Override
    public ReadingRecordDto toDto(ReadingRecord arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        ReadingBook readingBook = null;

        ReadingRecordDto readingRecordDto = new ReadingRecordDto( id, member, readingBook );

        return readingRecordDto;
    }
}
