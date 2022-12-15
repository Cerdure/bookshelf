package com.cerdure.bookshelf.controller.detail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeDetailController {

    @RequestMapping("/notice-detail")
    public String noticeDetail(){
        return "notice-detail";
    }
}
