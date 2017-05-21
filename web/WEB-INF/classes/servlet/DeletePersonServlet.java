package servlet;

import service.CategoryService;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 04.05.2017.
 */

@WebServlet("/DeletePerson")
public class DeletePersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonService.getInstance().delete(Integer.valueOf(req.getParameter("id")));
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/AllPerson");
        requestDispatcher.forward(req, resp);
    }
}
