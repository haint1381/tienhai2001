package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.common.SettingCode;
import vn.codegym.service.CategoryService;
import vn.codegym.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping({"","/product"})
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


//,sort = "price",direction = Sort.Direction.DESC
    @GetMapping
    public String pageProduct(Model model, @PageableDefault(value = 5) Pageable pageable,@CookieValue(value = "idHistory", defaultValue = "-1") Long idHistory){
        if (idHistory != -1) {
            model.addAttribute("historyProduct", productService.findById(idHistory));
        }
        model.addAttribute("product1",new Product());
        model.addAttribute("product2",new Product());
        model.addAttribute("categoryList",categoryService.findAll());
        Page<Product> productList = productService.findAllByStatusTrue(pageable);
        for(Product product : productList){
            product.setCodeId(SettingCode.setUpCode(product));
            productService.save(product);
        }
        model.addAttribute("productList", productService.findAllByStatusTrue(pageable));
        return "product/list";
    }
    @PostMapping("/addNew")
    public String addNewCustomer(@Validated @ModelAttribute("product1") Product product, BindingResult bindingResult, @PageableDefault(value = 5,sort = "productName") Pageable pageable, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            productService.checkBirthday(product.getPrice());
            model.addAttribute("product2",new Product());
            model.addAttribute("categoryList",categoryService.findAll());
            model.addAttribute("productList", productService.findAllByStatusTrue(pageable));
            return "product/list";
        }
//         if(!productService.checkBirthday(product.getPrice())){
//            model.addAttribute("product_id","duplicate Product codes");
//            model.addAttribute("product2",new Product());
//            model.addAttribute("categoryList",categoryService.findAll());
//            model.addAttribute("productList", productService.findAllByStatusTrue(pageable));
//            return "product/list";
//        }
        else {
            product.setStatus(true);
            product.setCodeId("abc");
            productService.save(product);
            model.addAttribute("product2",new Product());
            redirectAttributes.addFlashAttribute("message1","successfully added!!");
            return "redirect:/product";
        }
    }

    @GetMapping("/deleteAll")
    public String test(@RequestParam Long[] select){
        for (int i=0;i<select.length;i++){
            Product product= productService.findById(select[i]);
            product.setStatus(false);
            productService.save(product);
        }
        return "redirect:/product";
    }


    @PostMapping("/editConfirm")
    public String editConfirm(@Validated  @ModelAttribute("product2") Product product, BindingResult bindingResult, @PageableDefault(value = 5,sort = "productName") Pageable pageable, Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("product1",new Product());
            model.addAttribute("categoryList",categoryService.findAll());
            model.addAttribute("productList", productService.findAllByStatusTrue(pageable));
            return "product/list";
        }else {
            product.setStatus(true);
            productService.save(product);
            return "redirect:/product";
        }
    }
    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable Long id){
       Product product= productService.findById(id);
        product.setStatus(false);
        productService.save(product);
        return "redirect:/product";
    }
    @PostMapping("/searchAll")
    public String searchAll(@RequestParam("inputSearch") String name,@RequestParam("selectSearch") String select ,Model model, @PageableDefault(value = 5,sort = "productName") Pageable pageable){
        model.addAttribute("product1",new Product());
        model.addAttribute("product2",new Product());
        model.addAttribute("categoryList",categoryService.findAll());
        if(select.equals("name")){
            model.addAttribute("productList", productService.findProductsByProductNameContains(name,pageable));
            model.addAttribute("value", name);

        }else if(select.equals("price")){
            model.addAttribute("productList", productService.findProductsByPriceContains(name,pageable));
            model.addAttribute("value", name);

        }else if(select.equals("color")){
            model.addAttribute("productList", productService.findProductsByColorContains(name,pageable));
            model.addAttribute("value", name);

        }else {
            model.addAttribute("productList", productService.findAllByStatusTrue(pageable));
        }
        model.addAttribute("name", select);
        return "product/list";
    }

    @PostMapping("/searchAll123")
    public String searchAll123(@RequestParam("inputSearch") String name ,Model model, @PageableDefault(value = 5,sort = "productName") Pageable pageable){
        model.addAttribute("product1",new Product());
        model.addAttribute("product2",new Product());
        model.addAttribute("categoryList",categoryService.findAll());
        model.addAttribute("value123", name);
        model.addAttribute("productList", productService.findAllByStatusTrueAndColorContainingOrProductNameContaining(name,pageable));
        return "product/list";
    }


    @GetMapping("/detail/{id}")
    public String showDetailPage(@PathVariable Long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idHistory", id.toString());
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/product";
    }
}
