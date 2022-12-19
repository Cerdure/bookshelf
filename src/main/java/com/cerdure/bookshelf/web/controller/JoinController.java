package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.dto.member.MemberDto;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberServiceImpl memberService;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("memberDto") MemberDto memberDto, BindingResult bindingResult){
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute("memberDto") MemberDto memberDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "join";
        }
        memberService.join(memberDto);
        return "redirect:/";
    }
}
