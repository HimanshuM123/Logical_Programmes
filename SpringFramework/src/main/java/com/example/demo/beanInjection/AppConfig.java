package com.example.demo.beanInjection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    //@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }
}