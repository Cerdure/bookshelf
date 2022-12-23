package com.cerdure.bookshelf.web.controller;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.board.InquireDto;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import com.cerdure.bookshelf.service.InquireServiceImpl;
import com.cerdure.bookshelf.service.MemberServiceImpl;
import com.cerdure.bookshelf.service.ReplyServiceImpl;
import com.cerdure.bookshelf.service.UploadFileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class InquireController {

    private final InquireServiceImpl inquireService;
    private final MemberServiceImpl memberService;
    private final ReplyServiceImpl replyService;
    private final UploadFileServiceImpl uploadFileService;

    @GetMapping("/inquire")
    public String allInquires(@ModelAttribute("inquireDto") InquireDto inquireDto, Model model, Pageable pageable){
        Page<Inquire> inquires = inquireService.findAll(pageable);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @GetMapping("/inquire/{inquireId}")
    public String findInquire(@PathVariable("inquireId") Long inquireId, Model model) {
        Inquire modInquire = inquireService.findById(inquireId);
        model.addAttribute("modInquire", modInquire);
        return "board-inquire :: #modify-wrapper";
    }

    @PostMapping("/inquire")
    public String createInquire(@ModelAttribute InquireDto inquireDto, Authentication authentication, Model model, Pageable pageable) throws Exception {
        Member member = memberService.findByPhone(authentication.getName());
        inquireDto.setMember(member);
        Long inquireId =  inquireService.create(inquireDto);

        if (inquireDto.getImageFiles().get(0).getOriginalFilename() != "") {
            uploadFileService.saveFiles(inquireDto, inquireId);
        }
        Page<Inquire> inquires = inquireService.findAll(pageable);
        model.addAttribute("inquires",inquires);
        return "redirect:/inquire";
    }

    @GetMapping("/inquire-closedCheck/{inquireId}")
    @ResponseBody
    public String findInquire(@PathVariable("inquireId") Long inquireId) {
        Inquire inquire = inquireService.findById(inquireId);
        Integer isClosed = inquire.getClosed();
        if(isClosed == 1){
            return inquire.getPw();
        } else {
            return null;
        }
    }

    @GetMapping("/inquire-detail/{inquireId}")
    public String inquireDetail(@PathVariable("inquireId") Long inquireId, Model model){
        System.out.println("inquireId = " + inquireId);
        Inquire inquire = inquireService.findById(inquireId);
        Collections.sort(inquire.getReplies(), (a, b) -> a.getSeq() - b.getSeq());
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
        Collections.sort(inquire.getReplies(), (a, b) -> a.getSeq() - b.getSeq());
        model.addAttribute("inquire", inquire);
        return "inquire-detail :: .comment-wrapper";
    }

    @PostMapping("/inquire-modify/{inquireId}")
    public String modify(@PathVariable("inquireId") Long inquireId, @ModelAttribute InquireDto inquireDto, Authentication authentication, Model model, Pageable pageable) throws Exception{
        inquireService.modify(inquireId, inquireDto, authentication);
        uploadFileService.deleteFilesByInquireId(inquireId);
        if (inquireDto.getImageFiles().get(0).getOriginalFilename() != "") {
            uploadFileService.saveFiles(inquireDto, inquireId);
        }
        Page<Inquire> inquires = inquireService.findAll(pageable);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @PostMapping("/inquire-delete/{inquireId}")
    public String delete(@PathVariable("inquireId") Long inquireId, Authentication authentication, Model model, Pageable pageable) throws Exception{
        inquireService.delete(inquireId, authentication);
        Page<Inquire> inquires = inquireService.findAll(pageable);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }

    @GetMapping("/inquire-my")
    public String myInquire(Authentication authentication, Model model, Pageable pageable) throws Exception{
        String phone = authentication.getName();
        Member member = memberService.findByPhone(phone);
        Page<Inquire> inquires = inquireService.findByMemberId(member.getId(), pageable);
        model.addAttribute("inquires",inquires);
        return "board-inquire";
    }



}
