package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findById(Long id);
    public Page <Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndCategoryInAndPublishDateAfter(String name, List<Integer> categories, LocalDate publishDate, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndCategoryIn(String name, List<Integer> categories, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndPublishDateAfter(String name, LocalDate publishDate, Pageable pageable);

}
