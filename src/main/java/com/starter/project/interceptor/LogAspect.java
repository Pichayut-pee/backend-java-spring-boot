package com.starter.project.interceptor;

import com.starter.project.annotation.LogAssociation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class LogAspect {

    private static final Logger logger = Logger.getLogger(String.valueOf(LogAspect.class));

    @Around(
      "@within(logAssociation) || @annotation(logAssociation)"
    )
    public Object checkAspect(ProceedingJoinPoint joinPoint,
                              LogAssociation logAssociation) throws Throwable {

            logger.info("Before Execute : "+ joinPoint.getTarget().getClass());

            try {
                Object ret = joinPoint.proceed();
                logger.info("After Execute : "+ joinPoint.getTarget().getClass());
                return ret;
            } catch (Exception ex) {
                logger.severe("Exception at :" + joinPoint.getTarget().getClass() +" : " + ex);
                throw ex;
            }
    }

}
