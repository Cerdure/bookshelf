package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.ReviewServiceImpl;
import com.cerdure.bookshelf.service.UploadFileServiceImpl;
import com.cerdure.bookshelf.web.security.MemberAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
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

    @GetMapping("/review/book-search")
    public String findBook(@RequestParam Map<String, Object> paramMap, Model model, Pageable pageable) {
        Page <Book> books = bookService.findByName(paramMap.get("name").toString(), paramMap.get("sortOrder").toString(), pageable);
        model.addAttribute("books", books);
        return "board-review :: #search-results";
    }

    @PostMapping("/review")
    public String createReview(@ModelAttribute ReviewDto reviewDto,
                               Authentication authentication,
                               Model model, Pageable pageable) throws Exception {

        System.out.println("reviewDto.getFiles() = " + reviewDto.getFiles());
        Member member = memberService.findByPhone(authentication.getName());
        reviewDto.setMember(member);
        reviewService.create(reviewDto);
        uploadFileService.saveFiles(reviewDto);


        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "board-review :: #review-wrapper";
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
