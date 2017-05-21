package servlet;

import entity.CustomerOrder;
import entity.Product;
import service.CustomerOrderService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static java.lang.Integer.valueOf;

/**
 * Created by Dzianis on 04.05.2017.
 */

@WebServlet("/AddProductToCatr")
public class AddProductToCatrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = ProductService.getInstance().getById(valueOf(req.getParameter("productId"))).get();
        product.setDescription("");
        int amount = Integer.parseInt(req.getParameter("amount"));
        CustomerOrder cart = (CustomerOrder) req.getSession().getAttribute("cart");
        cart.getOrderItem().put(product, amount);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
