package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectCategoryDto;
import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T19:30:03+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class CategoryDtoToBoImpl implements CategoryDtoToBo {

    @Override
    public SubjectCategoryBo convertDtoToBo(SubjectCategoryDto subjectCategoryDto) {
        if ( subjectCategoryDto == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setCategoryName( subjectCategoryDto.getCategoryName() );
        subjectCategoryBo.setCategoryType( subjectCategoryDto.getCategoryType() );
        subjectCategoryBo.setImageUrl( subjectCategoryDto.getImageUrl() );
        subjectCategoryBo.setParentId( subjectCategoryDto.getParentId() );
        subjectCategoryBo.setCreatedBy( subjectCategoryDto.getCreatedBy() );
        subjectCategoryBo.setCreatedTime( subjectCategoryDto.getCreatedTime() );
        subjectCategoryBo.setUpdateBy( subjectCategoryDto.getUpdateBy() );
        subjectCategoryBo.setUpdateTime( subjectCategoryDto.getUpdateTime() );
        subjectCategoryBo.setIsDeleted( subjectCategoryDto.getIsDeleted() );

        return subjectCategoryBo;
    }
}
