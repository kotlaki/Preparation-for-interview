package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet implements Servlet {

    private String message;

    private transient ServletConfig servletConfig;


    public void init(ServletConfig servletConfig) throws ServletException {
        message = "Hello World";
    }

    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println(message);
    }

    public String getServletInfo() {
        return servletConfig.getServletName();
    }

    public void destroy() {

    }
}
