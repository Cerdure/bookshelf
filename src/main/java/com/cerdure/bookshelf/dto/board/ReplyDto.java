package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
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
    private Inquire inquire;
    private Member member;
    private LocalDateTime regDate;
    private String content;
    private Integer level;
    private Integer seq;
    private String parentNickname;

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

    public Reply toEntity(){
        return Reply.builder()
                .inquire(this.inquire)
                .member(this.member)
                .regDate(this.regDate)
                .content(this.content)
                .level(this.level)
                .seq(this.seq)
                .build();
    }
}
