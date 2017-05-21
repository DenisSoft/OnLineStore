package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dzianis on 27.04.2017.
 */
@WebFilter({"/AddProduct", "/Admin", "/AllCategory", "/AllCustomerOrders", "/AllOrders",
         "/AllPerson", "/CreateCategory", "/CreateProduct", "/Person"})

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            Object admin = httpServletRequest.getSession().getAttribute("admin");
            if (admin == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/Home");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
