package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.ReviewServiceImpl;
import com.cerdure.bookshelf.service.UploadFileServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewService;
    private final BookServiceImpl bookService;
    private final MemberServiceImpl memberService;
    private final UploadFileServiceImpl uploadFileService;

    @GetMapping("/review")
    public String allReviews(@ModelAttribute("reviewDto") ReviewDto reviewDto, Model model, Pageable pageable){
        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "board-review";
    }

    @GetMapping("/review/{reviewId}")
    public String findReview(@PathVariable("reviewId") Long reviewId, Model model) {
        Review modReview = reviewService.findById(reviewId);
        model.addAttribute("modReview", modReview);
        return "board-review :: #modify-wrapper";
    }

    @GetMapping("/review/book-search")
    public String findBook(@RequestParam Map<String, Object> paramMap, Model model, Pageable pageable) {
        Page <Book> books = bookService.findByName(paramMap.get("name").toString(), paramMap.get("sortOrder").toString(), pageable);
        model.addAttribute("books", books);
        return "board-review :: #search-results";
    }

    @PostMapping("/review")
    public String createReview(@ModelAttribute ReviewDto reviewDto, Authentication authentication, Model model, Pageable pageable) throws Exception {
        Member member = memberService.findByPhone(authentication.getName());
        reviewDto.setMember(member);
        Long reviewId =  reviewService.create(reviewDto);

        if (reviewDto.getImageFiles().get(0).getOriginalFilename() != "") {
            uploadFileService.saveFiles(reviewDto, reviewId);
        }
        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "redirect:/review";
    }

    @PostMapping("/review-modify/{reviewId}")
    public String modify(@PathVariable("reviewId") Long reviewId, @ModelAttribute ReviewDto reviewDto, Authentication authentication, Model model, Pageable pageable) throws Exception{
        reviewService.modify(reviewId, reviewDto, authentication);
        uploadFileService.deleteFilesByReviewId(reviewId);
        uploadFileService.saveFiles(reviewDto, reviewId);
        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "board-review";
    }

    @PostMapping("/review-delete/{reviewId}")
    public String delete(@PathVariable("reviewId") Long reviewId, Authentication authentication, Model model, Pageable pageable) throws Exception{
        reviewService.delete(reviewId, authentication);
        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "board-review";
    }
}
