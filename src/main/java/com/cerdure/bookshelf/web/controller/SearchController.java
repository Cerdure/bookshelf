package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.DataUtils;
import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final BookServiceImpl bookService;

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/search-result")
    public String search(@ModelAttribute("bookDto") BookDto bookDto, Model model, Pageable pageable){
        Page<Book> books = bookService.findByNamePaging(bookDto.getName(), "id", 18, pageable);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("books", books);
        model.addAttribute("dataUtils", dataUtils);
        return "search-result";
    }

    @GetMapping("/search-result/book-search")
    public String findBook(@ModelAttribute BookDto bookDto, Model model, Pageable pageable) {
        Page<Book> books = bookService.findByNameWithCategoriesAndPublishDate(
                bookDto.getName(),
                bookDto.getCategories(),
                bookDto.getPublishDate(),
                bookDto.getSortOrder(),
                pageable);
        DataUtils dataUtils = new DataUtils();
        dataUtils.setName(bookDto.getName());
        dataUtils.setSortOrder(bookDto.getSortOrder());
        System.out.println("bookDto.getName() = " + bookDto.getName());
        System.out.println("bookDto.getCategories() = " + bookDto.getCategories());
        System.out.println("bookDto.getPublishDate() = " + bookDto.getPublishDate());
        System.out.println("bookDto.getSortOrder() = " + bookDto.getSortOrder());

        model.addAttribute("books", books);
        model.addAttribute("dataUtils", dataUtils);
        return "search-result :: #search-results";
    }
}
