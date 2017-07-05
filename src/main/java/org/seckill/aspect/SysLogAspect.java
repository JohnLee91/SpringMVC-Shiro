package org.seckill.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.seckill.entity.SysLog;
import org.seckill.entity.User;
import org.seckill.service.SysLogService;
import org.seckill.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by John Lee on 2017/6/29.
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    private Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

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
        try {
            before();
            System.out.println(annotation.moduleName()+"-----------------------"+annotation.option());
            Object result = pj.proceed();

            if (object instanceof Number)//如果是delete，传入的是删除的id，为数字，返回结果result才是实体类
                after(annotation,result);
            else//如果是insert和update，传递参数为实体类，直接使用
                after(annotation,object);

            return result;
        }catch (Exception e){
            logger.error(e.toString());
        }

        return null;
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

        //after();
        return result;
    }

    private void before() {
        System.out.println("------------Before------------");
    }

    private void after(ServiceLogAnnotation annotation,Object object) {
        //通过Request获取之前登录存入的用户信息（用户登录时通过SysUserFilter将user存入Request中）
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        User user = (User)request.getAttribute(Constants.CURRENT_USER);

        SysLog sysLog = new SysLog();
        sysLog.setUserId(user.getId());
        sysLog.setUsername(user.getUsername());
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setModuleName(annotation.moduleName());
        sysLog.setOptions(annotation.option());
        sysLog.setContent(object.toString());
        sysLog.setOptTime(new Date());

        sysLogService.insertLog(sysLog);
        logger.info(sysLog.toString());

        System.out.println("------------After-------------");
    }
}
