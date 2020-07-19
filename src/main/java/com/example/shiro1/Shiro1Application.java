package com.example.shiro1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication(scanBasePackages = "com.example.shiro1")
@MapperScan(basePackages = "com.example.shiro1.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Shiro1Application extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(Shiro1Application.class, args);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源的路径
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }
}
