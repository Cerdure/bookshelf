package com.cerdure.bookshelf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"code",""})
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_code")
    private UUID code;
    private String pw;
    private String name;
    private String nickname;
    private String birth;
    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberGrade grade;

    private int point;
    private LocalDate regDate;

    @Enumerated(EnumType.STRING)
    private Answer delflag;

    private LocalDate delDate;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(UUID code, String pw, String name, String nickname, String birth, String phone, Address address, MemberGrade grade, int point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders) {
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
        this.orders = orders;
    }
}
