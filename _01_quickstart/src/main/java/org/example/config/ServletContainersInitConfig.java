package org.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/*
    定义 servlet 容器的配置类
 */
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // 加载 SpringMVC 配置
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        // 初始化 WebApplicationContext 对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        // 加载指定配置类
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    // 设置 Tomcat 接收的请求哪些归 SpringMVC 处理
    @Override
    protected String[] getServletMappings() {
//        return new String[0];
        return new String[]{"/"};
    }

    // 加载 Spring 容器中的相关配置
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
