package io.khasang.web.config;

import io.khasang.web.config.application.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    //instead web.xml for configure DispatcherServlet - listing 5.1 of this book

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ /*RootConfig.class*/ };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
}


