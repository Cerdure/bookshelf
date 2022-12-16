package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(MemberDto memberDto) {
        validateDuplicateMember(memberDto);
        String encodedPw = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPw);
        Member member = memberDto.toEntity();
        member.getAuthorities();
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(MemberDto memberDto) {
        Optional<Member> findMembers = memberRepository.findByPhone(memberDto.getPhone());
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
