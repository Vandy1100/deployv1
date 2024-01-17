package com.start_up.get_start.author.web;

import com.start_up.get_start.author.Author;
import com.start_up.get_start.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping("/authors")
    public String getAuthor(Model model){
        List<Author> authorList = authorService.getAuthor();
        model.addAttribute("author",authorList);
        return "home";
    }
    @GetMapping("/authors/{id}")
    public String getAuthorById(@PathVariable Integer id,Model model){
        Author author = authorService.getAuthorById(id);
        model.addAttribute("auth",author);
        return "author_view";
    }
}
