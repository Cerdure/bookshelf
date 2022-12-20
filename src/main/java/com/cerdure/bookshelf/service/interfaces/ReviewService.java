package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.domain.board.Review;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface ReviewService {

    public Long create(ReviewDto reviewDto);
    public Page <Review> findAll(Pageable pageable);
    public Review findById(Long reviewId);
    public Page <Review> findByBookId(Long bookId, Pageable pageable);
    public void modify(Long reviewId, ReviewDto reviewDto, Authentication authentication) throws Exception;
    public void delete(Long reviewId, Authentication authentication) throws Exception;
}
