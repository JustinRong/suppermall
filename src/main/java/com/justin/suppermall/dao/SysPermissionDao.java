package com.justin.suppermall.dao;

import com.justin.suppermall.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author jr.
 * @date 2020/7/29 17:00
 */
@Component
public interface SysPermissionDao extends JpaRepository<SysPermission, Long> {
}
