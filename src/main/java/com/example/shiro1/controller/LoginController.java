package com.example.shiro1.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-19:32
 * @Description: 描述
 */
//@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 进入登录界面
     * @return login
     */
    @GetMapping("/login")
    public String getLogin(){
        logger.info("进入login页面");
        return "login";
    }

    /**
     * 点击登录后的操作
     * @param req request
     * @param model
     * @return
     */
    @PostMapping("/login")
    public String doLogin(String username,
                          String password,
                          HttpServletRequest req,
                          Map<String, Object> model) {
        logger.info("进入登录处理");
        boolean authenticated = SecurityUtils.getSubject().isAuthenticated();
        if (authenticated) {
            return "index";
        }
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
