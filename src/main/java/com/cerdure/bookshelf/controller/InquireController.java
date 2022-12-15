package com.cerdure.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InquireController {

    @RequestMapping("/inquire")
    public String inquire(){
        return "board-inquire";
    }

}
