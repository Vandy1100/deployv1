package com.start_up.get_start.author;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String fullName;
    private String username;
    private String profileImage;
    private String gender;
    private String bio;
    private String address;
    private String email;
}
