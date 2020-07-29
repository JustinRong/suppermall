package com.justin.suppermall.service;

import com.justin.suppermall.entity.SysUserRole;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:27
 */
public interface SysUserRoleService {

    List<SysUserRole> findByUserId(Long userId);
}
