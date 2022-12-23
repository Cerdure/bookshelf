package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.board.Review;
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
        System.out.println("replyDto = " + replyDto);
        System.out.println("inquireId = " + inquireId);
        List<Reply> replies = replyRepository.findBySeqAfter(replyDto.getSeq()-1);
        if(replies != null || replies.size() != 0){
            replies.forEach(e -> e.changeSeq(e.getInquire().getId()==inquireId ? e.getSeq()+1 : e.getSeq()));
        }
        replyDto.setInquire(inquireRepository.findById(inquireId).get());
        replyDto.setMember(memberRepository.findByPhone(authentication.getName()).get());
        replyDto.setContent("<strong>"+replyDto.getParentNickname()+"</strong> "+replyDto.getContent());
        replyRepository.save(replyDto.toEntity());
    }
}
