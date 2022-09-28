package pers.darren.initializer;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.text.SimpleDateFormat;
import java.util.*;

@HandlesTypes(ApplicationInitializer.class)
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> initializerSet, ServletContext ctx) throws ServletException {
        System.out.println("ServletContainerInitializerImpl onStartup");
        System.out.println(initializerSet == null || initializerSet.isEmpty());
        // Session超时时间设置，1分钟
        ctx.setSessionTimeout(1);
        // 设置ServletContext初始化参数
        OperatingSystem operatingSystem = new SystemInfo().getOperatingSystem();
        ctx.setInitParameter("osName", operatingSystem.getFamily());
        ctx.setInitParameter("osVersion", operatingSystem.getVersionInfo().getVersion());
        ctx.setInitParameter("osUptime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(operatingSystem.getSystemUptime())));
        // ApplicationInitializer实例化以及调用
        if (initializerSet != null && !initializerSet.isEmpty()) {
            List<ApplicationInitializer> initializerList = new ArrayList<>(initializerSet.size());
            Iterator<Class<?>> iterator = initializerSet.iterator();
            while (iterator.hasNext()) {
                try {
                    initializerList.add((ApplicationInitializer) iterator.next().getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            for (ApplicationInitializer initializer : initializerList) {
                initializer.onStartup(ctx);
            }
        }
    }
}
