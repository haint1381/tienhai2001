package com.codegym.controllers;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String listProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.create(product);
        redirect.addFlashAttribute("success", "Saved Product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    public String editForm(Model model, @PathVariable int id) {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/edit")
    public String edit(Product product, RedirectAttributes redirect) {
        productService.updateProduct(product);
        redirect.addFlashAttribute("success", "Saved Product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.deleteProduct(product);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
