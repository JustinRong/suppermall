package com.justin.suppermall.dao;

import com.justin.suppermall.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author jr.
 * @date 2020/6/25 20:28
 */
@Component
public interface SysUserDao extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
