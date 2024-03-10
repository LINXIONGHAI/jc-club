package com.itlin.subject.infra.basic.convert;

import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import com.itlin.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabelBoToEntity {

    LabelBoToEntity QUERY= Mappers.getMapper(LabelBoToEntity.class);

    SubjectLabel convertBoToEntity(SubjectLabelBo subjectLabelBo);


}
