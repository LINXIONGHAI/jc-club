package com.itlin.subject.domain.service;

import com.itlin.subject.infra.basic.bo.SubjectInfoBo;

public interface SubjectServiceDomain {
    /**
     * 题目插入
     * @param subjectInfoBo
     */
    void insetSubject(SubjectInfoBo subjectInfoBo);

    SubjectInfoBo querySubject(SubjectInfoBo subjectInfoBo);
}
