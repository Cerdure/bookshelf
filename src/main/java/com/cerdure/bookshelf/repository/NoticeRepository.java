package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    public List<Notice> findTop4ByOrderByRegDateDesc();
    public List<Notice> findByRegDateBefore(LocalDateTime regDate);
    public List <Notice> findByRegDateAfter(LocalDateTime regDate);
    public Page <Notice> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    public Page <Notice> findByContentContainingIgnoreCase(String content, Pageable pageable);
    public Page <Notice> findByTitleContainingIgnoreCaseAndMemberId(String title, Long memberId, Pageable pageable);
    public Page <Notice> findByContentContainingIgnoreCaseAndMemberId(String content, Long memberId, Pageable pageable);
}

