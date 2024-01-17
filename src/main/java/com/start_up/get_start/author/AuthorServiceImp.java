package com.start_up.get_start.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService{

    @Autowired
    AuthorMapping authorMapping;

    @Override
    public List<Author> getAuthor() {
        return authorMapping.getAuthor();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return authorMapping.getAuthorById(id);
    }
}
