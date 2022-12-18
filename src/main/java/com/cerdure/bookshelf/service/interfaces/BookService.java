package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;


public interface BookService {

    public void insert(BookDto bookDto);
    void validateDuplicateBook(BookDto bookDto);
    public Page<Book> findByName(String name, String sortOrder, Pageable pageable);
    public List<Book> findAll();
    public Page<Book> findAllWithPaging(Pageable pageable);
    public void modify(BookDto bookDto);
    public void delete(BookDto bookDto);

}
