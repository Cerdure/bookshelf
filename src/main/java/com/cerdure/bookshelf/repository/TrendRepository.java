package com.cerdure.bookshelf.repository;

import com.cerdure.bookshelf.domain.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrendRepository extends JpaRepository<Trend, Long> {
    public List<Trend> findTop10ByOrderByCountDesc();
    public Trend findBySearchDataIgnoreCase(String searchData);
}
