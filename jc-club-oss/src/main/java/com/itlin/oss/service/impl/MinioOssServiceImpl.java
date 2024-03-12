package com.itlin.oss.service.impl;

import com.itlin.oss.service.StorgerService;
import com.itlin.oss.util.MinioUtil;
import io.minio.messages.Bucket;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class MinioOssServiceImpl implements StorgerService {


    @Resource
    private MinioUtil minioUtil;

    @Override
    public List<String> getObject() {
        List<Bucket> allBuckets = minioUtil.getAllBuckets();
        Bucket bucket = allBuckets.get(0);
        List<String> strings = new LinkedList<>();
        strings.add(0, bucket.name());
        return strings;
    }

    /**
     * 上传文件
      * @return
     */
    @Override
    @SneakyThrows
    public Boolean uploudFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        String souceName = file.getOriginalFilename();
        int dotIndex = souceName.lastIndexOf('.');
        if (dotIndex == -1) {
            return false;
        }
        String exit=souceName.substring(dotIndex + 1);
        fileName=fileName+"."+exit;
        minioUtil.uplodeFile(file.getInputStream(), fileName);
        return true;
    }
}
