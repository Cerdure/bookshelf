package com.cerdure.bookshelf.service.interfaces;

import com.cerdure.bookshelf.domain.Trend;
import com.cerdure.bookshelf.domain.book.Book;

import java.util.List;


public interface TrendService {
    public List<Trend> findTop10();
    public void insert(String searchData);
}
