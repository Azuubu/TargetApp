package com.bartekm.targetapp.category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category findCategoryById(int id);

    Category findCategoryByName(String name);

    Category updateCategory(Category category);

    Boolean deleteById(int id);



}
