package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.board.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    public List<Reply> findBySeqAfter(Integer seq);
    public List<Reply> findByInquireId(Long inquireId);
}
