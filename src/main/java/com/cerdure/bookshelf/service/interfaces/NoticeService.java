package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.dto.board.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface NoticeService {
    public Page <Notice> findAll(Pageable pageable);
    public Notice findById(Long noticeId);
    public Page <Notice> findByTitle(String title, Long memberId, Pageable pageable);
    public Page<Notice> findByContent(String memberNickname, Long memberId, Pageable pageable);
    public Notice findPrevNotice(Notice notice);
    public Notice findNextNotice(Notice notice);
    public List<Notice> findLatest4();
    public Long create(NoticeDto noticeDto, Authentication authentication);
    public Notice modify(Long noticeId, NoticeDto noticeDto, Authentication authentication) throws Exception;
    public void delete(Long noticeId, Authentication authentication) throws Exception;
    public void hitsPlus(Notice notice);
}
