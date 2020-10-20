package vn.codegym.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Category;

import java.util.List;

public interface CategoryService  {
    Iterable<Category> findAll();
}
