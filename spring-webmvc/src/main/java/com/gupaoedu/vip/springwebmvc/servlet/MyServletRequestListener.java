package com.gupaoedu.vip.springwebmvc.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext context = servletRequest.getServletContext();
        context.log("ServletRequestListener  was Initialized");
        ClassLoader classLoader = context.getClassLoader();
        while (true){
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
            if (classLoader == null){
                break;
            }
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext context = servletRequest.getServletContext();
        context.log("ServletRequestListener  was Destroyed");
    }
}
