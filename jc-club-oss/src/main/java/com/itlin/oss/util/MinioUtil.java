package com.itlin.oss.util;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
public class MinioUtil {



    @Resource
    private MinioClient minioClient;

    @Value("${oss.config.bucket}")
    private String bucket;

    /**
     * 创建桶
     */
    @SneakyThrows
    public void createBucket(String bucketName) {
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if(!bucketExists){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }

    }
    /**
     * 获得所有Bucket列表
     *
     * @return
     */
    @SneakyThrows(Exception.class)
    public List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }
    /**
     * 上传文件
     */
    @SneakyThrows(Exception.class)
    public void uplodeFile(InputStream inputStream,String objectNanme){
        createBucket(bucket);
        minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(objectNanme).stream(inputStream, inputStream.available(), -1).build());

    }



}
