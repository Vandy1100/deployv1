package com.start_up.get_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class GetStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetStartApplication.class, args);
    }
    @GetMapping("/data")
    public String getData(){
        return "hello this is my first demo";
    }
    @GetMapping("/product")
    public String product(){
        return "this is my product";
    }
}
