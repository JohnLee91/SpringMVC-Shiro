package org.seckill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by John Lee on 2017/6/20.
 */
@Aspect
@Component
public class MyLogAspect {

    @Around(value = "@annotation(annotation) &&args(object,..) ", argNames = "pj,annotation,object")
    public Object interceptorWithObject(ProceedingJoinPoint pj,
                                      MyLog annotation, Object object) throws Throwable {
        before();
        System.out.println(annotation.moduleName()+"-------------interceptorWithObject----------"+annotation.option());
        Object result = pj.proceed();
        after();
        return result;
    }


    private void before() {
        System.out.println("------------Before service------------");
    }

    private void after() {
        System.out.println("------------After service-------------");
    }
}
