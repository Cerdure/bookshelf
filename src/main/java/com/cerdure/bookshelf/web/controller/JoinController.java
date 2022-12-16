package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.DTO.MemberDto;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.repository.MemberRepository;
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

    @Autowired
    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String save(@ModelAttribute MemberDto memberDto) {
//        if (result.hasErrors()) {
//            return "join";
//        }
        Member member = memberDto.toEntity();
        memberRepository.save(member);
        System.out.println(member.toString());
        return "redirect:/";
    }
}
