package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.board.Inquire;
import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.domain.enums.MemberRole;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import com.cerdure.bookshelf.repository.*;
import com.cerdure.bookshelf.service.interfaces.ReplyService;
import com.cerdure.bookshelf.service.interfaces.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final InquireRepository inquireRepository;
    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Reply> findAll() {
        return replyRepository.findAll();
    }

    @Override
    public void replySave(ReplyDto replyDto, Long inquireId, Authentication authentication) {
        Inquire inquire = inquireRepository.findById(inquireId).get();
        System.out.println("authentication.getAuthorities() = " + authentication.getAuthorities());
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))){
            inquire.changeReFlag(1);
            inquireRepository.save(inquire);
        }
        if(replyDto.getParentId()!=null){
            Reply parent = replyRepository.findById(replyDto.getParentId()).get();
            replyDto.setParent(parent);
            replyDto.setLevel(parent.getLevel()+1);
            replyDto.setContent("<strong>@"+parent.getMember().getNickname()+"</strong> "+replyDto.getContent());
        }
        replyDto.setInquire(inquire);
        replyDto.setMember(memberRepository.findByPhone(authentication.getName()).get());
        replyRepository.save(replyDto.toEntity());
    }

    @Override
    public void replyModify(ReplyDto replyDto) {
        Reply reply = replyRepository.findById(replyDto.getReplyId()).get();
        reply.changeContent(replyDto.getContent());
        if(reply.getParent()!=null){
            Reply parent = replyRepository.findById(reply.getParent().getId()).get();
            reply.changeContent("<strong>@"+parent.getMember().getNickname()+"</strong> "+replyDto.getContent());
        }
        replyRepository.save(reply);
    }

    @Override
    public void replyDelete(ReplyDto replyDto) {
        Reply reply = replyRepository.findById(replyDto.getReplyId()).get();
        Inquire inquire = inquireRepository.findById(reply.getInquire().getId()).get();
        List<MemberRole> roles = new ArrayList<>();
        inquire.getReplies().forEach(rp -> roles.add(rp.getMember().getRole()));
        if(!roles.contains("ROLE_ADMIN")){
            inquire.changeReFlag(0);
            inquireRepository.save(inquire);
        }
        if(reply.getChildren() == null || reply.getChildren().size() == 0){
            replyRepository.delete(reply);
        } else {
            reply.delete();
            replyRepository.save(reply);
        }
    }

}
