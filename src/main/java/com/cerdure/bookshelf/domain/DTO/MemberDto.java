package com.cerdure.bookshelf.domain.DTO;


import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.member.Address;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.domain.order.Order;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    @NotBlank(message = "비밀번호 누락")
    private String pw;

    @NotBlank(message = "이름 누락")
    private String name;

    @NotBlank(message = "닉네임 누락")
    private String nickname;

    @NotBlank(message = "생년월일 누락")
    private String birth;

    @NotBlank(message = "성별 누락")
    private String sex;

    @NotBlank(message = "전화번호 누락")
    private String phone;

    @NotBlank(message = "우편번호 누락")
    private String zipcode;

    @NotBlank(message = "주소 누락")
    private String city;

    private Address address;

    @NotBlank(message = "상세주소 누락")
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
    public MemberDto(String pw, String name, String nickname, String birth, String sex, String phone, Address address, MemberGrade grade, int point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders, Cart cart) {
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

    public Member toEntity(){
        return Member.builder()
                .pw(this.pw)
                .name(this.name)
                .nickname(this.nickname)
                .birth(this.birth)
                .sex(this.sex)
                .phone(this.phone)
                .address(this.address == null ? new Address(this.city,this.street,this.zipcode) : this.address)
                .cart(this.cart)
                .build();
    }
}
