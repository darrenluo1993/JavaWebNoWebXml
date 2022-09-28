package pers.darren.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class CommonHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("HttpSession中被添加的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("HttpSession中被移除的属性名称和值:" + event.getName() + "=" + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        Object newValue = event.getSession().getAttribute(event.getName());
        System.out.println("HttpSession中被替换的属性名称、旧值、新值:" + event.getName() + "=" + event.getValue() + "=" + newValue);
    }
}
