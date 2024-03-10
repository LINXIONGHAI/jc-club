package com.itlin.subject.infra.basic.convert;

import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import com.itlin.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryBoToEntity {

    CategoryBoToEntity INSERT=Mappers.getMapper(CategoryBoToEntity.class);
    CategoryBoToEntity QUERY=Mappers.getMapper(CategoryBoToEntity.class);
    SubjectCategory convertToEntity(SubjectCategoryBo subjectCategoryBo);



}
