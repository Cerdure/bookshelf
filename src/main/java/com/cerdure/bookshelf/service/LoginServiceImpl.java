package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        Member member = memberRepository.findByPhone(phone).get();
        System.out.println("member.toString() = " + member.toString());
        if (member == null) {
            throw new UsernameNotFoundException(phone);
        }
        return User.builder()
                .username(member.getPhone())
                .password(member.getPw())
                .roles(member.getRole().toString())
                .build();
    }
    }
