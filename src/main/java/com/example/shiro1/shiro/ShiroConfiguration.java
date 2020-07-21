package com.example.shiro1.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-19:16
 * @Description: 描述
 */
@Configuration
public class ShiroConfiguration {
    /**
     * anno:无需认证（登陆）可以访问
     * authc:必须认证才能访问
     * user：如果使用rememberMe的功能可以直接访问
     * perms:该资源必须得到资源权限可以访问
     * role:该资源必须得到角色权限才能访问
     */
    private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        logger.info("进入shiroFilter......");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置不需要拦截的路径
        Map<String,String> map = new LinkedHashMap<String, String>();
        //按顺序依次判断
        map.put("/static/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        map.put("/logout", "logout");

        /************************************初始化所有的权限信息开始******************************************/
        //这里，如果以后再项目中使用的话，直接从数据库中查询
        //filterChainDefinitionMap.put("/user/list", "authc,perms[user:list]");
        //filterChainDefinitionMap.put("/user/add", "authc,perms[user:add]");
        /***************************************初始化所有的权限信息结束*********************************************/
        map.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/main");
        //未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 将自己的验证方式加入容器
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        //后面这里可以设置缓存的机制
        return myShiroRealm;
    }

    /**
     * 权限管理，配置主要是Realm的管理认证
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
