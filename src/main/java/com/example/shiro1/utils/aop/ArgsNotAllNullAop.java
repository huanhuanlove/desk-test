package com.example.shiro1.utils.aop;

import com.example.shiro1.vo.UserAllMenuVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: kang
 * @Company: 康康小课堂
 * @DateTime: 2020-07-18-4:56
 * @Description: 描述
 */
@Aspect
@Component
public class ArgsNotAllNullAop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 创建一个ExpressionParser对象，用于解析表达式
    private ExpressionParser parser = new SpelExpressionParser();

    //上下文
    private StandardEvaluationContext evaluation = new StandardEvaluationContext();

    @Pointcut("@annotation(com.example.shiro1.anno.ArgsNotAllNull)")
    public void annotationPoinCut(){}

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around(value = "annotationPoinCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args1 = joinPoint.getArgs();
        if (args1.length <= 0){
            logger.error("error", "用户名或电话都为空");
            throw new RuntimeException("用户名或电话都为空");
        }

        Object[] tmp = new Object[2];
        String str1 = args1[0].toString();
        String str2 = args1[1].toString();
        tmp[0] = str1;
        tmp[1] = str2;

        //执行方法
        Object proceed = joinPoint.proceed(tmp);
        System.out.println("执行成功返回true:" + proceed);
        List<UserAllMenuVO> list = (List<UserAllMenuVO>) proceed;
        return list;
    }
}
