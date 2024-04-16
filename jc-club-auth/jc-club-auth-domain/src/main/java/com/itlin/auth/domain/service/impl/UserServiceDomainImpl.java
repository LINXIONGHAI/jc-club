package com.itlin.auth.domain.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.gson.Gson;
import com.itlin.auth.commom.utils.Result;
import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.domain.constant.RoleKeyConstant;
import com.itlin.auth.domain.convent.UserConventToEntity;
import com.itlin.auth.domain.redis.RedisUtil;
import com.itlin.auth.domain.service.UserServiceDomain;
import com.itlin.auth.infra.basic.dao.AuthRoleDao;
import com.itlin.auth.infra.basic.dao.AuthUserDao;
import com.itlin.auth.infra.basic.entity.*;
import com.itlin.auth.infra.basic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceDomainImpl implements UserServiceDomain {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;
    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    //角色前缀
    private static final String authRolePre = "auth.role";
    //权限前缀
    private static final String authPermissionPre = "auth.Permission";

    //注册
    @Transactional
    @Override
    public String registe(AuthUserBo authUserBo) {
        //1、插入用户信息
        AuthUser authUser = UserConventToEntity.QUERY.convertToBo(authUserBo);
        authUserService.insert(authUser);
        log.info("auth : UserServiceDomainImpl: registe : id:{}", authUser.getId());
        Long userId = authUser.getId();
        //2、插入用户和角色关联
        //2.1查询角色的id
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(RoleKeyConstant.NONMLE_USER);
        AuthRole roleVal = authRoleService.query(authRole);
        //获得roleid
        Long roleId = roleVal.getId();
        //2.2插入关联角色
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        authUserRoleService.insert(authUserRole);
        //缓存交互
        String roleKey = redisUtil.buildKey(userId.toString(), authRolePre);
        String permissionKey = redisUtil.buildKey(userId.toString(), authPermissionPre);
        //1、删除key
        redisUtil.del(roleKey);
        redisUtil.del(permissionKey);
        //2、用户权限角色同步到redis
        //3、根据用户用户id查询auth_user_role拿到roleList
        AuthUserRole authUserRole1 = new AuthUserRole();
        authUserRole1.setUserId(userId);
        List<AuthUserRole> authUserRoleList = authUserRoleService.query(authUserRole1);
        //4、根据roleList的roleId
        List<Long> roleList = authUserRoleList.stream().map(authUserRole2 -> authUserRole2.getRoleId()).collect(Collectors.toList());
        //5、查询auth_role拿到List<role>
        List<AuthRole> authRoles = authRoleService.bacheRole(roleList);
        //6、role_key的列表
        List<String> redisRoleList = authRoles.stream().map(authRole1 -> authRole1.getRoleKey()).collect(Collectors.toList());
        //获取权限列表
        List<Long> roleIds = authRoles.stream().map(authRole1 -> authRole1.getId()).collect(Collectors.toList());
        List<AuthRolePermission> permisList = authRolePermissionService.queryByList(roleIds);
        List<Long> presionList = permisList.stream().map(authRolePermission -> authRolePermission.getPermissionId()).collect(Collectors.toList());
        List<AuthPermission> permissionList=authPermissionService.queryByList(presionList);
        List<String> pressionKeyList = permissionList.stream().map(authPermission -> authPermission.getPermissionKey()).collect(Collectors.toList());

        //role_key列表缓存到redis
        redisUtil.setNx(roleKey, new Gson().toJson(redisRoleList), 24L, TimeUnit.HOURS);
        redisUtil.setNx(permissionKey, new Gson().toJson(pressionKeyList), 24L, TimeUnit.HOURS);

        return userId.toString();

    }


    @SentinelResource(value = "testSentinel", blockHandler = "testSentinelException")
    public Result testSentinel(){
        System.out.println("进入testSentinel。。。。。。");
        return Result.ok("进入testSentinel");
    }


    @Override
    public Result valid(String valid) {
        if(StringUtils.isEmpty(valid)){
            return Result.fail("验证码不能为空");
        }
        String redisVal = redisUtil.get(valid);
        if (StringUtils.isEmpty(redisVal)) {
            return Result.fail("验证码无效");
        }
        redisUtil.del(valid);
        AuthUser authUser = new AuthUser();
        authUser.setNickName(redisVal);
        AuthUser user=authUserService.query(authUser);
        if(user!=null){
            StpUtil.login(user.getId().toString());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return Result.ok(tokenInfo);
        }

        AuthUserBo authUserBo = new AuthUserBo();
        authUserBo.setNickName(redisVal);
        String userId = this.registe(authUserBo);
        StpUtil.login(userId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return Result.ok(tokenInfo);

    }

    public Result testSentinelException(BlockException e){
        log.info("testSentinel 熔断。。。。");
       throw  new   RuntimeException("人数过多");
    }
}
