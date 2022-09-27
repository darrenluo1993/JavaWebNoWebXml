package pers.darren.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "ResponseCharacterEncodingFilter", urlPatterns = "/*", description = "HTTP响应内容字符编码与内容类型过滤器")
public class ResponseCharacterEncodingFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + ">>>当前服务器名称:" + req.getServletContext().getAttribute("ServerName"));
        res.setCharacterEncoding("UTF8");
        res.setContentType("application/json");
        super.doFilter(req, res, chain);
    }
}
