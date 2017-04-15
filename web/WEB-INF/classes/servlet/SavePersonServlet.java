package servlet;

import entity.Errors;
import entity.Groups;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Created by Dzianis on 15.04.2017.
 */

@WebServlet("/Registration")
public class SavePersonServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/save-person.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        if (!email.matches("[a-zA-Z]\\w*@[a-zA-Z]+\\.[a-zA-Z]+")) {
            email = "";
            req.setAttribute("errors", new Errors("Ошибка при вводе email!"));
        }
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        if (!phone.matches("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})")) {
            phone = "";
            req.setAttribute("errors", new Errors("Ошибка при вводе телефона!"));
        }
        String jspName;
        if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("") ||
                address.equals("") || phone.equals("")) {
            if (req.getAttribute("errors") == null) {
                req.setAttribute("errors", new Errors("Вы забыли что то ввести! Попробуйте еще раз!"));
            }
            jspName = "save-person.jsp";
        } else {
            Person person = new Person(firstName, lastName, email, password, address, phone);
            jspName = (PersonService.getInstance().save(person)).equals("") ? "error.jsp" : "save-success.jsp";
        }
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);
    }
}
