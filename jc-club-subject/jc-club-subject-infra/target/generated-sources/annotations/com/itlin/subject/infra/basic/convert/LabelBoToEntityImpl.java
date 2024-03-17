package com.itlin.subject.infra.basic.convert;

import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import com.itlin.subject.infra.basic.entity.SubjectLabel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T19:29:59+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class LabelBoToEntityImpl implements LabelBoToEntity {

    @Override
    public SubjectLabel convertBoToEntity(SubjectLabelBo subjectLabelBo) {
        if ( subjectLabelBo == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setLabelName( subjectLabelBo.getLabelName() );
        subjectLabel.setSortNum( subjectLabelBo.getSortNum() );
        subjectLabel.setCategoryId( subjectLabelBo.getCategoryId() );
        subjectLabel.setCreatedBy( subjectLabelBo.getCreatedBy() );
        subjectLabel.setCreatedTime( subjectLabelBo.getCreatedTime() );
        subjectLabel.setUpdateBy( subjectLabelBo.getUpdateBy() );
        subjectLabel.setUpdateTime( subjectLabelBo.getUpdateTime() );
        subjectLabel.setIsDeleted( subjectLabelBo.getIsDeleted() );

        return subjectLabel;
    }
}
