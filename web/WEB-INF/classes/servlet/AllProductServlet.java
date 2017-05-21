package servlet;

import entity.Person;
import entity.Product;
import service.CategoryService;
import service.PersonService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Dzianis on 15.04.2017.
 */
@WebServlet("/AllProduct")
public class AllProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = ProductService.getInstance().getAll();
        req.setAttribute("products", list);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/all-product.jsp");
        requestDispatcher.forward(req, resp);
    }
}
