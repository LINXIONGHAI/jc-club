package com.itlin.subject.infra.basic.convert;

import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import com.itlin.subject.infra.basic.entity.SubjectCategory;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T19:30:00+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class CategoryBoToEntityImpl implements CategoryBoToEntity {

    @Override
    public SubjectCategory convertToEntity(SubjectCategoryBo subjectCategoryBo) {
        if ( subjectCategoryBo == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setCategoryName( subjectCategoryBo.getCategoryName() );
        subjectCategory.setCategoryType( subjectCategoryBo.getCategoryType() );
        subjectCategory.setImageUrl( subjectCategoryBo.getImageUrl() );
        subjectCategory.setParentId( subjectCategoryBo.getParentId() );
        subjectCategory.setCreatedBy( subjectCategoryBo.getCreatedBy() );
        subjectCategory.setCreatedTime( subjectCategoryBo.getCreatedTime() );
        subjectCategory.setUpdateBy( subjectCategoryBo.getUpdateBy() );
        subjectCategory.setUpdateTime( subjectCategoryBo.getUpdateTime() );
        subjectCategory.setIsDeleted( subjectCategoryBo.getIsDeleted() );

        return subjectCategory;
    }
}
