package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 27.04.2017.
 */
    @WebServlet("/Home")
    public class HomeServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher
                    = getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher
                    = getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
