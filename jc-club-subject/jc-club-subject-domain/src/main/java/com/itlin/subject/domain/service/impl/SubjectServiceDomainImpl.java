package com.itlin.subject.domain.service.impl;

import com.itlin.subject.domain.service.SubjectServiceDomain;
import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import com.itlin.subject.infra.basic.handler.subject.SubjectHandleFactory;
import com.itlin.subject.infra.basic.handler.subject.SubjectInsertHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceDomainImpl implements SubjectServiceDomain {

    @Autowired
    private SubjectHandleFactory subjectHandleFactory;
    /**
     * 题目插入
     * @param subjectInfoBo
     */
    @Override
    public void insetSubject(SubjectInfoBo subjectInfoBo) {

        SubjectInsertHandle handle = subjectHandleFactory.getHandle(subjectInfoBo.getSubjectType());
        handle.add(subjectInfoBo);

    }
}
