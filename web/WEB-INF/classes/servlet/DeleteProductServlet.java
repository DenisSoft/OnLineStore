package servlet;

import service.CustomerOrderService;
import service.PersonService;
import service.ProductService;

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

@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService.getInstance().delete(Integer.valueOf(req.getParameter("id")));
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/AllProduct");
        requestDispatcher.forward(req, resp);
    }
}
