package pers.darren.initializer;

import jakarta.servlet.ServletContext;

public class ParameterApplicationInitializer implements ApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("ParameterApplicationInitializer onStartup");
    }
}
