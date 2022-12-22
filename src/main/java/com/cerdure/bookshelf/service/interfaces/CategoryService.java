package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.domain.book.Category;
import com.cerdure.bookshelf.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface CategoryService {

    public Category findById(Integer id);
    public List<Category> findById(List<Integer> ids);
    public List<Category> findByName(String name);

}
