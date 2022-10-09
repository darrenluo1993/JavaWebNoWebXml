package pers.darren.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CommonServletRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("HttpServletRequest中被添加的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("HttpServletRequest中被移除的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        Object newValue = event.getServletRequest().getAttribute(event.getName());
        System.out.println("HttpServletRequest中被替换的属性名称、旧值、新值:" + event.getName() + "=" + event.getValue() + "=" + newValue);
    }
}
