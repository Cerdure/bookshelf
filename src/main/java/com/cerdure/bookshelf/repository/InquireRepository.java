package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.board.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface InquireRepository extends JpaRepository<Inquire, Long> {

    public List<Inquire> findByRegDateBefore(LocalDateTime regDate);
    public List <Inquire> findByRegDateAfter(LocalDateTime regDate);
    public Page <Inquire> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    public Page <Inquire> findByMemberId(Long memberId, Pageable pageable);
    public Page <Inquire> findByMemberNicknameContainingIgnoreCase(String nickname, Pageable pageable);
}
