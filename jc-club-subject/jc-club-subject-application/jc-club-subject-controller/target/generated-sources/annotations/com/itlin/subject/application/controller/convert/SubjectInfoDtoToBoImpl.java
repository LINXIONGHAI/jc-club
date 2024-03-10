package com.itlin.subject.application.controller.convert;

import com.itlin.subject.application.controller.dto.SubjectInfoDto;
import com.itlin.subject.infra.basic.bo.SubjectInfoBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T11:37:03+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class SubjectInfoDtoToBoImpl implements SubjectInfoDtoToBo {

    @Override
    public SubjectInfoBo convertDtoToBo(SubjectInfoDto subjectInfoDto) {
        if ( subjectInfoDto == null ) {
            return null;
        }

        SubjectInfoBo subjectInfoBo = new SubjectInfoBo();

        subjectInfoBo.setId( subjectInfoDto.getId() );
        subjectInfoBo.setSubjectName( subjectInfoDto.getSubjectName() );
        subjectInfoBo.setSubjectDifficult( subjectInfoDto.getSubjectDifficult() );
        subjectInfoBo.setSettleName( subjectInfoDto.getSettleName() );
        subjectInfoBo.setSubjectType( subjectInfoDto.getSubjectType() );
        subjectInfoBo.setSubjectScore( subjectInfoDto.getSubjectScore() );
        subjectInfoBo.setSubjectParse( subjectInfoDto.getSubjectParse() );
        subjectInfoBo.setCreatedBy( subjectInfoDto.getCreatedBy() );
        subjectInfoBo.setCreatedTime( subjectInfoDto.getCreatedTime() );
        subjectInfoBo.setUpdateBy( subjectInfoDto.getUpdateBy() );
        subjectInfoBo.setUpdateTime( subjectInfoDto.getUpdateTime() );
        subjectInfoBo.setIsDeleted( subjectInfoDto.getIsDeleted() );

        return subjectInfoBo;
    }
}
