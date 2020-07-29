package com.justin.suppermall.service;

import com.justin.suppermall.entity.SysRolePermission;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:51
 */
public interface SysRolePermissionService {

    List<SysRolePermission> findByRoleId(Long roleId);
}
