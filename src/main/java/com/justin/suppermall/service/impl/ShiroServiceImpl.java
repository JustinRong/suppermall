package com.justin.suppermall.service.impl;

import com.justin.suppermall.dao.SysTokenDao;
import com.justin.suppermall.entity.SysToken;
import com.justin.suppermall.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jr.
 * @date 2020/7/29 15:07
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private SysTokenDao sysTokenDao;


    @Override
    public SysToken findByToken(String token) {
        return sysTokenDao.findByToken(token);
    }
}
