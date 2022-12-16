package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.member.Member;

import java.util.List;

public interface MemberService {
    public Long join(MemberDto memberDto);
    void validateDuplicateMember(MemberDto memberDto);
    public List<Member> findMembers();
    public Member findOne(Long memberId);
    public void update(Long id, MemberDto memberDto);
    public void delete(Long id);
}
