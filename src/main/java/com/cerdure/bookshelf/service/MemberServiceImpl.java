package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        validateDuplicateMember(memberDto);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(MemberDto memberDto) {
        List<Member> findMembers = memberRepository.findByName(memberDto.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    @Transactional
    public void update(Long id, MemberDto memberDto) {
//        Member member = memberRepository.findOne(id);
//        member.setName(name);
    }

    @Transactional
    public void delete(Long id){
    }

}
