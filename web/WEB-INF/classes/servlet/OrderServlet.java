package servlet;

import entity.CustomerOrder;
import service.CustomerOrderService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 06.05.2017.
 */

@WebServlet("/Order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("order", CustomerOrderService.getInstance().
                getById(Long.valueOf(req.getParameter("id"))).get());
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/order-details.jsp");
        requestDispatcher.forward(req, resp);
    }
}
