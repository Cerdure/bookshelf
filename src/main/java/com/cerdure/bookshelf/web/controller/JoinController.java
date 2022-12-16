package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import com.cerdure.bookshelf.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

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
