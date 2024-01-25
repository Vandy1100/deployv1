package com.start_up.get_start.file.web;

import com.start_up.get_start.file.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping
    public String imageUpload(@RequestParam("file")MultipartFile file) throws IOException {
        imageService.fileImage(file);
        return "Successfully";
    }



}
