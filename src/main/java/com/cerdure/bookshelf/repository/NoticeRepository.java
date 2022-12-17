package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.board.Winner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    public Page <Notice> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    public Page <Notice> findByContentContainingIgnoreCase(String content, Pageable pageable);
    public Page <Notice> findByMemberId(Long memberId, Pageable pageable);
}
