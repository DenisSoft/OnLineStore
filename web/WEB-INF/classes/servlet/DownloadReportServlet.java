package servlet;

import dao.CustomerOrderDao;
import entity.CustomerOrder;
import service.CustomerOrderService;

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
@WebServlet("/DownloadReport")
public class DownloadReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        String report = CustomerOrderService.getInstance().createReport(id);
        resp.setHeader("Content-disposition", "attachment; filename=report.doc");
        resp.getWriter().write(report);
    }
}