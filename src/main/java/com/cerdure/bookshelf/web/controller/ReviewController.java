package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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

    @GetMapping("/review")
    public String allReviews(Model model, Pageable pageable){
        Page<Review> reviews = reviewService.findAll(pageable);
        model.addAttribute("reviews",reviews);
        return "board-review";
    }

//    @GetMapping("/review/book-search")
//    public String allBooks(Model model){
//        List<Book> books = bookService.findAll();
//        model.addAttribute("books", books);
//        return "board-review :: #search-results";
//    }

    @GetMapping("/review/book-search")
    public String findBook(@RequestParam Map<String, Object> paramMap, Model model, Pageable pageable) {
        Page <Book> books = bookService.findByName(paramMap.get("name").toString(), paramMap.get("sortOrder").toString(), pageable);
        Integer count = books.getNumberOfElements();
        model.addAttribute("books", books);
        model.addAttribute("count", count);
        return "board-review :: #search-results";
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
