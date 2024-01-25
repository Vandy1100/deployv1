package com.start_up.get_start.author;

import com.start_up.get_start.author.web.AuthorRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorMapping {
    List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"ngan vidy","vandy","https://e1.pxfuel.com/desktop-wallpaper/105/932/desktop-wallpaper-cool-anime-iphone-badass-anime-iphone.jpg","male","hello this is me","takeo","vandy@gmail.com"));
        add(new Author(1002,"saray sna","saray","https://w0.peakpx.com/wallpaper/553/759/HD-wallpaper-naruto-kun-anime-iphone-iphone-12-lake-naruto-sage-mode-narutoart-sage-samsung.jpg","female","hello this is me","takeo","saray@gmail.com"));
        add(new Author(1003,"houv","houv001","https://wallpaperaccess.com/full/197425.jpg","male","hello this is me","phnhom penh","houv@gmail.com"));
        add(new Author(1004,"phanna","phanna","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJKYxwWGgCxCkwaJnESlQT2TRZY_EYXcWpCB8-Qrn4MWfYtxRh0LlrWFm0YQF5kGVp8S0&usqp=CAU","female","hello this is me","prey veng","phanna@gmail.com"));
    }};
    List<Author> getAuthor(){
        return authors;
    }
    Author getAuthorById(Integer id){
        return authors.stream().filter(el->el.getId()==id).findFirst().orElse(null);
    }
    public void addNewAuthor(Author author){
        authors.add(author);
    }
    public void updateAuthor(int id,Author author) {
        for (int i = 0; i < authors.size(); i++) {
            author = authors.get(i);
            if(author.getId() == id) {
                authors.set(i,author);
            }
        }
    }
}
