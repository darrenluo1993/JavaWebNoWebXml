package pers.darren.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("销毁HttpServletRequest，Request Protocol:" + sre.getServletRequest().getProtocol());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("创建HttpServletRequest，Request Protocol:" + sre.getServletRequest().getProtocol());
    }
}
