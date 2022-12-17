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
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Size(max = 10000)
    private String content;

    private LocalDate regDate = LocalDate.now();

    private LocalDate modDate;

    private Integer hits;

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
        this.hits = this.hits == null ? 0 : this.hits;
    }

    @Builder
    public Notice(Long id, Member member, String title, String content, LocalDate regDate, LocalDate modDate, Integer hits) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modDate = modDate;
        this.hits = hits;
    }
}
