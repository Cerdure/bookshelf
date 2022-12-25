package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.NoticeDto;
import com.cerdure.bookshelf.repository.NoticeRepository;
import com.cerdure.bookshelf.service.interfaces.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberServiceImpl memberService;

    @Override
    public Long create(NoticeDto noticeDto, Authentication authentication) {
        Member member = memberService.findByPhone(authentication.getName());
        noticeDto.setMember(member);
        noticeDto.setMemberNickname(member.getNickname());
        Notice notice = noticeDto.toEntity();
        noticeRepository.save(notice);
        return notice.getId();
    }

    @Override
    public Page<Notice> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,8, Sort.by("regDate").descending());
        return noticeRepository.findAll(pageable);
    }

    @Override
    public Notice findById(Long noticeId) {
        return noticeRepository.findById(noticeId).get();
    }

    @Override
    public Page<Notice> findByTitle(String title, Long memberId, Pageable pageable) {
        if(memberId == null){
            return noticeRepository.findByTitleContainingIgnoreCase(title, pageable);
        } else {
            return noticeRepository.findByTitleContainingIgnoreCaseAndMemberId(title, memberId, pageable);
        }
    }

    @Override
    public Page<Notice> findByContent(String content, Long memberId, Pageable pageable) {
        if (memberId == null){
            return noticeRepository.findByContentContainingIgnoreCase(content, pageable);
        } else {
            return noticeRepository.findByContentContainingIgnoreCaseAndMemberId(content, memberId, pageable);
        }
    }

    @Override
    public Notice findPrevNotice(Notice notice) {
        LocalDateTime regDate = notice.getRegDate();
        List<Notice> findResult = noticeRepository.findByRegDateBefore(regDate);
        if(findResult == null || findResult.size() == 0){
            return Notice.builder().build();
        } else {
            return findResult.get(0);
        }
    }

    @Override
    public Notice findNextNotice(Notice notice) {
        LocalDateTime regDate = notice.getRegDate();
        List<Notice> findResult = noticeRepository.findByRegDateAfter(regDate);
        if(findResult == null || findResult.size() == 0){
            return Notice.builder().build();

        } else {
            return findResult.get(0);
        }
    }

    @Override
    public List<Notice> findLatest4() {
        return noticeRepository.findTop4ByOrderByRegDateDesc();
    }

    @Override
    public Notice modify(Long noticeId, NoticeDto noticeDto, Authentication authentication) throws Exception {
        Notice notice = noticeRepository.findById(noticeId).get();
            notice.changeTitle(noticeDto.getTitle());
            notice.changeContent(noticeDto.getContent());
        noticeRepository.save(notice);
        return notice;
    }

    @Override
    public void delete(Long noticeId, Authentication authentication) throws Exception {
        Notice notice = noticeRepository.findById(noticeId).get();
        noticeRepository.delete(notice);
    }

    @Override
    public void hitsPlus(Notice notice) {
        notice.hitsPlus();
        noticeRepository.save(notice);
    }

}
