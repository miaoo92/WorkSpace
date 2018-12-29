package com.gupaoedu.vip.springwebmvc.servlet.spring.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.log("MyServlet2 doGet was invoked");
        Writer writer = resp.getWriter();
        writer.write("<html><body>Hello,World! MyServlet2 </body></html>");
        writer.flush();
    }
}
