package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.domain.board.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface ReviewService {

    public void create(ReviewDto reviewDto);
    public Page <Review> findAll(Pageable pageable);
    public Page <Review> findByBookId(Long bookId, Pageable pageable);
//    public Page <Review> findByWriter(String memberNickname, Pageable pageable);
    public void modify(ReviewDto reviewDto);
    public void delete(Long reviewId);
}
