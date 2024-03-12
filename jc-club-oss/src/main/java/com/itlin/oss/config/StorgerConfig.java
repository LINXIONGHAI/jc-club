package com.itlin.oss.config;

import com.itlin.oss.service.StorgerService;
import com.itlin.oss.service.impl.AliYunOssServiceImpl;
import com.itlin.oss.service.impl.MinioOssServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class StorgerConfig {


    @Value("${oss.type}")
    private String ossType;

    @Bean
    @RefreshScope
    public StorgerService StorgerService(){
        if(ossType.equals("minio")){
            return new MinioOssServiceImpl();
        }
        if(ossType.equals("aliyun")){
            return new AliYunOssServiceImpl();
        }
        throw new IllegalArgumentException("找不到StorgerService适配器");

    }

}
