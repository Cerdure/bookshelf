package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyDto {

    private Long id;

    @NotBlank
    private Inquire inquire;

    @NotBlank
    private Member member;

    private LocalDateTime regDate;

    @NotBlank
    private String content;

    private Integer level;

    private Integer seq;

    @Builder
    public ReplyDto(Long id, Inquire inquire, Member member, LocalDateTime regDate, String content, Integer level, Integer seq) {
        this.id = id;
        this.inquire = inquire;
        this.member = member;
        this.regDate = regDate;
        this.content = content;
        this.level = level;
        this.seq = seq;
    }
}
