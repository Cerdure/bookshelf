package com.cerdure.bookshelf.web.controller.detail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookDetailController {

    @RequestMapping("/book-detail")
    public String bookDetail(){
        return "book-detail";
    }
}
