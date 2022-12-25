package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeDto {

    private Long id;
    private Member member;
    private String memberNickname;
    private Long memberId;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Integer hits;
    private Integer searchBy;
    private String input;

    @Builder
    public NoticeDto(Long id, Member member, String memberNickname, Long memberId, String title, String content, LocalDateTime regDate, LocalDateTime modDate, Integer hits, Integer searchBy, String input) {
        this.id = id;
        this.member = member;
        this.memberNickname = memberNickname;
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
        this.hits = hits;
        this.searchBy = searchBy;
        this.input = input;
    }

    public Notice toEntity() {
        return Notice.builder()
                .member(this.member)
                .memberNickname((this.memberNickname))
                .title(this.title)
                .content(this.content)
                .modDate(this.modDate)
                .hits(this.hits)
                .build();
    }
}
