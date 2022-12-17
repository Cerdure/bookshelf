package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDate regDate;

    private LocalDate modDate;

    private Integer hits;

    @Builder
    public NoticeDto(Long id, Member member, String title, String content, LocalDate regDate, LocalDate modDate, Integer hits) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
        this.hits = hits;
    }
}
