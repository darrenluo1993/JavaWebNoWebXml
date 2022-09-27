package pers.darren.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建ServletContext，设置ServletContext属性-服务器名称");
        sce.getServletContext().setAttribute("ServerName", "JavaWebNoWebXml");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁ServletContext，移除ServletContext属性-服务器名称");
        sce.getServletContext().removeAttribute("ServerName");
    }
}
