package com.itlin.auth.application.controller;

import com.itlin.auth.application.convent.PermissionConventToBo;
import com.itlin.auth.application.convent.RoleConventToBo;
import com.itlin.auth.application.dto.AuthPermissionDto;
import com.itlin.auth.application.dto.AuthRoleDto;
import com.itlin.auth.commom.utils.Result;
import com.itlin.auth.domain.bo.AuthPermissionBo;
import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.service.PremissionServiceDomain;
import com.itlin.auth.domain.service.RoleServiceDomain;
import com.itlin.auth.domain.service.UserServiceDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permssion")
public class PremissionController {


    @Resource
    private PremissionServiceDomain premissionServiceDomain;

    // 新增角色
    @PostMapping("inset")
    public Result<Boolean> inset(@RequestBody AuthPermissionDto authPermissionDto) {
        AuthPermissionBo authPermissionBo = PermissionConventToBo.QUERY.convertToBo(authPermissionDto);
        premissionServiceDomain.insert(authPermissionBo);
        return Result.ok(true);


    }



}
