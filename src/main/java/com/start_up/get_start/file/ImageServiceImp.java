package com.start_up.get_start.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageServiceImp implements ImageService{
    Path fileLocationStorage;
    ImageServiceImp(){
        fileLocationStorage= Paths.get("src/main/resources/images");
    }
    @Override
    public String fileImage(MultipartFile file) throws IOException {
        String fillName=file.getOriginalFilename();
        //file name dog.jpg

        if(fillName!=null){
            if(fillName.contains("..")){
                System.out.println("fillName is Incorrect...");
                return null;
            }

            String[] filePart=fillName.split("\\.");
            fillName= UUID.randomUUID()+"."+filePart[1];
            Path fileResovle=fileLocationStorage.resolve(fillName);
            //src/main/resources/images/dog.jpg
            Files.copy(file.getInputStream(),fileResovle, StandardCopyOption.REPLACE_EXISTING);
            return fillName;
        }

        return null;
    }
}
