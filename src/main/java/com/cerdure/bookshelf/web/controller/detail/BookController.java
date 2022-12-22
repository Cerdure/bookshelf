package com.cerdure.bookshelf.web.controller.detail;

import com.cerdure.bookshelf.DataUtils;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.ReviewServiceImpl;
import com.cerdure.bookshelf.service.UploadFileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;
    private final MemberServiceImpl memberService;
    private final ReviewServiceImpl reviewService;
    private final UploadFileServiceImpl uploadFileService;

    @GetMapping("/book{id}")
    public String bookDetail(@RequestParam("id") Long id, Model model) throws Exception {
        Book book = bookService.findById(id);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("book", book);
        model.addAttribute("dataUtils", dataUtils);
        return "book-detail";
    }

    @PostMapping("/book")
    public String reviewCreate(@ModelAttribute ReviewDto reviewDto, Authentication authentication, Model model, Pageable pageable) throws Exception {
        Member member = memberService.findByPhone(authentication.getName());
        reviewDto.setMember(member);
        Long reviewId = reviewService.create(reviewDto);

        if (reviewDto.getImageFiles().get(0).getOriginalFilename() != "") {
            uploadFileService.saveFiles(reviewDto, reviewId);
        }
        Book book = bookService.findById(reviewDto.getBook().getId());
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("reviews", book);
        model.addAttribute("dataUtils", dataUtils);
        return "redirect:/book?id="+book.getId();
    }

    @GetMapping("/bookReview/{reviewId}")
    public String findReview(@PathVariable("reviewId") Long reviewId, Model model) {
        Review modReview = reviewService.findById(reviewId);
        model.addAttribute("modReview", modReview);
        return "book-detail :: #modify-wrapper";
    }

    @PostMapping("/bookReview-modify/{reviewId}")
    public String modify(@PathVariable("reviewId") Long reviewId, @ModelAttribute ReviewDto reviewDto, Authentication authentication, Model model, Pageable pageable) throws Exception{
        reviewService.modify(reviewId, reviewDto, authentication);
        uploadFileService.deleteFilesByReviewId(reviewId);
        uploadFileService.saveFiles(reviewDto, reviewId);
        Book book = bookService.findById(reviewDto.getBook().getId());
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("reviews", book);
        model.addAttribute("dataUtils", dataUtils);
        return "redirect:/book?id="+reviewDto.getBook().getId();
    }

    @PostMapping("/bookReview-delete/{reviewId}/{bookId}")
    public String delete(@PathVariable("reviewId") Long reviewId, @PathVariable("bookId") Long bookId, Authentication authentication, Model model, Pageable pageable) throws Exception{
        reviewService.delete(reviewId, authentication);
        Book book = bookService.findById(bookId);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("reviews", book);
        model.addAttribute("dataUtils", dataUtils);
        return "redirect:/book?id="+bookId;
    }
}