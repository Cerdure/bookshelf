package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Page <Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
