package com.justin.suppermall.config;

import com.justin.suppermall.dao.SysPermissionDao;
import com.justin.suppermall.dao.SysRoleDao;
import com.justin.suppermall.dao.SysUserDao;
import com.justin.suppermall.entity.*;
import com.justin.suppermall.service.ShiroService;
import com.justin.suppermall.service.SysRolePermissionService;
import com.justin.suppermall.service.SysUserRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author jr.
 * @date 2020/6/24 23:56
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysPermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<SysUserRole> userRoles = sysUserRoleService.findByUserId(sysUser.getId());
        if (!userRoles.isEmpty()) {
            for (SysUserRole userRole : userRoles) {
                SysRole role = sysRoleDao.getOne(userRole.getRoleId());
                simpleAuthorizationInfo.addRole(role.getRoleName());
                List<SysRolePermission> rolePermission = sysRolePermissionService.findByRoleId(userRole.getRoleId());
                if (!rolePermission.isEmpty()) {
                    for (SysRolePermission p : rolePermission) {
                        SysPermission permission = permissionDao.getOne(p.getPermissionId());
                        simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证，判断token的有效性
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LOGGER.info("开始进行用户验证");
        //获取token，既前端传入的token
        String accessToken  = (String) token.getPrincipal();
        // 根据accessToken，查询用户信息
        SysToken sysToken = shiroService.findByToken(accessToken);
        // token失效
        if (Objects.isNull(sysToken) || sysToken.getExpireTime().isBefore(LocalDateTime.now())) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 调用数据库的方法，从数据库中查询username对应的用户记录
        Optional<SysUser> sysUser = sysUserDao.findById(sysToken.getUserId());
        SysUser user = sysUser.get();
        if (Objects.isNull(user)) {
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(user, accessToken, this.getName());
    }
}
