package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 27.04.2017.
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            if (httpServletRequest.getRequestURI().contains("/ChangeLanguage")){
                String language = httpServletRequest.getParameter("language");
                httpServletRequest.getSession().setAttribute("currentLanguage", language);
            }
            Object userLoggedIn = httpServletRequest.getSession().getAttribute("cart");
            if (userLoggedIn == null && !httpServletRequest.getRequestURI().contains("/login")) {
                if (httpServletRequest.getRequestURI().contains("/Registration")){
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
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
