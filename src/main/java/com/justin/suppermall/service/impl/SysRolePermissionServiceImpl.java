package com.justin.suppermall.service.impl;

import com.justin.suppermall.dao.SysRolePermissionDao;
import com.justin.suppermall.entity.SysRolePermission;
import com.justin.suppermall.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:53
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionDao sysRolePermissionDao;

    @Override
    public List<SysRolePermission> findByRoleId(Long roleId) {
        return sysRolePermissionDao.findByRoleId(roleId);
    }
}
