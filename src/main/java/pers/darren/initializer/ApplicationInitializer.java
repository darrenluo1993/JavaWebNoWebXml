package pers.darren.initializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public interface ApplicationInitializer {

    void onStartup(ServletContext servletContext) throws ServletException;
}
