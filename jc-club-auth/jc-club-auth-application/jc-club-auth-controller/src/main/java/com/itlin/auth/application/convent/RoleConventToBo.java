package com.itlin.auth.application.convent;

import com.itlin.auth.application.dto.AuthRoleDto;
import com.itlin.auth.application.dto.AuthUserDto;
import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.bo.AuthUserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleConventToBo {

    RoleConventToBo QUERY = Mappers.getMapper(RoleConventToBo.class);

    AuthRoleBo convertToBo(AuthRoleDto authRoleDto);


}
