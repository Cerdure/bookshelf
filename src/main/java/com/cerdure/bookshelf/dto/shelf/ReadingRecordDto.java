package com.cerdure.bookshelf.dto.shelf;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.shelf.ReadingBook;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadingRecordDto {

    private Long id;

    @NotBlank
    private Member member;

    private ReadingBook readingBook;

    @Builder
    public ReadingRecordDto(Long id, Member member, ReadingBook readingBook) {
        this.id = id;
        this.member = member;
        this.readingBook = readingBook;
    }
}
