package com.justin.suppermall.dao;

import com.justin.suppermall.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jr.
 * @date 2020/7/29 16:26
 */
@Component
public interface SysUserRoleDao extends JpaRepository<SysUserRole, Long> {

    List<SysUserRole> findByUserId(Long userId);
}
