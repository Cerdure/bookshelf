package com.cerdure.bookshelf.domain.member;

import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.order.Order;
import com.cerdure.bookshelf.domain.shelf.Shelf;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

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

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public Member(String name) {
        this.name = name;
    }

    @Builder
    public Member(Long id, String pw, String name, String nickname, String birth, String phone, Address address, MemberGrade grade, int point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders, Shelf shelf, Cart cart) {
        this.id = id;
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
        this.shelf = shelf;
        this.cart = cart;
    }
}
