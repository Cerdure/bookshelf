package com.cerdure.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyshelfController {

    @RequestMapping("/myshelf")
    public String myshelf(){
        return "myshelf";
    }
}
