package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.DataUtils;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import com.cerdure.bookshelf.service.InquireServiceImpl;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.ReplyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class InquireController {

    private final InquireServiceImpl inquireService;
    private final MemberServiceImpl memberService;
    private final ReplyServiceImpl replyService;

    @GetMapping("/inquire")
    public String allInquires(@ModelAttribute("inquireDto") InquireDto inquireDto, Model model, Pageable pageable){
        Page<Inquire> inquires = inquireService.findAll(pageable);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("dataUtils", dataUtils);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @GetMapping("/inquire-my")
    public String myInquire(Authentication authentication, Model model, Pageable pageable) throws Exception{
        String phone = authentication.getName();
        Member member = memberService.findByPhone(phone);
        Page<Inquire> inquires = inquireService.findByMemberId(member.getId(), pageable);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("dataUtils", dataUtils);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @GetMapping("/inquire-search")
    public String findInquire(@ModelAttribute InquireDto inquireDto, Model model, Pageable pageable) throws Exception{
        Page<Inquire> inquires;
        if(inquireDto.getSearchBy() == 1){
            inquires = inquireService.findByTitle(inquireDto.getInput(), pageable);
        } else {
            inquires = inquireService.findByMemberNickname(inquireDto.getInput(), pageable);
        }
        DataUtils dataUtils = new DataUtils();
        dataUtils.setSearchBy(inquireDto.getSearchBy());
        dataUtils.setInput(inquireDto.getInput());
        model.addAttribute("dataUtils", dataUtils);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @PostMapping("/inquire")
    public String createInquire(@ModelAttribute InquireDto inquireDto, Authentication authentication, Model model, Pageable pageable) throws Exception {
        inquireService.create(inquireDto, authentication);
        Page<Inquire> inquires = inquireService.findAll(pageable);
        model.addAttribute("inquires",inquires);
        return "redirect:/inquire";
    }

    @PostMapping("/inquire-modify/{inquireId}")
    public String modifyInquire(@PathVariable("inquireId") Long inquireId, @ModelAttribute InquireDto inquireDto, Authentication authentication, Model model, Pageable pageable) throws Exception{
        Inquire inquire = inquireService.modify(inquireId, inquireDto, authentication);
        Page<Inquire> inquires = inquireService.findAll(pageable);
        Inquire prev = inquireService.findPrevInquire(inquire);
        Inquire next = inquireService.findNextInquire(inquire);
        model.addAttribute("inquire",inquire);
        model.addAttribute("prevInquire",prev);
        model.addAttribute("nextInquire",next);
        return "inquire-detail";
    }

    @PostMapping("/inquire-delete/{inquireId}")
    public String deleteInquire(@PathVariable("inquireId") Long inquireId, Authentication authentication, Model model, Pageable pageable) throws Exception{
        inquireService.delete(inquireId, authentication);
        Page<Inquire> inquires = inquireService.findAll(pageable);
        DataUtils dataUtils = new DataUtils();
        model.addAttribute("dataUtils", dataUtils);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @GetMapping("/inquire-closedCheck/{inquireId}")
    @ResponseBody
    public String closedCheck(@PathVariable("inquireId") Long inquireId, Authentication authentication) {
        Inquire inquire = inquireService.findById(inquireId);
        Integer isClosed = inquire.getClosed();
        System.out.println("isClosed = " + isClosed);
        if(isClosed == null || isClosed == 0
                || authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))){
            return null;
        } else {
            return inquire.getPw();
        }
    }

    @GetMapping("/inquire-detail/{inquireId}")
    public String inquireDetail(@PathVariable("inquireId") Long inquireId, Model model){
        Inquire inquire = inquireService.findById(inquireId);
        inquireService.hitsPlus(inquire);
        Inquire prev = inquireService.findPrevInquire(inquire);
        Inquire next = inquireService.findNextInquire(inquire);
        model.addAttribute("inquire",inquire);
        model.addAttribute("prevInquire",prev);
        model.addAttribute("nextInquire",next);
        return "inquire-detail";
    }

    @PostMapping("/reply/{inquireId}")
    public String replyCreate(@PathVariable("inquireId") Long inquireId, @ModelAttribute ReplyDto replyDto, Authentication authentication, Model model){
        replyService.replySave(replyDto, inquireId, authentication);
        Inquire inquire = inquireService.findById(inquireId);
        System.out.println("inquire.getReplies().size() = " + inquire.getReplies().size());
        Inquire prev = inquireService.findPrevInquire(inquire);
        Inquire next = inquireService.findNextInquire(inquire);
        model.addAttribute("inquire",inquire);
        model.addAttribute("prevInquire",prev);
        model.addAttribute("nextInquire",next);
        return "inquire-detail";
    }

    @PostMapping("/reply-modify/{inquireId}")
    public String replyModify(@PathVariable("inquireId") Long inquireId, @ModelAttribute ReplyDto replyDto, Model model){
        replyService.replyModify(replyDto);
        Inquire inquire = inquireService.findById(inquireId);
        Inquire prev = inquireService.findPrevInquire(inquire);
        Inquire next = inquireService.findNextInquire(inquire);
        model.addAttribute("inquire",inquire);
        model.addAttribute("prevInquire",prev);
        model.addAttribute("nextInquire",next);
        return "inquire-detail";
    }

    @PostMapping("/reply-delete/{inquireId}")
    public String replyDelete(@PathVariable("inquireId") Long inquireId, @ModelAttribute ReplyDto replyDto, Model model){
        replyService.replyDelete(replyDto);
        Inquire inquire = inquireService.findById(inquireId);
        System.out.println("inquire.getReplies().size() = " + inquire.getReplies().size());
        Inquire prev = inquireService.findPrevInquire(inquire);
        Inquire next = inquireService.findNextInquire(inquire);
        model.addAttribute("inquire",inquire);
        model.addAttribute("prevInquire",prev);
        model.addAttribute("nextInquire",next);
        return "inquire-detail";
    }










}
