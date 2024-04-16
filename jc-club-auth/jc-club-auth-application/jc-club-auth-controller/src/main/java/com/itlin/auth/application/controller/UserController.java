package com.itlin.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itlin.auth.application.convent.UserConventToBo;
import com.itlin.auth.application.dto.AuthUserDto;
import com.itlin.auth.commom.utils.Result;
import com.itlin.auth.domain.bo.AuthUserBo;
import com.itlin.auth.domain.service.UserServiceDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Resource
    private UserServiceDomain userServiceDomain;

    // 注册
    @RequestMapping("regist")
    public Result regist(@RequestParam String valid) {
//        AuthUserBo authUserBo = UserConventToBo.QUERY.convertToBo(authUserDto);‘
        valid= valid.toUpperCase();
        return userServiceDomain.valid(valid);

    }

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
            StpUtil.login("8");
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);

    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        System.out.println("isLogin");
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @SentinelResource(value = "userTestSentinel",blockHandler = "BlockTestSentinel")
    @RequestMapping("testSentinel")
    public Result testSentinel(){
        return userServiceDomain.testSentinel();
    }

    public Result BlockTestSentinel(BlockException e) {
        log.error("BlockTestSentinel : 限流");
        return Result.fail();
    }
}
