package com.colak.springtutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("global_auth")
@Slf4j
public class AuthInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("AuthInterceptor before log...");
        Object ret = invocation.proceed();
        log.info("AuthInterceptor after log...");
        return ret;
    }
}
