package com.itlin.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.itlin.auth.application.convent.RoleConventToBo;
import com.itlin.auth.application.convent.UserConventToBo;
import com.itlin.auth.application.dto.AuthRoleDto;
import com.itlin.auth.application.dto.AuthUserDto;
import com.itlin.auth.commom.utils.Result;
import com.itlin.auth.domain.bo.AuthRoleBo;
import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.domain.service.RoleServiceDomain;
import com.itlin.auth.domain.service.UserServiceDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class RoleController {


    @Resource
    private RoleServiceDomain roleServiceDomain;

    // 新增角色
    @PostMapping("inset")
    public Result<Boolean> inset(@RequestBody AuthRoleDto authRoleDto) {
        AuthRoleBo authRoleBo = RoleConventToBo.QUERY.convertToBo(authRoleDto);
        roleServiceDomain.insert(authRoleBo);
        return Result.ok(true);


    }



}
