package com.justin.suppermall.util;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jr.
 * @date 2020/7/29 10:54
 */
public class TokenUtil {
    public static String getRequestToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        return token;
    }
}
