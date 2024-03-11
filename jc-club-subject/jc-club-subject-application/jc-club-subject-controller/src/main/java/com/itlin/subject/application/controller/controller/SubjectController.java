package com.itlin.subject.application.controller.controller;

import com.itlin.subject.application.controller.convert.SubjectInfoDtoToBo;
import com.itlin.subject.application.controller.dto.SubjectInfoDto;
import com.itlin.subject.common.utils.Result;
import com.itlin.subject.domain.service.SubjectServiceDomain;
import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceDomain subjectServiceDomain;

    /**
     * 题目插入
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("/add")
    public Result inset(@RequestBody SubjectInfoDto subjectInfoDto) {
        SubjectInfoBo subjectInfoBo = SubjectInfoDtoToBo.INSERT.convertDtoToBo(subjectInfoDto);
         subjectServiceDomain.insetSubject(subjectInfoBo);
        return Result.ok();

    }
    /**
     * 题目详情
     * @param subjectInfoDto
     * @return
     */
    @PostMapping("/querySubjectInfo")
    public Result querySubjectInfo(@RequestBody SubjectInfoDto subjectInfoDto) {
        SubjectInfoBo subjectInfoBo = SubjectInfoDtoToBo.INSERT.convertDtoToBo(subjectInfoDto);
        SubjectInfoBo bo=subjectServiceDomain.querySubject(subjectInfoBo);
        return Result.ok(bo);

    }
}
