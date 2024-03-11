package com.itlin.oss.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final  StorgerService storgerService;

    public  FileService(StorgerService storgerService){
        this.storgerService=storgerService;
    }

    public Object getObject(){
       return storgerService.getObject();

    }

}
