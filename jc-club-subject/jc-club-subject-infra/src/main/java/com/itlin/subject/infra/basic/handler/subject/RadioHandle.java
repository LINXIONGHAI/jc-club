package com.itlin.subject.infra.basic.handler.subject;

import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import com.itlin.subject.infra.basic.emuns.SubjectHandleEnum;
import com.itlin.subject.infra.basic.service.SubjectRadioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 单选
 */
@Component
@Slf4j
public class RadioHandle implements  SubjectInsertHandle{

    @Autowired
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectHandleEnum getType() {
        return SubjectHandleEnum.getByType(1);
    }

    @Override
    public void add(SubjectInfoBo subjectInfoBo) {
        if(log.isInfoEnabled()){
            log.info("RadioHandle : add : subjectInfoBo: {}",subjectInfoBo);
        }

    }
}
