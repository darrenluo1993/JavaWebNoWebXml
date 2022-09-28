package pers.darren.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "charset", value = "UTF8"), @WebInitParam(name = "contentType", value = "application/json")}, description = "HTTP请求与响应内容字符编码设置，HTTP响应内容类型设置")
public class CharacterEncodingFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName() + ">>>当前服务器名称:" + req.getServletContext().getAttribute("ServerName"));

        // 获取过滤器初始化参数
        String charset = super.getInitParameter("charset");
        String contentType = super.getInitParameter("contentType");

        // 设置请求内容字符编码为UTF8
        req.setCharacterEncoding(charset);
        // 设置响应内容字符编码为UTF8，内容类型为application/json
        res.setCharacterEncoding(charset);
        res.setContentType(contentType);

        super.doFilter(req, res, chain);
    }
}
