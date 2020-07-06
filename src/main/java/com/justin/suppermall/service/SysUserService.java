package com.justin.suppermall.service;

import com.justin.suppermall.dao.SysUserDao;
import com.justin.suppermall.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jr.
 * @date 2020/6/25 23:05
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    public SysUser getUserByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
