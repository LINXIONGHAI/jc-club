package com.itlin.subject.infra.basic.handler.subject;

import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import com.itlin.subject.infra.basic.emuns.SubjectHandleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 多选
 */
@Component
@Slf4j
public class MultipleHandle implements  SubjectInsertHandle{
    @Override
    public SubjectHandleEnum getType() {
        return SubjectHandleEnum.getByType(2);
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        System.out.println(2+" 多选");

    }

    @Override
    public SubjectInfoBo query(int subjectId) {
        System.out.println("query MultipleHandle");
        return null;
    }
}
