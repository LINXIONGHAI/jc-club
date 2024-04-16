package com.itlin.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itlin.gateway.redis.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义权限验证接口扩展 
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    //角色前缀
    private static  final  String authRole="auth.role";
    //权限前缀
    private static  final  String authPermission="auth.Permission";
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        String buildKey = redisUtil.buildKey(loginId.toString(),authPermission );
        String redisVal = redisUtil.get(buildKey);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> list=gson.fromJson(redisVal, listType);
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        String buildKey = redisUtil.buildKey(loginId.toString(),authRole );
        String redisVal = redisUtil.get(buildKey);
        return new Gson().fromJson(redisVal,List.class);
    }

}
