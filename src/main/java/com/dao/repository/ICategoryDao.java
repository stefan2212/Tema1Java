package com.dao.repository;

import com.dao.Entities.Category;

import java.util.List;

public interface ICategoryDao {
    Category addCategory(String categoryName);

    List<Category> getAllCategories();

    Category getEntity(int id);
}
