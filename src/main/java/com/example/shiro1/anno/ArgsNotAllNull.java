package com.example.shiro1.anno;

import com.example.shiro1.vo.UserInfoVO;

import java.lang.annotation.*;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-4:31
 * @Description: 方法上多个参数不能同时为空
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArgsNotAllNull {

    boolean result() default false;

}
