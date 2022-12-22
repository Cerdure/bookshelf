package com.cerdure.bookshelf.service;

import com.cerdure.bookshelf.domain.book.Category;
import com.cerdure.bookshelf.repository.CategoryRepository;
import com.cerdure.bookshelf.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> findById(List<Integer> ids) {
        return categoryRepository.findByIdIn(ids);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }
}
