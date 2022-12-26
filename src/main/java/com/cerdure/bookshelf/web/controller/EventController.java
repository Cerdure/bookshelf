package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Notice;
import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.book.Category;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final BookServiceImpl bookService;

    @GetMapping("/event")
    public String event(Model model){
        List<Book> bannerBooks = bookService.findDiscountTop16();
        List<Book> saleBooks = bookService.findDiscountTop18();
        model.addAttribute("bannerBooks", bannerBooks);
        model.addAttribute("saleBooks", saleBooks);
        return "event";
    }

    @GetMapping("/event-sale")
    public String homeSearchInput(@ModelAttribute BookDto bookDto, Model model) {
        String inputVal = bookDto.getName();
        if(inputVal!=""){
            List<Book> books = bookService.findByNameWithDiscount(inputVal, 30);
            if(books != null){
                books.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            model.addAttribute("ipBooks", books);
        }
        return "event :: #search-input-results";
    }
}
