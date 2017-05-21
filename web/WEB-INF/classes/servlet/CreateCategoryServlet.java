package servlet;

import entity.Category;
import entity.Person;
import service.CategoryService;
import service.PersonService;

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

@WebServlet("/CreateCategory")
public class CreateCategoryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-category.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = "create-category.jsp";
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.include(req, resp);
        Category category = (Category) req.getAttribute("category");
        if (category.validate()) {
            Optional<Category> fullInfo = CategoryService.getInstance().save(category);
            if (fullInfo.isPresent()) {
                jspName = "success-create-category.jsp";
            } else {
                jspName = "error.jsp";
            }
        }
        getServletContext().setAttribute("category", CategoryService.getInstance().getAll());
        requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}
