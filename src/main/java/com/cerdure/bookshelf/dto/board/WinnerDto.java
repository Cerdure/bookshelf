package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WinnerDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDate regDate = LocalDate.now();

    @NotBlank
    private String category;

    @Builder
    public WinnerDto(Long id, Member member, String title, String content, LocalDate regDate, String category) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.category = category;
    }
}
