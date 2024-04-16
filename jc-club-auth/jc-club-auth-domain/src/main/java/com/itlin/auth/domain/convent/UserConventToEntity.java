package com.itlin.auth.domain.convent;

import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConventToEntity {

    UserConventToEntity QUERY = Mappers.getMapper(UserConventToEntity.class);

    AuthUser convertToBo(AuthUserBo authUserBo);


}
