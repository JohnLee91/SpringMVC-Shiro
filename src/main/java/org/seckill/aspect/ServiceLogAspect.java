package org.seckill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.seckill.entity.User;
import org.seckill.util.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by John Lee on 2017/6/29.
 */
@Aspect
@Component
public class ServiceLogAspect {
    /**
     * 注解在带参数的函数上
     * @param pj
     * @param annotation
     * @param object
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(annotation) && args(object,..) ", argNames = "pj,annotation,object")
    public Object interceptorServiceLog(ProceedingJoinPoint pj, ServiceLogAnnotation annotation, Object object) throws Throwable {
        before();
        System.out.println(annotation.moduleName()+"-----------------------"+annotation.option());
        Object result = pj.proceed();

        //通过Request获取之前登录存入的用户信息（用户登录时通过SysUserFilter将user存入Request中）
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        User user = (User)request.getAttribute(Constants.CURRENT_USER);

        if ((int)result > 0){
            System.out.println(user.toString());
            after();
        }

        return result;
    }

    /**
     * 注解在无参数的函数上
     * @param pj
     * @param annotation
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(annotation)&&args()", argNames = "pj,annotation")
    public Object interceptorWithoutObject(ProceedingJoinPoint pj,
                                           ServiceLogAnnotation annotation) throws Throwable {
        before();
        System.out.println(annotation.moduleName()+"-------------interceptorWithoutObject----------"+annotation.option());
        Object result = pj.proceed();

        //通过Request获取之前登录存入的用户信息（用户登录时通过SysUserFilter将user存入Request中）
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        User user = (User)request.getAttribute(Constants.CURRENT_USER);
        System.out.println(user.toString());

        after();
        return result;
    }

    private void before() {
        System.out.println("------------Before------------");
    }

    private void after() {
        System.out.println("------------After-------------");
    }
}
