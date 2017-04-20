package servlet;

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
import java.util.Optional;

/**
 * Created by Dzianis on 15.04.2017.
 */
@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = "registration.jsp";
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.include(req, resp);
        Person person = (Person) req.getAttribute("person");
        if (person.validate()) {
            Optional<Person> fullInfo = PersonService.getInstance().save(person);
            if (fullInfo.isPresent()) {
                jspName = "success-registration.jsp";
            } else {
                jspName = "error.jsp";
            }
        }
        requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}