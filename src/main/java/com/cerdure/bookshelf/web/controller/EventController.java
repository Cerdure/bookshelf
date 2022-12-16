package com.cerdure.bookshelf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    @RequestMapping("/event")
    public String event(){
        return "event";
    }
}
