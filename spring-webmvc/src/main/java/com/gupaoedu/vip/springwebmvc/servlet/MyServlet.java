package com.gupaoedu.vip.springwebmvc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "myServlet",
            urlPatterns = {"/MyServlet"},
            initParams = @WebInitParam(name = "myname",value = "myvalue"))
public class MyServlet extends HttpServlet {

    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //如果这里没有调父类init，则会在getServletContext()出错
        super.init(config);
        name = config.getInitParameter("myname");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.log("doGet was invoked");
        Writer writer = resp.getWriter();
        writer.write("<html><body>Hello,World! myvalue="+name+"</body></html>");
        writer.flush();
    }
}
