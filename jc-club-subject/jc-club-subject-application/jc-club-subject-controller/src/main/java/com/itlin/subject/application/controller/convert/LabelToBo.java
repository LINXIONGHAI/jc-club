package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectLabelDto;
import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabelToBo {

    LabelToBo QUERY = Mappers.getMapper(LabelToBo.class);

    SubjectLabelBo convertToBo(SubjectLabelDto subjectLabelDto);


}
