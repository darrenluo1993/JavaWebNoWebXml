package pers.darren.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonServletContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContext中被添加的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContext中被移除的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        Object newValue = event.getServletContext().getAttribute(event.getName());
        System.out.println("ServletContext中被替换的属性名称、旧值、新值:" + event.getName() + "=" + event.getValue() + "=" + newValue);
    }
}
