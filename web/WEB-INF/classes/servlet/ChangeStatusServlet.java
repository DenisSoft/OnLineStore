package servlet;

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

import static entity.OrderStatus.CLOSED;

/**
 * Created by Dzianis on 09.05.2017.
 */

@WebServlet("/ChangeStatus")
public class ChangeStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        CustomerOrderService.getInstance().changeStatus(id, CLOSED);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/AllOrders");
        requestDispatcher.forward(req, resp);
    }
}