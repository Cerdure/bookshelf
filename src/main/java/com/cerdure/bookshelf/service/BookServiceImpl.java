package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.repository.BookRepository;
import com.cerdure.bookshelf.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

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
    public List <Book> findByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Page<Book> findByNamePaging(String name, String sortOrder, Integer maxNum, Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,maxNum, Sort.by(sortOrder).descending());
        return bookRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Page<Book> findByNameWithCategoryAndPublishDate(String name, List<Integer> categoryIds, LocalDate publishDate, String sortOrder, Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        Sort nameSort = Sort.by("name").ascending();
        pageable= PageRequest.of(page,18, sortOrder==null || sortOrder=="" || sortOrder=="name"? nameSort : Sort.by(sortOrder).descending());
        if(publishDate == null){
            if(categoryIds == null){
                return bookRepository.findByNameContainingIgnoreCase(name, pageable);
            }
            return bookRepository.findByNameContainingIgnoreCaseAndCategoryIdIn(name, categoryIds, pageable);
        } else {
            if (categoryIds == null){
                return bookRepository.findByNameContainingIgnoreCaseAndPublishDateAfter(name, publishDate, pageable);
            }
            return bookRepository.findByNameContainingIgnoreCaseAndCategoryIdInAndPublishDateAfter(name, categoryIds, publishDate, pageable);
        }
    }

    @Override
    public Page<Book> findByCategory(Integer categoryId, Pageable pageable) {
        return bookRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public List<Book> findTop10(Integer criteria) {
        switch (criteria){
            case 0:
                List<Book> allBooks = bookRepository.findAll();
                Map<Integer, Integer> map = new HashMap<>();
                for (Book book : allBooks) {
                    map.put(allBooks.indexOf(book), book.getSales()*book.getRating());
                }
                List<Integer> keySet = new ArrayList<>(map.keySet());
                keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
                List<Book> resultBooks = new ArrayList<>();
                for (int i=0; i<10; i++){
                    resultBooks.add(allBooks.get(keySet.get(i)));
                }
                return resultBooks;
            case 1:
                return bookRepository.findTop10ByOrderBySalesDesc();
            case 2:
                return bookRepository.findTop10ByOrderByRatingDesc();
        }
        return null;
    }

    @Override
    public List<Book> findDiscountTop16() {
        return bookRepository.findTop16ByOrderByDiscountRateDesc();
    }

    @Override
    public List<Book> findDiscountTop18() {
        return bookRepository.findTop18ByOrderByDiscountRateDesc();
    }

    @Override
    public List<Book> findByNameWithDiscount(String name, int discountRate) {
        return bookRepository.findByNameContainingIgnoreCaseAndDiscountRateAfterOrderByDiscountRateDesc(name, discountRate);
    }


    @Override
    public void insert(BookDto bookDto) {

    }

    @Override
    public void validateDuplicateBook(BookDto bookDto) {

    }

    @Override
    public void modify(BookDto bookDto) {

    }

    @Override
    public void delete(BookDto bookDto) {

    }
}
