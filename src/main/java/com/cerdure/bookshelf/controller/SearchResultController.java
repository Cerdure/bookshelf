package com.cerdure.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchResultController {

    @RequestMapping("/search-result")
    public String searchResult(){
        return "search-result";
    }
}
