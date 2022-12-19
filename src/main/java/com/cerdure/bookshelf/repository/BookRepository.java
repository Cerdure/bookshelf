package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findById(Long id);
    public Page <Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
