package com.start_up.get_start.author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();
    Author getAuthorById(Integer id);
}
