
package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);

    Iterable<Blog> findByTitle(String name);

    Iterable<Blog> findByCategory(Category category);
}