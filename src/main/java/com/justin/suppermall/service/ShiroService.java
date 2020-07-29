package com.justin.suppermall.service;

import com.justin.suppermall.entity.SysToken;

/**
 * @author jr.
 * @date 2020/7/29 14:49
 */
public interface ShiroService {

    SysToken findByToken(String token);
}
