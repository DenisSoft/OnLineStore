package servlet;

import entity.Category;
import entity.Product;
import service.CategoryService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Dzianis on 20.04.2017.
 */

@WebServlet("/CreateProduct")
public class CreateProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", CategoryService.getInstance().getAll());
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = "create-product.jsp";
        req.setAttribute("categories", CategoryService.getInstance().getAll());
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.include(req, resp);
        Product product = (Product) req.getAttribute("product");
        Long categoryId = Long.valueOf(req.getParameter("category.id"));
        product.setCategory(CategoryService.getInstance().getById(categoryId).get());
        if (product.validate()) {
            Optional<Product> fullInfo = ProductService.getInstance().save(product);
            if (fullInfo.isPresent()) {
                jspName = "success-create-product.jsp";
            } else {
                jspName = "error.jsp";
            }
        }
        requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}
