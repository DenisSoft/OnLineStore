package servlet;

import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 10.05.2017.
 */

@WebServlet("/AllProductByCategory")
public class AllProductByCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("products", ProductService.getInstance().
                allProductByCategory(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/all-product.jsp");
        requestDispatcher.forward(req, resp);
    }
}
