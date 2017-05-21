package servlet;

import entity.Category;
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
 * Created by Dzianis on 02.05.2017.
 */

@WebServlet("/DeleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService.getInstance().delete(Integer.valueOf(req.getParameter("id")));
        getServletContext().setAttribute("category", CategoryService.getInstance().getAll());
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/AllCategory");
        requestDispatcher.forward(req, resp);
    }
}
