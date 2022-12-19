package com.cerdure.bookshelf.dto.board;


import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.UploadFileDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewDto {

    private Long id;

    @NotBlank
    private Book book;

    @NotBlank
    private Member member;

    @NotBlank
    private String content;

    @NotBlank
    private String tag;

    @NotBlank
    private Integer rating;

    private List<UploadFile> files;

    @Builder
    public ReviewDto(Long id, Book book, Member member, String content, String tag, Integer rating, List<UploadFile> files) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.content = content;
        this.tag = tag;
        this.rating = rating;
        this.files = files;
    }
}
