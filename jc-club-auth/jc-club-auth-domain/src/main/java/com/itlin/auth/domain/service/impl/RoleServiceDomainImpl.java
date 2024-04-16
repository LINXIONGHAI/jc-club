package com.itlin.auth.domain.service.impl;

import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.domain.constant.RoleKeyConstant;
import com.itlin.auth.domain.convent.RoleConventToEntity;
import com.itlin.auth.domain.convent.UserConventToEntity;
import com.itlin.auth.domain.service.RoleServiceDomain;
import com.itlin.auth.domain.service.UserServiceDomain;
import com.itlin.auth.infra.basic.entity.AuthRole;
import com.itlin.auth.infra.basic.entity.AuthUser;
import com.itlin.auth.infra.basic.entity.AuthUserRole;
import com.itlin.auth.infra.basic.service.AuthRoleService;
import com.itlin.auth.infra.basic.service.AuthUserRoleService;
import com.itlin.auth.infra.basic.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class RoleServiceDomainImpl implements RoleServiceDomain {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public void insert(AuthRoleBo authRoleBo) {
        AuthRole authRole = RoleConventToEntity.QUERY.convertToBo(authRoleBo);
        authRoleService.insert(authRole);
    }
}
