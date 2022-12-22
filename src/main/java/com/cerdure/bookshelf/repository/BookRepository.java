package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.book.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Optional<Book> findById(Long id);
    public Page <Book> findByCategoryId(Integer categoryId, Pageable pageable);
    public List <Book> findByNameContainingIgnoreCase(String name);
    public Page <Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndCategoryIdInAndPublishDateAfter(String name, List<Integer> categoryIds, LocalDate publishDate, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndCategoryIdIn(String name, List<Integer> categoryIds, Pageable pageable);
    public Page <Book> findByNameContainingIgnoreCaseAndPublishDateAfter(String name, LocalDate publishDate, Pageable pageable);

}
