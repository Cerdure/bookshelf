package com.cerdure.bookshelf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WinnerController {

    @RequestMapping("/winner")
    public String winner(){
        return "board-winner";
    }
}
