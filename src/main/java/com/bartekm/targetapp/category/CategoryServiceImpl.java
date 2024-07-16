package com.bartekm.targetapp.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteById(int id) {
        categoryRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
