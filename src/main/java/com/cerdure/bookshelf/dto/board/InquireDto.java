package com.cerdure.bookshelf.dto.board;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InquireDto {

    private Long id;
    private Member member;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Integer closed;
    private String pw;
    private Integer hits;
    private Integer reFlag;
    private List<Reply> replies;
    private List<MultipartFile> imageFiles;

    @Builder
    public InquireDto(Long id, Member member, String title, String content, LocalDateTime regDate, LocalDateTime modDate, Integer closed, String pw, Integer hits, Integer reFlag, List<Reply> replies, List<MultipartFile> imageFiles) {
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
        this.imageFiles = imageFiles;
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
