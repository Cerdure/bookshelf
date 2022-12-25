package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.DataUtils;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.member.MemberDto;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MyshelfController {

    private final MemberServiceImpl memberService;

    @GetMapping("/myshelf")
    public String myshelf(Authentication authentication, Model model){
        Member member = memberService.findByPhone(authentication.getName());
        model.addAttribute("member",member);
        return "myshelf";
    }
}
