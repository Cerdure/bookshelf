package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.member.Member;

public interface LoginService {
    public Member login(String phone, String pw);
}
