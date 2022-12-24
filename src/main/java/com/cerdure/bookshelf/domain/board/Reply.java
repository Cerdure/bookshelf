package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquire_id")
    private Inquire inquire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime regDate = LocalDateTime.now();

    @Size(max = 3000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_reply_id")
    private Reply parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Reply> children;

    private Integer seq;

    private Integer level;


    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDateTime.now() : this.regDate;
        this.level = this.level == null ? 0 : this.level;
    }

    @Builder
    public Reply(Long id, Inquire inquire, Member member, LocalDateTime regDate, String content, Reply parent, List<Reply> children, Integer seq, Integer level) {
        this.id = id;
        this.inquire = inquire;
        this.member = member;
        this.regDate = regDate;
        this.content = content;
        this.parent = parent;
        this.children = children;
        this.seq = seq;
        this.level = level;
    }

    public void changeLevel(Integer level){
        this.level = level;
    }
    public void changeContent(String content){
        this.content = content;
    }
    public void delete(){
        this.member = null;
        this.regDate = null;
        this.content = "삭제된 댓글입니다.";
    }
}
