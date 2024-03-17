package com.itlin.subject.application.controller.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${sub.mvv}")
    private Long mvcc;

    @GetMapping("/test")

    public Long tet() {

        return mvcc;
    }
}
