package com.cerdure.bookshelf.domain.member;

import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.Answer;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.order.Order;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member implements UserDetails {

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

    private Integer point;

    private LocalDate regDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Answer delflag;

    private LocalDate delDate;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private String role;

    @PrePersist
    public void prePersist() {
        this.grade = this.grade == null ? MemberGrade.NEW : this.grade;
        this.delflag = this.delflag == null ? Answer.N : this.delflag;
        this.point = this.point == null ? 0 : this.point;
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    @Builder
    public Member(Long id, String pw, String name, String nickname, String birth, String sex, String phone, Address address, MemberGrade grade, Integer point, LocalDate regDate, Answer delflag, LocalDate delDate, List<Order> orders, Cart cart, String role) {
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
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for(String role : role.split(",")){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
