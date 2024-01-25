package com.start_up.get_start.author.web;

import com.start_up.get_start.author.Author;
import com.start_up.get_start.author.AuthorService;
import com.start_up.get_start.file.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @Autowired
    ImageService imageService;
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

    @GetMapping("/form-view")
    public String view(Model model){
        model.addAttribute("authorRequest",new AuthorRequest());
        return "postauthor";
    }

    @PostMapping("/add")
    public String postAuthor(@ModelAttribute("authorRequest") AuthorRequest authorRequest, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Error Has Happen!!");
            model.addAttribute("author", authorService.getAuthor());
            return "postauthor";
        }

        Author author = new Author();
        try {
            String fileName = "http://localhost:8080/images/"+imageService.fileImage(authorRequest.getFile());
            author.setProfileImage(fileName);
            System.out.println("FileName is"+fileName);
        }catch (Exception e){
            author.setProfileImage("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error"+e.getMessage());
        }
        author.setId(authorRequest.getId());
        author.setFullName(authorRequest.getFullName());
        author.setUsername(authorRequest.getUsername());
        author.setGender(authorRequest.getGender());
        author.setBio(authorRequest.getBio());
        author.setAddress(authorRequest.getAddress());
        author.setEmail(authorRequest.getEmail());
        System.out.println(author);
        authorService.addNewAuthor(author);

        return "redirect:/authors";
    }

    @GetMapping("/update-author/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author",author);
        return "update_author";
    }
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") Integer id,@ModelAttribute AuthorRequest authorRequest,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Error Has Happen!!");
            model.addAttribute("author", authorService.getAuthor());
            return "postauthor";
        }
        Author author = authorService.getAuthorById(id);
        try {
            String fileName = "http://localhost:8080/images/"+imageService.fileImage(authorRequest.getFile());
            author.setProfileImage(fileName);
            System.out.println("FileName is"+fileName);
        }catch (Exception e){
            author.setProfileImage(author.getProfileImage());
            System.out.println("Error"+e.getMessage());
        }
        author.setId(authorRequest.getId());
        author.setFullName(authorRequest.getFullName());
        author.setUsername(authorRequest.getUsername());
        author.setGender(authorRequest.getGender());
        author.setBio(authorRequest.getBio());
        author.setAddress(authorRequest.getAddress());
        author.setEmail(authorRequest.getEmail());
        System.out.println(author);
        authorService.updateAuthor(id,author);
        return "redirect:/authors";
    }
}
