package com.justin.suppermall.service.impl;

import com.justin.suppermall.dao.SysUserRoleDao;
import com.justin.suppermall.entity.SysUserRole;
import com.justin.suppermall.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:28
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public List<SysUserRole> findByUserId(Long userId) {
        return sysUserRoleDao.findByUserId(userId);
    }
}
