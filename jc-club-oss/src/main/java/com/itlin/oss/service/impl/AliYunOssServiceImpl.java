package com.itlin.oss.service.impl;

import com.itlin.oss.service.StorgerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

public class AliYunOssServiceImpl implements StorgerService {
    @Override
    public List<String> getObject() {
        List<String> strings=new LinkedList<>();
        strings.add(0,"AliYunOssServiceImpl");
        return strings;
    }

    @Override
    public Boolean uploudFile(MultipartFile file) {
        return null;
    }
}
