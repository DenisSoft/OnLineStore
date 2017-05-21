package servlet;

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
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Dzianis on 09.05.2017.
 */

@WebServlet("/DeleteOrders")
public class DeleteOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/date-selection.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringDate = req.getParameter("date");
        if (stringDate.equals("")) {
            req.setAttribute("errorDate", "Выберите дату!");
            doGet(req, resp);
            return;
        }
        CustomerOrderService.getInstance().deleteBeforeDate(LocalDate.parse(stringDate));
        resp.sendRedirect("/AllOrders");
    }
}
