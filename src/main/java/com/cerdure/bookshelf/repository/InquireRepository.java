package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.board.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquireRepository extends JpaRepository<Inquire, Long> {

    public Page <Inquire> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    public Page <Inquire> findByContentContainingIgnoreCase(String content, Pageable pageable);
    public Page <Inquire> findByMemberId(Long memberId, Pageable pageable);
}
