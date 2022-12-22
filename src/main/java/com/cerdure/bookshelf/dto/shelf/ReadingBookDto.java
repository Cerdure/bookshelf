package com.cerdure.bookshelf.dto.shelf;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadingBookDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private Book book;

    @Builder
    public ReadingBookDto(Long id, Member member, Book book) {
        this.id = id;
        this.member = member;
        this.book = book;
    }
}
