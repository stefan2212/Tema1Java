package com.dao;

import com.dao.Entities.Category;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends Connection implements ICategoryDao {

    @Override
    public Category addCategory(String categoryName){
        List<Category> categories = new ArrayList<Category>();
        Category category = new Category();
        category.setCategory(categoryName);
        beginTransaction();
        session.save(category);
        endTransaction();
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        String hql = "SELECT c FROM Category c";
        beginTransaction();
        Query query = session.createQuery(hql);
        List results = query.list();
        endTransaction();
        return results;
    }

    @Override
    public Category getEntity(int id) {
        Category category = new Category();
        beginTransaction();
        category = session.get(Category.class,id);
        endTransaction();
        return category;
    }


}
