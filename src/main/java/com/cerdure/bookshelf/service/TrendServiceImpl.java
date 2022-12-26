package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.Trend;
import com.cerdure.bookshelf.domain.book.Book;
import com.cerdure.bookshelf.dto.BookDto;
import com.cerdure.bookshelf.repository.BookRepository;
import com.cerdure.bookshelf.repository.TrendRepository;
import com.cerdure.bookshelf.service.interfaces.BookService;
import com.cerdure.bookshelf.service.interfaces.TrendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrendServiceImpl implements TrendService {

    private final TrendRepository trendRepository;

    @Override
    public List<Trend> findTop10() {
        List<Trend> trends = trendRepository.findTop10ByOrderByCountDesc();
        while (trends.size()<10) {
            System.out.println("trends.size() = " + trends.size());
            trends.add(Trend.builder().searchData("-").build());
        }
        return trends;
    }

    @Override
    public void insert(String searchData) {
        System.out.println("searchData = " + searchData);
        Trend trend = trendRepository.findBySearchDataIgnoreCase(searchData);
        if(trend == null){
            trendRepository.save(Trend.builder().searchData(searchData).build());
        } else {
            trend.countPlus();
            trendRepository.save(trend);
        }
    }
}
