package com.justin.suppermall.controller;

import com.justin.suppermall.entity.SysUser;
import com.justin.suppermall.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jr.
 * @date 2020/6/25 23:09
 */
@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login")
    public String login(String username, String password) {
        SysUser sysUser = sysUserService.getUserByUsername("");
        if (sysUser == null) {
            System.out.println("此用户为空");
        }
        return "";
    }

    @GetMapping("/notRole")
    public String notRole() {
        return "无角色权限";
    }
}
