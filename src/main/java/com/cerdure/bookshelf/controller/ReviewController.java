package com.cerdure.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {

    @RequestMapping("/review")
    public String review(){
        return "board-review";
    }
}
