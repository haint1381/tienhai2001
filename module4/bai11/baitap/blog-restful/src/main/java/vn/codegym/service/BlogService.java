
package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> getAll();
    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
    void remove(Blog blog);
    Iterable<Blog> findByTitle(String name);

    Iterable<Blog> findByCategory(Category category);
}