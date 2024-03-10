package com.itlin.subject.infra.basic.handler.subject;

import com.itlin.subject.infra.basic.emuns.SubjectHandleEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SubjectHandleFactory implements InitializingBean {


    @Autowired
    private List<SubjectInsertHandle> subjectInsertHandleList;


    Map<SubjectHandleEnum, SubjectInsertHandle> map = new HashMap<>();


    public SubjectInsertHandle getHandle(int subjectType) {
        SubjectInsertHandle subjectInsertHandle = map.get(SubjectHandleEnum.getByType(subjectType));
        return subjectInsertHandle;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectInsertHandle subjectInsertHandle : subjectInsertHandleList) {
            map.put(subjectInsertHandle.getType(), subjectInsertHandle);
        }

    }
}
