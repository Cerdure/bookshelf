package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.repository.FileRepository;
import com.cerdure.bookshelf.repository.InquireRepository;
import com.cerdure.bookshelf.service.interfaces.InquireService;
import com.cerdure.bookshelf.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InquireServiceImpl implements InquireService {

    private final InquireRepository inquireRepository;
    private final MemberServiceImpl memberService;

    @Override
    public Long create(InquireDto inquireDto, Authentication authentication) {
        Member member = memberService.findByPhone(authentication.getName());
        inquireDto.setMember(member);
        inquireDto.setMemberNickname(member.getNickname());
        Inquire inquire = inquireDto.toEntity();
        inquireRepository.save(inquire);
        return inquire.getId();
    }

    @Override
    public Page<Inquire> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,3, Sort.by("regDate").descending());
        return inquireRepository.findAll(pageable);
    }

    @Override
    public Inquire findById(Long inquireId) {
        return inquireRepository.findById(inquireId).get();
    }

    @Override
    public Page<Inquire> findByTitle(String title, Pageable pageable) {
        return inquireRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @Override
    public Page<Inquire> findByMemberId(Long memberId, Pageable pageable) {
        return inquireRepository.findByMemberId(memberId, pageable);
    }

    @Override
    public Page<Inquire> findByMemberNickname(String memberNickname, Pageable pageable) {
        return inquireRepository.findByMemberNicknameContainingIgnoreCase(memberNickname, pageable);
    }

    @Override
    public Inquire findPrevInquire(Inquire inquire) {
        LocalDateTime regDate = inquire.getRegDate();
        List<Inquire> findResult = inquireRepository.findByRegDateBefore(regDate);
        if(findResult == null || findResult.size() == 0){
            return Inquire.builder().build();

        } else {
            return findResult.get(0);
        }
    }

    @Override
    public Inquire findNextInquire(Inquire inquire) {
        LocalDateTime regDate = inquire.getRegDate();
        List<Inquire> findResult = inquireRepository.findByRegDateAfter(regDate);
        if(findResult == null || findResult.size() == 0){
            return Inquire.builder().build();

        } else {
            return findResult.get(0);
        }
    }

    @Override
    public void modify(Long inquireId, InquireDto inquireDto, Authentication authentication) throws Exception {
        Inquire inquire = inquireRepository.findById(inquireId).get();
            inquire.changeTitle(inquireDto.getTitle());
            inquire.changeContent(inquireDto.getContent());
            inquire.changeClosed(inquireDto.getClosed());
            inquire.changePw(inquireDto.getPw());
            inquireRepository.save(inquire);
    }

    @Override
    public void delete(Long inquireId, Authentication authentication) throws Exception {
        Inquire inquire = inquireRepository.findById(inquireId).get();
        inquireRepository.delete(inquire);
    }

    @Override
    public void hitsPlus(Inquire inquire) {
        inquire.hitsPlus();
        inquireRepository.save(inquire);
    }

}
