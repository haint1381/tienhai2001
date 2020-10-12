package vn.codegym.blog.service;

import vn.codegym.blog.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    void saveAndUpdate(Category category);

    Category findById(int id);

    void delete(int id);
}