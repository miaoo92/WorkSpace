package com.imooc.spring.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_SERVICE_UNAVAILABLE;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/13
 */
@WebServlet(asyncSupported = true,
        name = "AsyncServlet",
        urlPatterns = "async-servlet")
public class AsyncServlet extends HttpServlet {

    public void service(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{

        if (request.isAsyncSupported()){
            AsyncContext asyncContext = request.startAsync();
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    HttpServletResponse httpServletResponse = (HttpServletResponse)event.getSuppliedResponse();
                    httpServletResponse.setStatus(SC_SERVICE_UNAVAILABLE);
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("开始执行");
                }
            });

            ServletResponse servletResponse = asyncContext.getResponse();
            servletResponse.setContentType("text/plain;charset=UTF-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.write("Hello , World . Async");
            writer.flush();
        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet[" + threadName + "]:" + object);
    }
}
