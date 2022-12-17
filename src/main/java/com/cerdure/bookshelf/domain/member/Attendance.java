package com.cerdure.bookshelf.domain.member;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendance {

    @Id
    @GeneratedValue
    @Column(name = "attendance_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate regDate = LocalDate.now();

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    @Builder
    public Attendance(Long id, Member member, LocalDate regDate) {
        this.id = id;
        this.member = member;
        this.regDate = regDate;
    }
}
