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

    private Integer level;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer seq;

    private Integer childNum;

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDateTime.now() : this.regDate;
        this.level = this.level == null ? 1 : this.level;
        this.childNum = this.childNum == null ? 0 : this.childNum;
    }

    @Builder
    public Reply(Long id, Inquire inquire, Member member, LocalDateTime regDate, String content, Integer level, Integer seq, Integer childNum) {
        this.id = id;
        this.inquire = inquire;
        this.member = member;
        this.regDate = regDate;
        this.content = content;
        this.level = level;
        this.seq = seq;
        this.childNum = childNum;
    }

    public void changeSeq(Integer seq){
        this.seq = seq;
    }
    public void changeChildNum(Integer childNum){
        this.childNum = childNum;
    }
}
