package com.itlin.subject.infra.basic.handler.subject;

import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import com.itlin.subject.infra.basic.emuns.SubjectHandleEnum;
import com.itlin.subject.infra.basic.entity.SubjectInfo;

public interface SubjectInsertHandle {

    /**
     * 枚举身份呢识别
     * @return
     */
    SubjectHandleEnum getType();

    /**
     * 题目插入
     * @param subjectInfoBo
     */
    void add(SubjectInfoBo subjectInfoBo);



}
