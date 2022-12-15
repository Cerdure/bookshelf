package com.cerdure.bookshelf.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity @Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@RequiredArgsConstructor
//@AllArgsConstructor
@ToString(of = {"code",""})
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_code")
    private UUID code;
    @Column(name = "member_pw")
    private String pw;


}
