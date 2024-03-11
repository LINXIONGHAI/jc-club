package com.itlin.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("com.itlin")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);

    }
}
