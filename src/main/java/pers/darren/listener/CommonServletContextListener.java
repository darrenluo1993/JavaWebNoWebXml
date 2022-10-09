package pers.darren.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CommonServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println(">>>>>>>>>>ServletContext初始化参数<<<<<<<<<<");
        System.out.println("系统名称:" + context.getInitParameter("osName"));
        System.out.println("系统版本:" + context.getInitParameter("osVersion"));
        System.out.println("启动时间:" + context.getInitParameter("osUptime"));
        System.out.println(">>>>>>>>>>ServletContext初始化参数<<<<<<<<<<");

        System.out.println("ServletContext已初始化，设置ServletContext属性-服务器名称");
        context.setAttribute("ServerName", "JavaWebNoWebXml");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext即将销毁，移除ServletContext属性-服务器名称");
        sce.getServletContext().removeAttribute("ServerName");
        System.out.println("ServletContext已销毁");
    }
}
