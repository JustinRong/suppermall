package com.justin.suppermall.dao;

import com.justin.suppermall.entity.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:52
 */
@Component
public interface SysRolePermissionDao extends JpaRepository<SysRolePermission, Long> {

    List<SysRolePermission> findByRoleId(Long roleId);
}
