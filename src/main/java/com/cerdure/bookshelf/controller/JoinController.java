package com.cerdure.bookshelf.controller;

import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JoinController {

    @Autowired
    private final MemberRepository memberRepository;

    @RequestMapping("/join")
    public String join(@ModelAttribute("member") Member member){
        return "join";
    }

    @PostMapping("/join")
    public String save(@ModelAttribute("member") Member member) {
//        if (result.hasErrors()) {
//            return "join";
//        }

        memberRepository.save(member);
        System.out.println(member.toString());
        return "redirect:/";
    }
}
