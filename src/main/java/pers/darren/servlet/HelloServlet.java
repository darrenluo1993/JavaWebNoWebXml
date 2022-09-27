package pers.darren.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        if (userName == null || userName.isBlank()) {
            String contentType = req.getContentType();
            if (contentType.contains("application/json")) {
                byte[] bytes = req.getInputStream().readAllBytes();
                String content = new String(bytes, StandardCharsets.UTF_8);
                JsonObject json = new Gson().fromJson(content, JsonObject.class);
                userName = json.get("userName").getAsString();
            }
        }
        req.getSession().setAttribute("UserName", userName);

        resp.getWriter().printf("{\"Hello\":\"%s\"}", userName);
    }
}
