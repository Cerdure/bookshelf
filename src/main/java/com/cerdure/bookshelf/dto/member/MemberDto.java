package com.cerdure.bookshelf.dto.member;


import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.enums.MemberRole;
import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.order.Order;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MemberDto {

    private Long id;

    @NotBlank
    private String pw;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    private String birth;

    @NotBlank
    private String sex;

    @NotBlank
    private String phone;

    @NotBlank
    private String zipcode;

    @NotBlank
    private String city;

    private Address address;

    @NotBlank
    private String street;

    @Enumerated(EnumType.STRING)
    private MemberGrade grade;

    @Nullable
    private Integer point;

    private LocalDate regDate;

    @Enumerated(EnumType.STRING)
    private Answer delflag;

    private LocalDate delDate;

    private List<Order> orders = new ArrayList<>();

    private Cart cart = new Cart();


    @Builder
    public MemberDto(Long id, String pw, String name, String nickname, String birth, String sex, String phone, String zipcode, String city, Address address, String street, MemberGrade grade, @Nullable Integer point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders, Cart cart) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.zipcode = zipcode;
        this.city = city;
        this.address = address;
        this.street = street;
        this.grade = grade;
        this.point = point;
        this.regDate = regDate;
        this.delflag = delflag;
        this.delDate = delDate;
        this.orders = orders;
        this.cart = cart;
    }

    public Member createMember(PasswordEncoder passwordEncoder){
        return Member.builder()
                .pw(passwordEncoder.encode(this.pw))
                .name(this.name)
                .nickname(this.nickname)
                .birth(this.birth)
                .sex(this.sex)
                .phone(this.phone)
                .address(new Address(this.city, this.street, this.zipcode))
                .grade(this.grade)
                .point(this.point)
                .regDate(this.regDate)
                .delflag(this.delflag)
                .delDate(this.delDate)
                .cart(this.cart)
                .role(MemberRole.USER)
                .build();
    }
}
