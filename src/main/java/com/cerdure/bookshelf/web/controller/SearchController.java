package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.Trend;
import com.cerdure.bookshelf.dto.DataUtils;
import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.book.Category;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.service.BookServiceImpl;
import com.cerdure.bookshelf.service.TrendServiceImpl;
import com.cerdure.bookshelf.service.interfaces.CategoryService;
import com.cerdure.bookshelf.service.interfaces.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final BookServiceImpl bookService;
    private final CategoryService categoryService;
    private final TrendServiceImpl trendService;

    @GetMapping("/search")
    public String search(Model model){
        List<Trend> trends = trendService.findTop10();
        model.addAttribute("trends", trends);
        return "search";
    }

    @PostMapping("/search-trend")
    @ResponseBody
    public List<Trend> trendUpdate(){
        System.out.println("trendUpdate()");
        List<Trend> trends = trendService.findTop10();
        return trends;
    }


    @GetMapping("/search-input")
    public String searchInput(@ModelAttribute BookDto bookDto, Model model) {
        String inputVal = bookDto.getName();
        if(inputVal!=""){
            List<Category> categories = categoryService.findByName(inputVal);
            List<Book> books = bookService.findByName(inputVal);
            if(categories != null){
                categories.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            if(books != null){
                books.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            model.addAttribute("ipCategories", categories);
            model.addAttribute("ipBooks", books);
        }
        return "search :: #search-input-results";
    }

    @GetMapping("/search-result-input")
    public String searchResultInput(@ModelAttribute BookDto bookDto, Model model) {
        String inputVal = bookDto.getName();
        if(inputVal!=""){
            List<Category> categories = categoryService.findByName(inputVal);
            List<Book> books = bookService.findByName(inputVal);
            if(categories != null){
                categories.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            if(books != null){
                books.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            trendService.insert(inputVal);
            model.addAttribute("ipCategories", categories);
            model.addAttribute("ipBooks", books);
        }
        return "search-result :: #search-input-results";
    }

    @GetMapping("/home-search-input")
    public String homeSearchInput(@ModelAttribute BookDto bookDto, Model model) {
        String inputVal = bookDto.getName();
        if(inputVal!=""){
            List<Category> categories = categoryService.findByName(inputVal);
            List<Book> books = bookService.findByName(inputVal);
            if(categories != null){
                categories.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            if(books != null){
                books.forEach(e -> e.coincidenceHighlight(inputVal));
            }
            int resultCount = categories.size() + books.size();
            model.addAttribute("ipCategories", categories);
            model.addAttribute("ipBooks", books);
            model.addAttribute("resultCount", resultCount);
        }
        return "home :: #search-input-results";
    }


    @GetMapping("/search-result")
    public String search(@ModelAttribute BookDto bookDto, Model model, Pageable pageable){
        DataUtils dataUtils = new DataUtils();
        if(bookDto.getCategoryIds()==null || bookDto.getCategoryIds().size()==0){
            Page<Book> books = bookService.findByNamePaging(bookDto.getName(), "id", 18, pageable);
            dataUtils.setName(bookDto.getName());
            model.addAttribute("books", books);
        } else {
            Integer categoryId = bookDto.getCategoryIds().get(0);
            Page<Book> books = bookService.findByCategory(categoryId, pageable);
            dataUtils.setCategoryId(categoryId);
            model.addAttribute("books", books);
        }
        trendService.insert(bookDto.getName());
        model.addAttribute("dataUtils", dataUtils);
        return "search-result";
    }

    @GetMapping("/search-result/book-search")
    public String findBook(@ModelAttribute BookDto bookDto, Model model, Pageable pageable) {
        Page<Book> books = bookService.findByNameWithCategoryAndPublishDate(
                bookDto.getName(),
                bookDto.getCategoryIds(),
                bookDto.getPublishDate(),
                bookDto.getSortOrder(),
                pageable);
        DataUtils dataUtils = new DataUtils();
        dataUtils.setName(bookDto.getName());
        dataUtils.setSortOrder(bookDto.getSortOrder());
        trendService.insert(bookDto.getName());
        model.addAttribute("books", books);
        model.addAttribute("dataUtils", dataUtils);
        return "search-result :: #search-results";
    }
}
