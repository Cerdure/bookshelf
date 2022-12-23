package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.UploadFile;
import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inquire_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Size(max = 10000)
    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Integer closed;  // 비밀글 여부

    private String pw;

    private Integer hits;

    private Integer reFlag; //답변 여부

    @OneToMany(mappedBy = "inquire")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "inquire")
    private List<UploadFile> files = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.closed = this.closed == null ? 0 : this.closed;
        this.regDate = this.regDate == null ? LocalDateTime.now() : this.regDate;
        this.hits = this.hits == null ? 0 : this.hits;
        this.reFlag = this.reFlag == null ? 0 : this.reFlag;
    }

    @Builder
    public Inquire(Long id, Member member, String title, String content, LocalDateTime regDate, LocalDateTime modDate, Integer closed, String pw, Integer hits, Integer reFlag, List<Reply> replies) {
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
    }

    public void changeTitle(String title){
        this.title = title;
    }
    public void changeContent(String content){
        this.content = content;
    }
    public void changeClosed(Integer closed){
        this.closed = closed;
    }
    public void changePw(String pw){
        this.pw = pw;
    }
    public void changeReFlag(Integer reFlag){
        this.reFlag = reFlag;
    }
}
