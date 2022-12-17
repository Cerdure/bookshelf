package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @GetMapping("/review")
    public String allReviews(Model model){
        log.info("------- allReviews -------");
        List<Review> reviews = reviewService.findAll();
        model.addAttribute("reviews",reviews);
        return "board-review";
    }


    @PostMapping("/review")
    public void create(ReviewDto reviewDto) throws Exception{
        reviewService.create(reviewDto);
    }

    @PutMapping("/review")
    public void modify(ReviewDto reviewDto) throws Exception{
        reviewService.modify(reviewDto);
    }

    @DeleteMapping("/review/{reviewId}")
    public void delete(@PathVariable("reviewId") Long reviewId) throws Exception{
        reviewService.delete(reviewId);
    }
}
