package com.example.shiro1.utils;

import com.example.shiro1.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-19:08
 * @Description: 描述
 */
@Component
public class UserSessionInfo {

    private static HttpServletRequest request;

    private static HttpServletResponse response;
    /**
     * 获取已登陆的用户名
     */
    public static String getSessionUserName(){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userinfo");
        return user.getUsername();
    }

    /**
     * 获取已经登录的用户信息
     */
    public static User getSessionUser(){
        HttpSession session = request.getSession();
        return (User) session.getAttribute("userinfo");
    }
}
