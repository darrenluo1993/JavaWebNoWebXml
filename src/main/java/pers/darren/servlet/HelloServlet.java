package pers.darren.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(this.getClass().getName() + ">>>当前服务器名称:" + req.getServletContext().getAttribute("ServerName"));

        String userName = req.getParameter("userName");
        req.getSession().setAttribute("UserName", userName);

        resp.getWriter().printf("{\"Hello\":\"%s\"}", userName);
    }
}
