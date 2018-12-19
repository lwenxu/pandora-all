package com.lwen.pandora.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintStackErrorAdvice {
    Logger logger = LoggerFactory.getLogger(PrintStackErrorAdvice.class);

    @Pointcut("execution(public * com.lwen.pandora.handler.controller.DefaultControllerHandler.*(..))")
    public void printErrorLog() {
    }

    @After("printErrorLog()")
    public void afterDoPrintErrorLog() {
        logger.error("Error occurred !");
    }
}
