package pers.darren.initializer;

import javax.servlet.ServletContext;

public class ContextApplicationInitializer implements ApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("ContextApplicationInitializer onStartup");
    }
}
