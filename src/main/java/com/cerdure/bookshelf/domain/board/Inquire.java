package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.enums.Answer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
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

    private LocalDate regDate;

    private LocalDate modDate;

    @Enumerated(EnumType.STRING)
    private Answer closed;  // 비밀글 여부

    private String pw;

    private Integer hits;

    @Enumerated(EnumType.STRING)
    private Answer reFlag; //답변 여부

    @OneToMany(mappedBy = "inquire")
    private List<Reply> replies = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.closed = this.closed == null ? Answer.N : this.closed;
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
        this.hits = this.hits == null ? 0 : this.hits;
        this.reFlag = this.reFlag == null ? Answer.N : this.reFlag;
    }

    @Builder
    public Inquire(Long id, Member member, String title, String content, LocalDate regDate, LocalDate modDate, Answer closed, String pw, Integer hits, Answer reFlag, List<Reply> replies) {
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
}
