package com.justin.suppermall.controller;

import com.justin.suppermall.entity.SysUser;
import com.justin.suppermall.service.SysUserService;
import com.justin.suppermall.util.MD5Utils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * @author jr.
 * @date 2020/6/25 23:09
 */
@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/sys/login")
    @ApiOperation(value = "登录")
    public String login(@RequestBody @Validated Map<String, Object> data) {
        SysUser sysUser = sysUserService.getUserByUsername(data.get("username").toString());
        if (Objects.isNull(sysUser)) {
            return "此用户为空";
        }
        boolean isUser = MD5Utils.getSaltverifyMD5(data.get("password").toString(), sysUser.getPassword());
        if (isUser) {
            return "登录成功";
        }
        return "用户名密码错误";
    }

    @GetMapping("/notRole")
    public String notRole() {
        return "无角色权限";
    }
}
