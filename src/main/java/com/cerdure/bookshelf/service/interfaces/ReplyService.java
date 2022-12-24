package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.board.Reply;
import com.cerdure.bookshelf.domain.board.Review;
import com.cerdure.bookshelf.dto.board.ReplyDto;
import com.cerdure.bookshelf.dto.board.ReviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ReplyService {
    public List<Reply> findAll();
    public void replySave(ReplyDto replyDto, Long inquireId, Authentication authentication);
    public void replyModify(ReplyDto replyDto);
    public void replyDelete(ReplyDto replyDto);
}
