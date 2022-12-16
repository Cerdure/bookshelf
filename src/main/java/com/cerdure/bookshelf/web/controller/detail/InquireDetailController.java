package com.cerdure.bookshelf.web.controller.detail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InquireDetailController {

    @RequestMapping("/inquire-detail")
    public String inquireDetail(){
        return "inquire-detail";
    }
}
