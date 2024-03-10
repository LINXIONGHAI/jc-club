package com.itlin.subject.infra.basic.handler.subject;

import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import com.itlin.subject.infra.basic.emuns.SubjectHandleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 简答
 */
@Component
@Slf4j
public class BriefHandle implements  SubjectInsertHandle{
    @Override
    public SubjectHandleEnum getType() {
        return SubjectHandleEnum.getByType(4);
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        System.out.println(4+" 简答");

    }
}
