package com.todoapi.todomanger.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger= LoggerFactory.getLogger(FileController.class);
    @PostMapping("/SingleFile")
    public String uploadSIngleFile(@RequestParam("image")MultipartFile file){
        logger.info("File Name : {}",file.getName());
        logger.info("File content : {}",file.getContentType());
        return "FileTest";
    }

    @PostMapping("/MultipleFile")
    public String uploadMultipleFile(@RequestParam("files") MultipartFile[] files){
        Arrays.stream(files).forEach(file->{
            logger.info("file Name :{}",file.getName());
            logger.info("file Original Name:{}",file.getOriginalFilename());
            logger.info("file Size :{}",file.getSize());
            logger.info("file content :{}",file.getContentType());
        });
         return "MultipleFile Accepted";
    }
    @GetMapping("/image/{imageName}")
    public void getImage(HttpServletResponse response,@PathVariable String imageName){
        try{
            StringBuilder path=new StringBuilder("image/");
            path.append(imageName);
            InputStream input=new FileInputStream(path.toString());
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(input,response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
