package com.cerdure.bookshelf.web.security;

import com.cerdure.bookshelf.domain.member.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.List;

@Getter
public class MemberAdapter extends User implements Serializable {
    private Member member;

    public MemberAdapter(Member member) {
        super(String.valueOf(member.getId()), member.getPassword(), List.of(new SimpleGrantedAuthority(member.getRole().toString())));
        this.member = member;
    }
}