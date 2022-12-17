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
public class EventDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDate regDate;

    private LocalDate modDate;

    @Builder
    public EventDto(Long id, Member member, String title, String content, LocalDate regDate, LocalDate modDate) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
