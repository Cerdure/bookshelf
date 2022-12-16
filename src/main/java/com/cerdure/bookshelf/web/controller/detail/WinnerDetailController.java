package com.cerdure.bookshelf.web.controller.detail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WinnerDetailController {

    @RequestMapping("/winner-detail")
    public String winnerDetail(){
        return "winner-detail";
    }
}
