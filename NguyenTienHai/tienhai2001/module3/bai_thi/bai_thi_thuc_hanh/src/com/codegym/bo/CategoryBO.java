package com.codegym.bo;

import com.codegym.dao.CategoryDAO;
import com.codegym.dao.ICategoryDAO;
import com.codegym.model.Category;

import java.util.List;

public class CategoryBO implements ICategoryBO {
    ICategoryDAO iCategoryDAO=new CategoryDAO();
    @Override
    public List<Category> findAllCategory() {
        return iCategoryDAO.findAllCategory();
    }
}
