package com.example.shiro1.controller;

import com.example.shiro1.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-19:32
 * @Description: 描述
 */
@Controller
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

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    /***********************************************************************************************************/
    /****************************************          shiro功能练习        ************************************/
    /***********************************************************************************************************/
    /**
     * 点击登录后的操作
     * @param user 用户
     * @return
     */
    @PostMapping("/post/login")
    public String doLogin(@RequestBody User user, Model model) {
        logger.info("进入登录处理");
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        model.addAttribute("page", "page1");
        model.addAttribute("frg", "page1");
        return "main";
    }

    //注解验角色和权限
    @RequiresRoles("超级管理")
    @RequiresPermissions("系统管理")
    @RequestMapping("/goMain")
    public String goMain(Model model) {
        model.addAttribute("page", "page1");
        model.addAttribute("frg", "page1");
        return "main";
    }

}
