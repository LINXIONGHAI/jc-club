package com.itlin.auth.domain.convent;

import com.itlin.auth.domain.bo.AuthPermissionBo;
import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.infra.basic.entity.AuthPermission;
import com.itlin.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermiaaionConventToEntity {

    PermiaaionConventToEntity QUERY = Mappers.getMapper(PermiaaionConventToEntity.class);

    AuthPermission convertToBo(AuthPermissionBo authPermissionBo);


}
