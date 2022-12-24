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
    private Long replyId;
    private Reply parent;
    private Integer level;
    private Long parentId;

    @Builder
    public ReplyDto(Long id, Inquire inquire, Member member, LocalDateTime regDate, String content, Long parentId) {
        this.id = id;
        this.inquire = inquire;
        this.member = member;
        this.regDate = regDate;
        this.content = content;
        this.parentId = parentId;
    }

    public Reply toEntity(){
        return Reply.builder()
                .inquire(this.inquire)
                .member(this.member)
                .regDate(this.regDate)
                .content(this.content)
                .parent(this.parent)
                .level(this.level)
                .build();
    }
}
