package com.start_up.get_start.author.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private int id;
    private String fullName;
    private String username;
    private MultipartFile file;
    private String gender;
    private String bio;
    private String address;
    private String email;

}
