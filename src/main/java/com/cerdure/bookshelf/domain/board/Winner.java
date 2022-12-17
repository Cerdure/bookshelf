package com.cerdure.bookshelf.domain.board;

import com.cerdure.bookshelf.domain.member.Member;
import jdk.jfr.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "winner_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    @Size(max = 10000)
    private String content;

    private LocalDate regDate = LocalDate.now();

    private String category;

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    @Builder
    public Winner(Long id, Member member, String title, String content, LocalDate regDate, String category) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.category = category;
    }
}
