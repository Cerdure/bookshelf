package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.service.interfaces.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberRepository memberRepository;

    @Override
    public Member login(String phone, String pw) {
        return memberRepository.findByPhone(phone)
                .filter(m -> m.getPw().equals(pw))
                .orElse(null);
    }
}
