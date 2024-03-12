package com.itlin.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorgerService {

    List<String> getObject();


    /**
     * 上传文件
     */
     Boolean uploudFile(MultipartFile file);
}
