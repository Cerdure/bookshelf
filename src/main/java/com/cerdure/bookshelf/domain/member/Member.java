package com.cerdure.bookshelf.domain.member;

import com.cerdure.bookshelf.domain.Cart;
import com.cerdure.bookshelf.domain.enums.MemberGrade;
import com.cerdure.bookshelf.domain.enums.MemberRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    private Integer delflag;

    private LocalDate delDate;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @PrePersist
    public void prePersist() {
        this.grade = this.grade == null ? MemberGrade.NEW : this.grade;
        this.delflag = this.delflag == null ? 0 : this.delflag;
        this.point = this.point == null ? 0 : this.point;
        this.regDate = this.regDate == null ? LocalDate.now() : this.regDate;
    }

    @Builder
    public Member(Long id, String pw, String name, String nickname, String birth, String sex, String phone, Address address, MemberGrade grade, Integer point, LocalDate regDate, Integer delflag, LocalDate delDate, Cart cart, MemberRole role) {
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
        this.cart = cart;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role.toString()));
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
