package servlet;

import entity.CustomerOrder;
import entity.Person;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dzianis on 15.04.2017.
 */

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        adminPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        adminPage(req, resp);
    }

    private void adminPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate startDate = verificationDate (req, "startDate");
        LocalDate finalDate = verificationDate (req, "finalDate");
        ArrayList<CustomerOrder> order =
                (ArrayList<CustomerOrder>) CustomerOrderService.getInstance().showForPeriod(startDate, finalDate);
        req.setAttribute("order", order);
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
        requestDispatcher.forward(req, resp);
    }

     private LocalDate verificationDate (HttpServletRequest req, String stringDate){
         LocalDate date;
         String newDate = req.getParameter(stringDate);
         if (newDate == null || newDate.isEmpty() ) {
             date = LocalDate.now();
         } else {
             date = LocalDate.parse(newDate);
         }
         req.setAttribute(stringDate, date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
         return date;
     }

}
