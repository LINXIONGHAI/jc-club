package com.itlin.oss.controller;

import com.itlin.oss.service.FileService;
import com.itlin.oss.service.StorgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@RestController
@RequestMapping("/oss")
public class FileController {



    @Resource
    private FileService fileService;

    @RequestMapping("/textOss")
    public Object textOss(){
        return fileService.getObject();
    }
    @PostMapping("/uploudFile")
    public Boolean uploudFile(MultipartFile file){
       return fileService.uploudFile(file);


    }


}
