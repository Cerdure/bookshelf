package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.domain.member.Member;
import com.cerdure.bookshelf.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    public void insert(BookDto bookDto);
    void validateDuplicateBook(BookDto bookDto);
    public Page<Book> find(BookDto bookDto, Pageable pageable);
    public Page<Book> findAll();
    public void modify(BookDto bookDto);
    public void delete(BookDto bookDto);

}
