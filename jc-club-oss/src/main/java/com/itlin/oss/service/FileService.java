package com.itlin.oss.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {

    private final StorgerService storgerService;

    public FileService(StorgerService storgerService) {
        this.storgerService = storgerService;
    }

    public Object getObject() {
        return storgerService.getObject();

    }

    /**
     * 上传文件
     */
    public Boolean uploudFile(MultipartFile file) {
        return storgerService.uploudFile(file);
    }

}
