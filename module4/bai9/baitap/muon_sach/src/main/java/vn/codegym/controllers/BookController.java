package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Book;
import vn.codegym.service.BookService;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    static int key;
    Map<Integer,Integer> codeMap=new HashMap<>();

    @GetMapping("/")
    public String showHomePage(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("book", new Book());
        model.addAttribute("books", bookService.getAllBook(pageable));
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("book", new Book());
        return "/create";
    }
    @PostMapping("/create")
    public String createBook(Book book){
        bookService.save(book);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String showBook(Model model, @PathVariable int id){
        model.addAttribute("book", bookService.findById(id));
        int random = (int) Math.floor(Math.random() * 89999 + 10000);
        codeMap.put(key,random);
        key++;
        model.addAttribute("code",random);
        return "/view";
    }
    @GetMapping("/bookLoan/{id}")
    public String bookLoan(@PathVariable int id){
        Book book =bookService.findById(id);
        book.setAmount(book.getAmount()-1);
        bookService.save(book);
        return "redirect:/";
    }
}
