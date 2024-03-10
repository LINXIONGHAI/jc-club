package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectInfoDto;
import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectInfoDtoToBo {

    SubjectInfoDtoToBo INSERT=Mappers.getMapper(SubjectInfoDtoToBo.class);
    SubjectInfoBo convertDtoToBo(SubjectInfoDto subjectInfoDto);



}
