package com.cerdure.bookshelf.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"code",""})
public class Member {

    @Builder
    public Member(UUID code, String pw, String name, String nickname, int birth, String phone, Address address, MemberGrade grade, Long point, LocalDate regDate, Answer delflag, LocalDate delDate) {
        this.code = code;
        this.pw = pw;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.grade = grade;
        this.point = point;
        this.regDate = regDate;
        this.delflag = delflag;
        this.delDate = delDate;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_code")
    private UUID code;
    private String pw;
    private String name;
    private String nickname;
    private int birth;
    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberGrade grade;

    private Long point;
    private LocalDate regDate;

    @Enumerated(EnumType.STRING)
    private Answer delflag;

    private LocalDate delDate;


}
