package com.itlin.oss.service.impl;

import com.itlin.oss.service.StorgerService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

public class MinioOssServiceImpl implements StorgerService {
    @Override
    public List<String> getObject() {
        List<String> strings=new LinkedList<>();
        strings.add(0,"MinioOssServiceImpl");
        return strings;
    }
}
