package pers.darren.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello", loadOnStartup = 1, initParams = {@WebInitParam(name = "role", value = "root"), @WebInitParam(name = "privilege", value = "all")})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(this.getClass().getName() + ">>>当前服务器名称:" + req.getServletContext().getAttribute("ServerName"));

        // 获取请求参数中的用户名
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
        // 构建响应数据-用户信息
        JsonObject json = new JsonObject();
        json.addProperty("userName", userName);
        json.addProperty("role", super.getInitParameter("role"));
        json.addProperty("privilege", super.getInitParameter("privilege"));
        req.getSession().setAttribute("UserInfo", json.toString());

        // 将响应数据写回客户端
        resp.getWriter().print(json);
        // resp.getOutputStream().print(json.toString());
    }
}
