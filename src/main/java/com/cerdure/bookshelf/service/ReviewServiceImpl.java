package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.mapper.ReviewMapper;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.repository.ReviewRepository;
import com.cerdure.bookshelf.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void create(ReviewDto reviewDto) {
        Review review = ReviewMapper.MAPPER.toEntity(reviewDto);
        reviewRepository.save(review);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable= PageRequest.of(page,3, Sort.by("regDate").descending());
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Page<Review> findByBookId(Long bookId, Pageable pageable) {
        return reviewRepository.findByBookId(bookId, pageable);
    }

    @Override
    public Page<Review> findByWriter(String memberNickname, Pageable pageable) {
        List<Member> member = memberRepository.findByNickname(memberNickname);
        Long memberId = member.get(0).getId();
        return reviewRepository.findByMemberId(memberId, pageable);
    }

    @Override
    public void modify(ReviewDto reviewDto) {
        Review review = reviewRepository.findById(reviewDto.getId()).get();
        review.changeRating(reviewDto.getRating());
        review.changeTag(reviewDto.getTag());
        review.changeContent(reviewDto.getContent());
        review.changeFiles(reviewDto.getFiles());
        reviewRepository.save(review);
    }

    @Override
    public void delete(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).get();
        reviewRepository.delete(review);
    }
}
