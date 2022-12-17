package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.board.Winner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnerRepository extends JpaRepository<Winner, Long> {

    public Page <Winner> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    public Page <Winner> findByContentContainingIgnoreCase(String content, Pageable pageable);
    public Page <Winner> findByMemberId(Long memberId, Pageable pageable);
}
