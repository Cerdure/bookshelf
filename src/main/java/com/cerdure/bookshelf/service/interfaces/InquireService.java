package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

public interface InquireService {

    public Long create(InquireDto inquireDto, Authentication authentication);
    public Page <Inquire> findAll(Pageable pageable);
    public Inquire findById(Long inquireId);
    public Page <Inquire> findByTitle(String title, Pageable pageable);
    public Page <Inquire> findByMemberId(Long memberId, Pageable pageable);
    public Page<Inquire> findByMemberNickname(String memberNickname, Pageable pageable);
    public Inquire findPrevInquire(Inquire inquire);
    public Inquire findNextInquire(Inquire inquire);
    public void modify(Long inquireId, InquireDto inquireDto, Authentication authentication) throws Exception;
    public void delete(Long inquireId, Authentication authentication) throws Exception;
    public void hitsPlus(Inquire inquire);
}
