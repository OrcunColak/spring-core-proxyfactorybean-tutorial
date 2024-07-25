package com.colak.springtutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class AppConfig {

    /**
     * Since CommonDAOImpl has been defined above, and the FactoryBean#getObject returns
     * an object that also implements the ICommonDAO interface, @Primary is needed here.
     */
    @Bean
    @Primary
    ProxyFactoryBean commonDAO(@Qualifier("commonDAOImpl") CommonDAOImpl commonDAOTarget) throws ClassNotFoundException {
        ProxyFactoryBean proxy = new ProxyFactoryBean();
        proxy.setProxyInterfaces(new Class<?>[]{ICommonDAO.class});
        proxy.setTarget(commonDAOTarget);

        // Proxying the class, this can be omitted
        proxy.setProxyTargetClass(true);

        // use wildcards to specify interceptors.
        // The ProxyFactoryBean will automatically find all bean objects in the container whose names start with
        // global_ during initialization.
        proxy.setInterceptorNames("global*");
        return proxy;
    }
}
