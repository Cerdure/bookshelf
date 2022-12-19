package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InquireDto {

    private Long id;

    @NotBlank
    private Member member;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private LocalDate regDate;

    private LocalDate modDate;

    @Enumerated(EnumType.STRING)
    private Answer closed;

    private String pw;

    private Integer hits;

    @Enumerated(EnumType.STRING)
    private Answer reFlag; //답변 여부

    private List<Reply> replies = new ArrayList<>();

    private List<MultipartFile> files = new ArrayList<>();

    @Builder
    public InquireDto(Long id, Member member, String title, String content, LocalDate regDate, LocalDate modDate, Answer closed, String pw, Integer hits, Answer reFlag, List<Reply> replies, List<MultipartFile> files) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
        this.closed = closed;
        this.pw = pw;
        this.hits = hits;
        this.reFlag = reFlag;
        this.replies = replies;
        this.files = files;
    }

    public Inquire toEntity(){
        return Inquire.builder()
                .member(this.member)
                .title(this.title)
                .content(this.content)
                .regDate(this.regDate)
                .modDate(this.modDate)
                .closed(this.closed)
                .pw(this.pw)
                .hits(this.hits)
                .reFlag(this.reFlag)
                .replies(this.replies)
                .build();
    }
}
