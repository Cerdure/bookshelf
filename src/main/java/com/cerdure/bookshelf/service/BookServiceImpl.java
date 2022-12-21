package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.Book;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.repository.BookRepository;
import com.cerdure.bookshelf.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void insert(BookDto bookDto) {

    }

    @Override
    public void validateDuplicateBook(BookDto bookDto) {

    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Book findById(String bookId) {
        return bookRepository.findById(Long.getLong(bookId)).get();
    }

    @Override
    public Page <Book> findByName(String name, String sortOrder, Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,5, Sort.by(sortOrder).descending());
        return bookRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Book> findByNamePaging(String name, String sortOrder, Integer maxNum, Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,maxNum, Sort.by(sortOrder).descending());
        return bookRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Book> findByNameWithCategoriesAndPublishDate(String name, List<Integer> categories, LocalDate publishDate, String sortOrder, Pageable pageable) {
        System.out.println("name = " + name);
        System.out.println("categories = " + categories);
        System.out.println("publishDate = " + publishDate);
        System.out.println("sortOrder = " + sortOrder);
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        Sort nameSort = Sort.by("name").ascending();
        pageable= PageRequest.of(page,18, sortOrder==null || sortOrder=="" || sortOrder=="name"? nameSort : Sort.by(sortOrder).descending());
        if(publishDate == null){
            if(categories == null){
                return bookRepository.findByNameContainingIgnoreCase(name, pageable);
            }
            return bookRepository.findByNameContainingIgnoreCaseAndCategoryIn(name, categories, pageable);
        } else {
            if (categories == null){
                return bookRepository.findByNameContainingIgnoreCaseAndPublishDateAfter(name, publishDate, pageable);
            }
            return bookRepository.findByNameContainingIgnoreCaseAndCategoryInAndPublishDateAfter(name, categories, publishDate, pageable);
        }
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPaging(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable= PageRequest.of(page,5);
        return bookRepository.findAll(pageable);
    }

    @Override
    public void modify(BookDto bookDto) {

    }

    @Override
    public void delete(BookDto bookDto) {

    }
}
