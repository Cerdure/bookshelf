package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.NoticeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookServiceImpl bookService;
    private final NoticeServiceImpl noticeService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.findAll();
        List<Book> bestBooks = bookService.findTop10(0);
        List<Notice> notices = noticeService.findLatest4();
        List<Integer> randomNum = new ArrayList<>();
        Book[] bannerBooks = new Book[6], todayBooks = new Book[5];
        for(int i=0; i<6; i++){
            int r = (int)(Math.random()*books.size());
            while (randomNum.contains(r)) {
                r = (int)(Math.random()*books.size());
            }
            randomNum.add(r);
            bannerBooks[i] = books.get(r);
        }
        for(int i=0; i<5; i++){
            int r = (int)(Math.random()*books.size());
            while (randomNum.contains(r)) {
                r = (int)(Math.random()*books.size());
            }
            randomNum.add(r);
            todayBooks[i] = books.get((int)(Math.random()*books.size()));
        }
        model.addAttribute("bannerBooks", bannerBooks);
        model.addAttribute("todayBooks", todayBooks);
        model.addAttribute("bestBooks", bestBooks);
        model.addAttribute("notices", notices);
        return "home";
    }

    @GetMapping("/todayBook-reset")
    public String todayBookReset(Model model) {
        List<Book> books = bookService.findAll();
        Book[] todayBooks = new Book[5];
        List<Integer> randomNum = new ArrayList<>();
        for(int i=0; i<5; i++){
            int r = (int)(Math.random()*books.size());
            while (randomNum.contains(r)) {
                r = (int)(Math.random()*books.size());
            }
            randomNum.add(r);
            todayBooks[i] = books.get((int)(Math.random()*books.size()));
        }
        model.addAttribute("todayBooks", todayBooks);
        return "home :: .today-book-wrapper";
    }

    @GetMapping("/bestBook/{criteria}")
    public String todayBookReset(@PathVariable("criteria") Integer criteria, Model model) {
        List<Book> bestBooks = bookService.findTop10(criteria);
        model.addAttribute("bestBooks", bestBooks);
        return "home :: .best-books-wrapper";
    }
}