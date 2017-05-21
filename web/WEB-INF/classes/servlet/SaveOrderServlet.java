package servlet;

import dao.CustomerOrderDao;
import entity.CustomerOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Dzianis on 07.05.2017.
 */

@WebServlet("/SaveOrder")
public class SaveOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspName = "success-create-order.jsp";
        CustomerOrder order = (CustomerOrder) req.getSession().getAttribute("cart");
        order.setErrors(null);
        if(order.getOrderItem().size() != 0){
            Optional<CustomerOrder> fullInfo = CustomerOrderDao.getInstance().save(order);
            if (fullInfo.isPresent()) {
                order = fullInfo.get();
                String string = order.getErrors();
                if (order.getErrors() == null) {
                    req.setAttribute("order", new CustomerOrder(order.getId(),
                            order.getPerson(), new HashMap<>(order.getOrderItem())));
                    order.getOrderItem().clear();
                } else {
                    jspName = "cart.jsp";
                }
            }
        }else {
            jspName = "cart.jsp";
        }
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + jspName);
        requestDispatcher.forward(req, resp);

    }
}
