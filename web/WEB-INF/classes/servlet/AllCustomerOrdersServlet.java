package servlet;

import entity.CustomerOrder;
import service.CategoryService;
import service.CustomerOrderService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dzianis on 25.04.2017.
 */

@WebServlet("/AllCustomerOrders")
public class AllCustomerOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("oder", CustomerOrderService.getInstance().
                getAllCustomerOrders(id));
        req.setAttribute("id", id);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/customer-orders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
