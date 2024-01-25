package com.start_up.get_start.file;

import org.springframework.web.multipart.MultipartFile;

import java.awt.image.ImagingOpException;
import java.io.IOException;

public interface ImageService {

    String fileImage(MultipartFile file) throws IOException;
}
