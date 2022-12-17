package com.cerdure.bookshelf.dto.member;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowDto {

    private Long id;

    @NotBlank
    private Member member;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_code")
//    private Member followMember;
}
