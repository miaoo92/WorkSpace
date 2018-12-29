package com.gupaoedu.vip.springwebmvc.servlet.spring.boot;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        doSomething();
        filterChain.doFilter(request,response);
    }

    public void doSomething(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
        HttpServletRequest servletRequest = servletRequestAttributes.getRequest();
        ServletContext context = servletRequest.getServletContext();
        String requestUrl = servletRequest.getRequestURI();
        context.log(requestUrl + " was filtered");

    }
}
