package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.Blog;
import vn.codegym.blog.model.Category;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findBlogByBlogTitleContaining (String name);

    Iterable<Blog> findBlogByBlogCategory (Category category);
}