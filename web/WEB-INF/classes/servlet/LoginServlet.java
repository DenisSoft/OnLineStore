package servlet;

import entity.Category;
import entity.CustomerOrder;
import entity.Groups;
import entity.Person;
import service.CategoryService;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 22.04.2017.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = "/WEB-INF/jsp/login.jsp";
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher(jspName);
        requestDispatcher.include(req, resp);
        Person person = (Person) req.getAttribute("person");
        if (person.validatePassword()) {
            Optional<Person> fullInfo = PersonService.getInstance().getByEmailAndPassword(person);
            if (fullInfo.isPresent()) {
                req.getSession().setAttribute("cart", new CustomerOrder(person));
                List<Category> category = CategoryService.getInstance().getAll();
                ServletContext context = getServletContext();
                context.setAttribute("category", CategoryService.getInstance().getAll());
                if(person.getGroups() == Groups.ADMIN){
                    req.getSession().setAttribute("admin", true);
                    jspName = "/Admin";
                }else {
                    jspName = "/WEB-INF/jsp/home.jsp";
                }
            } else {
                person.getErrors().put("password", "Неверное имя пользователя или пароль.");
            }
        }
        requestDispatcher
                = getServletContext().getRequestDispatcher(jspName);
        requestDispatcher.forward(req, resp);
    }
}
