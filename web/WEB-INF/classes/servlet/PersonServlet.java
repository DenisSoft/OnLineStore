package servlet;

import dao.PersonDao;
import entity.Person;
import service.CustomerOrderService;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 06.05.2017.
 */
@WebServlet("/Person")
public class PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("person", PersonService.getInstance().
                getById(Long.valueOf(req.getParameter("id"))));
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/all-person.jsp");
        requestDispatcher.forward(req, resp);
    }
}

