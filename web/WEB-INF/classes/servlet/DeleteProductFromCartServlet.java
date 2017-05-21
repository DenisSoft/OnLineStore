package servlet;

import entity.CustomerOrder;
import entity.Person;
import entity.Product;
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

import static java.lang.Integer.valueOf;

/**
 * Created by Dzianis on 04.05.2017.
 */

@WebServlet("/DeleteProductFromCart")
public class DeleteProductFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.valueOf(req.getParameter("productId"));
        CustomerOrder cart = (CustomerOrder) req.getSession().getAttribute("cart");
        cart.getOrderItem().remove(new Product(productId));


        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/Cart");
        requestDispatcher.forward(req, resp);
    }
}
