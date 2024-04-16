package com.itlin.subject.application.controller.controller;

import com.itlin.subject.infra.basic.es.SubjectInfoEs;
import com.itlin.subject.infra.basic.es.service.impl.EsSubjectServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

//    @Resource
//    private SubjectInfoEsServiceImpl subjectInfoEsService;

@Resource
private EsSubjectServiceImpl esSubjectService;

    @GetMapping("createIndex")
    public void testes1(){
//        subjectInfoEsService.createIndex();
    }

    @GetMapping("addes")
    public void addes(){
        SubjectInfoEs subjectInfoEs=new SubjectInfoEs();
        subjectInfoEs.setDocId(1L);
        subjectInfoEs.setCreateUser("lin");
        subjectInfoEs.setSubjectAnswer("答案");
        subjectInfoEs.setSubjectName("题目");

        esSubjectService.addDoc(subjectInfoEs);

    }

    @GetMapping("findes")
    public void find(){
//        subjectInfoEsService.find();
    }
}
