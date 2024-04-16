package com.itlin.auth.application.convent;

import com.itlin.auth.application.dto.AuthPermissionDto;
import com.itlin.auth.application.dto.AuthRoleDto;
import com.itlin.auth.domain.bo.AuthPermissionBo;
import com.itlin.auth.domain.bo.AuthRoleBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionConventToBo {

    PermissionConventToBo QUERY = Mappers.getMapper(PermissionConventToBo.class);

    AuthPermissionBo convertToBo(AuthPermissionDto authPermissionDto);


}
