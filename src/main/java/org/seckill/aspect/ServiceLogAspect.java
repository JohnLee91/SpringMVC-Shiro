package org.seckill.aspect;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.seckill.entity.User;
import org.seckill.util.CurrentUser;
import org.springframework.stereotype.Component;

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
//        System.out.println("+++++++++++++++"+loginUser.getUsername()+"+++++++++++++++");
        if ((int)result > 0){
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            System.out.println(object.toString());
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
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
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
