package com.cerdure.bookshelf.dto.member;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceDto {

    private Long id;

    @NotBlank
    private Member member;

    private LocalDate regDate;

    @Builder
    public AttendanceDto(Long id, Member member, LocalDate regDate) {
        this.id = id;
        this.member = member;
        this.regDate = regDate;
    }
}
