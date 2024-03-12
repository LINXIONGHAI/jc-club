package com.itlin.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${oss.config.url}")
    private String url;

    @Value("${oss.config.accessKey}")
    private String accessKey;

    @Value("${oss.config.secretKey}")
    private String secretKey;





    @Bean
    public MinioClient minioClient(){

        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }

}
