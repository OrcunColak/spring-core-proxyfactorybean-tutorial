package com.colak.springtutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("globalLog")
@Slf4j
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("LogInterceptor before log...");
        Object ret = invocation.proceed();
        log.info("LogInterceptor after log...");
        return ret;
    }
}
