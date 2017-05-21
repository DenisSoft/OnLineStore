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
import java.util.Optional;

/**
 * Created by Dzianis on 25.04.2017.
 */

@WebServlet("/AllOrders")
public class AllOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("oder", CustomerOrderService.getInstance().getAllOrders());
        req.setAttribute("allOders", true);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/customer-orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
