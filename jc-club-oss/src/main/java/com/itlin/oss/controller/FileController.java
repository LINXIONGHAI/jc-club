package com.itlin.oss.controller;

import com.itlin.oss.service.FileService;
import com.itlin.oss.service.StorgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class FileController {

    @Resource
    private StorgerService storgerService;

    @Resource
    private FileService fileService;

    @RequestMapping("/textOss")
    public Object textOss(){
        return fileService.getObject();


    }
}
