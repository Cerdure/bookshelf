package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.board.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
