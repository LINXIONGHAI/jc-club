package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectLabelDto;
import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T15:48:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class LabelToBoImpl implements LabelToBo {

    @Override
    public SubjectLabelBo convertToBo(SubjectLabelDto subjectLabelDto) {
        if ( subjectLabelDto == null ) {
            return null;
        }

        SubjectLabelBo subjectLabelBo = new SubjectLabelBo();

        subjectLabelBo.setLabelName( subjectLabelDto.getLabelName() );
        subjectLabelBo.setSortNum( subjectLabelDto.getSortNum() );
        subjectLabelBo.setCategoryId( subjectLabelDto.getCategoryId() );
        subjectLabelBo.setCreatedBy( subjectLabelDto.getCreatedBy() );
        subjectLabelBo.setCreatedTime( subjectLabelDto.getCreatedTime() );
        subjectLabelBo.setUpdateBy( subjectLabelDto.getUpdateBy() );
        subjectLabelBo.setUpdateTime( subjectLabelDto.getUpdateTime() );
        subjectLabelBo.setIsDeleted( subjectLabelDto.getIsDeleted() );

        return subjectLabelBo;
    }
}
