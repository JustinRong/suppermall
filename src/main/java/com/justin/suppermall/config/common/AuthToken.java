package com.justin.suppermall.config.common;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author jr.
 * @date 2020/7/29 11:01
 */
public class AuthToken extends UsernamePasswordToken {

    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
