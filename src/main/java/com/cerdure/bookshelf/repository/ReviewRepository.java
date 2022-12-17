package com.cerdure.bookshelf.repository;


import com.cerdure.bookshelf.domain.board.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public Page <Review> findByMemberId(Long memberId, Pageable pageable);
    public Page <Review> findByBookId(Long BookId, Pageable pageable);

}
