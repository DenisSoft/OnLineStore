package servlet;

import entity.Errors;
import entity.Person;
import entity.Product;
import service.PersonService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dzianis on 15.04.2017.
 */
@WebServlet("/newProduct")
public class SaveProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/save-product.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = req.getParameter("categoryId");
        long categoryId;
        if (string.matches("\\D*")) {
            categoryId = 0;
            req.setAttribute("errors", new Errors("Ошибка при вводе категории!"));
        } else {
            categoryId = Long.valueOf(string);
        }
        String productName = req.getParameter("productName");
        String description = req.getParameter("description");
        string = req.getParameter("price");
        double price;
        if (string.matches("\\D*")) {
            price = 0;
            req.setAttribute("errors", new Errors("Ошибка при вводе цены!"));
        } else {
            price = Long.valueOf(string);
        }
        string = req.getParameter("residue");
        int residue;
        if (string.matches("\\D*")) {
            residue = 0;
            req.setAttribute("errors", new Errors("Ошибка при вводе количества!"));
        } else {
            residue = Integer.valueOf(string);
        }
        String jspName;
        if (categoryId == 0 || productName.equals("") || description.equals("") || price == 0 || residue == 0) {
            if (req.getAttribute("errors") == null) {
                req.setAttribute("errors", new Errors("Вы забыли что то ввести! Попробуйте еще раз!"));
            }
            jspName = "save-product.jsp";
        } else {
            Product product = new Product(categoryId, productName, description, price, residue);
            jspName = ProductService.getInstance().save(product).equals("") ? "error.jsp" : "save-success.jsp";
        }
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}
