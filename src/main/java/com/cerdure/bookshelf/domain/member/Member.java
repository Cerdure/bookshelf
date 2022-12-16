package com.cerdure.bookshelf.domain.member;

import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.order.Order;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String pw;
    private String name;
    private String nickname;
    private String birth;
    private String sex;
    private String phone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberGrade grade;

    @Nullable
    private Integer point;

    private LocalDate regDate;

    @Enumerated(EnumType.STRING)
    private Answer delflag;

    private LocalDate delDate;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Builder
    public Member(Long id, String pw, String name, String nickname, String birth, String sex, String phone, Address address, MemberGrade grade, int point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders, Cart cart) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.grade = grade;
        this.point = point;
        this.regDate = regDate;
        this.delflag = delflag;
        this.delDate = delDate;
        this.orders = orders;
        this.cart = cart;
    }

    @PrePersist
    public void prePersist() {
        this.point = this.point == null ? 0 : this.point;
        this.grade = this.grade == null ? MemberGrade.NEW : this.grade;
        this.delflag = this.delflag == null ? Answer.N : this.delflag;
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    public MemberDto toDto(){
            return MemberDto.builder()
                    .pw(this.pw)
                    .name(this.name)
                    .nickname(this.nickname)
                    .birth(this.birth)
                    .sex(this.sex)
                    .phone(this.phone)
                    .address(this.address)
                    .build();
    }
}
