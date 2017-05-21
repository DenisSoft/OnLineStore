package servlet;

import entity.Category;
import entity.CustomerOrder;
import service.CustomerOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Dzianis on 04.05.2017.
 */

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerOrder order = (CustomerOrder) req.getSession().getAttribute("cart");
        order.setErrors(null);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp");
        requestDispatcher.forward(req, resp);
    }
}
