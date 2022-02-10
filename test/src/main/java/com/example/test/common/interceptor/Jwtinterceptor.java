package com.example.test.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.test.entity.Admin;
import com.example.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jwtinterceptor implements HandlerInterceptor {
    @Autowired
    private AdminService adminService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception
    {
        String token=request.getHeader("token");
        if(!(handle instanceof HandlerMethod))
        {
            return  true;
        }
        //执行认证
        if(StrUtil.isBlankIfStr(token))
        {
            throw new RuntimeException("无token,请重新登录");
        }
        //获取token中 userId
        String userId;
        try {
            userId= JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j)
        {
            throw new RuntimeException("token验证失败");
        }
        //根据token中的userId查询数据库
        Admin admin=adminService.getById(userId);
        if(admin==null)
        {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        //用户密码加签验证 token
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException j)
        {
            throw new RuntimeException("token验证失败,请重新登录");
        }
        return true;

    }

}
