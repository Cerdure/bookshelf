package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.board.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
