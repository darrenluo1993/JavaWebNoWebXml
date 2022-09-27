package pers.darren.initializer;

import javax.servlet.ServletContext;

public class ParameterApplicationInitializer implements ApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("ParameterApplicationInitializer onStartup");
    }
}
