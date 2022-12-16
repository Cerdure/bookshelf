package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
    public String homeLogin(@Login Member loginMember, Model model) {
        model.addAttribute("member", loginMember);
        return "home";
    }
}