package com.supcon.ses.developer.config.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * <p>描述</p>
 *
 * @author lufengdong
 * @create 2023-07-15 20:05
 */
@Configuration
public class SpringApplicationContext implements ApplicationContextAware, DisposableBean {
    public static ApplicationContext APPLICATION_CONTEXT = null;

    public SpringApplicationContext() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) APPLICATION_CONTEXT.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(name, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }

    public static String getActiveProfile() {
        return APPLICATION_CONTEXT.getEnvironment().getActiveProfiles()[0];
    }

    public static boolean containsBean(String name) {
        return APPLICATION_CONTEXT.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return APPLICATION_CONTEXT.isSingleton(name);
    }


    @Override
    public void destroy() throws Exception {
        APPLICATION_CONTEXT = null;
    }
}
