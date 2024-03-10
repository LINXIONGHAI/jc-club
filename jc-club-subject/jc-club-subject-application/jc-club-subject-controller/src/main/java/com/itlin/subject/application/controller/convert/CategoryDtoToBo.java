package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectCategoryDto;
import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryDtoToBo {
    CategoryDtoToBo INSERT= Mappers.getMapper(CategoryDtoToBo.class);

    SubjectCategoryBo convertDtoToBo(SubjectCategoryDto subjectCategoryDto);


}
