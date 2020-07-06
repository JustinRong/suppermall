package com.justin.suppermall.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jr.
 * @date 2020/6/24 23:56
 */
public class CustomRealm extends AuthorizingRealm {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomRealm.class);


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LOGGER.info("开始进行用户验证");
        String username = (String) authenticationToken.getPrincipal();
        String password = authenticationToken.getCredentials().toString();
        System.out.println("----->username:" + username + "; password:"+password);
        return null;
    }
}
