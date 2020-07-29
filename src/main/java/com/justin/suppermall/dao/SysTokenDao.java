package com.justin.suppermall.dao;

import com.justin.suppermall.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author jr.
 * @date 2020/7/29 15:05
 */
@Component
public interface SysTokenDao extends JpaRepository<SysToken, Long> {

    SysToken findByToken(String token);
}
