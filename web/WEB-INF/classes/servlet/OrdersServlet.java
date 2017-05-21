package servlet;

import service.CustomerOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 28.04.2017.
 */
@WebServlet("/Orders")
public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("oder", CustomerOrderService.getInstance().
                getAllCustomerOrders(id));
        req.setAttribute("id", id);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/all-orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
