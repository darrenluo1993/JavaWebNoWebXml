package pers.darren.initializer;

import jakarta.servlet.ServletContext;

public class ContextApplicationInitializer implements ApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("ContextApplicationInitializer onStartup");
    }
}
