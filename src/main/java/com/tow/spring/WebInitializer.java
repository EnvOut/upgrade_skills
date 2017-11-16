package com.tow.spring;

import com.tow.spring.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebInitializer implements WebApplicationInitializer {
    // Указываем имя нашему Servlet Dispatcher для мапинга
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // Регистрируем в контексте конфигурационный класс, который мы создадим ниже
        ctx.register(ApplicationConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME,
                new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }


//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(ApplicationConfig.class);
//
//        // Manage the lifecycle of the root application context
//        container.addListener(new ContextLoaderListener(rootContext));
//
//        // Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher =
//                container.addServlet("websocket", new DispatcherServlet());
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
}
