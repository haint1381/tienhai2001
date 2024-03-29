package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Account;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.AccountService;
import vn.codegym.service.BlogService;
import vn.codegym.service.CategoryService;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping({"","/blog"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;



    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 5, sort = {"blogCreateDate", "blogCreateTime"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("views/list");
        Page<Blog> blogList = blogService.findAll(pageable);
        modelAndView.addObject("blogList", blogList);

        return modelAndView;
    }
    @ModelAttribute("/categories")
    public Iterable<Category> getCategoryList() {
        return categoryService.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createCustomer(Blog blog) {
        blog.setBlogCreateDate(LocalDate.now());
        blog.setBlogCreateTime(LocalTime.now());
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("views/view");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("views/edit");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateCustomer(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("views/delete");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteCustomer(Blog blog) {
        blogService.delete(blog.getBlogId());
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String searchBlog(@RequestParam("query") String search, Model model) {
        model.addAttribute("blogList", blogService.findByTitle(search));
        return "views/list";
    }

    @GetMapping("/{id}")
    public String getBlogCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("blogList", blogService.findByCategory(category));
        return "views/list";
    }
}