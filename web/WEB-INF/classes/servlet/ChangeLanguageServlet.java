package servlet;

import entity.Groups;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 08.05.2017.
 */
@WebServlet("/ChangeLanguage")
public class ChangeLanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getHeader("Referer").contains("/login")){
            if(req.getSession().getAttribute("admin") != null) {
                resp.sendRedirect("/Admin");
            } else {
                resp.sendRedirect("/Home");
            }
        } else {
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
