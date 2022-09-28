package pers.darren.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CSRAttributeManageServlet", urlPatterns = "/csrAttributeManage")
public class CSRAttributeManageServlet extends HttpServlet {

    private static final String SCA = "SCA", HSA = "HSA", SRA = "SRA";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // Servlet中获取ServletContext的4种方法
        // ServletContext servletContext1 = super.getServletContext();
        // ServletContext servletContext2 = req.getServletContext();
        // ServletContext servletContext3 = super.getServletConfig().getServletContext();
        // ServletContext servletContext4 = req.getSession().getServletContext();
        // System.out.println(servletContext1);
        // System.out.println(servletContext2);
        // System.out.println(servletContext3);
        // System.out.println(servletContext4);
        // System.out.println(servletContext1 == servletContext2); // true
        // System.out.println(servletContext2 == servletContext3); // true
        // System.out.println(servletContext3 == servletContext4); // true

        String attrType = req.getParameter("attrType");
        if ("context".equalsIgnoreCase(attrType)) {
            ServletContext servletContext = super.getServletContext();
            servletContext.setAttribute(SCA, "ADD");
            servletContext.setAttribute(SCA, "REPLACE");
            servletContext.removeAttribute(SCA);
        } else if ("session".equalsIgnoreCase(attrType)) {
            HttpSession session = req.getSession();
            session.setAttribute(HSA, "ADD");
            session.setAttribute(HSA, "REPLACE");
            session.removeAttribute(HSA);
        } else if ("request".equalsIgnoreCase(attrType)) {
            req.setAttribute(SRA, "ADD");
            req.setAttribute(SRA, "REPLACE");
            req.removeAttribute(SRA);
        }
    }
}
