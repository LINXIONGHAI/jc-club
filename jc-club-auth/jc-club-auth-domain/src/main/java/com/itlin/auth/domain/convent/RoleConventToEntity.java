package com.itlin.auth.domain.convent;

import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.infra.basic.entity.AuthRole;
import com.itlin.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleConventToEntity {

    RoleConventToEntity QUERY = Mappers.getMapper(RoleConventToEntity.class);

    AuthRole convertToBo(AuthRoleBo authRoleBo);


}
