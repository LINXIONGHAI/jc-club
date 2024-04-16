package com.itlin.auth.domain.service.impl;

import com.itlin.auth.domain.bo.AuthPermissionBo;
import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.convent.PermiaaionConventToEntity;
import com.itlin.auth.domain.convent.RoleConventToEntity;
import com.itlin.auth.domain.service.PremissionServiceDomain;
import com.itlin.auth.domain.service.RoleServiceDomain;
import com.itlin.auth.infra.basic.entity.AuthPermission;
import com.itlin.auth.infra.basic.entity.AuthRole;
import com.itlin.auth.infra.basic.service.AuthPermissionService;
import com.itlin.auth.infra.basic.service.AuthRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PermissionServiceDomainImpl implements PremissionServiceDomain {

    @Resource
    private AuthPermissionService authPermissionService;

    @Override
    public void insert(AuthPermissionBo permissionBo) {
        AuthPermission authPermission = PermiaaionConventToEntity.QUERY.convertToBo(permissionBo);
        authPermissionService.insert(authPermission);
    }
}
