package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface BookService {

    public void insert(BookDto bookDto);
    void validateDuplicateBook(BookDto bookDto);
    public Book findById(String bookId);
    public Page<Book> findByName(String name, String sortOrder, Pageable pageable);
    public List<Book> findAll();
    public Page<Book> findAllWithPaging(Pageable pageable);
    public void modify(BookDto bookDto);
    public void delete(BookDto bookDto);

}
