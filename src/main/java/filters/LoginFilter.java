package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SBT-Smirnov-VA on 21.07.2017.
 */
public class LoginFilter implements Filter {

    private String errorPageUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        if (filterConfig != null) {
            errorPageUrl = filterConfig.getInitParameter("errorPageUrl");
        }
        if (errorPageUrl == null) {
            throw new ServletException("Не установлен параметр инициализации errorPageUrl");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (errorPageUrl == null)
        {
            throw new ServletException();
        }

        HttpServletRequest request  = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if (!errorPageUrl.equals(request.getServletPath()) && (request.getSession()==null || request.getSession(false).getAttribute("login") == null))
        {
            response.sendRedirect(request.getContextPath() + errorPageUrl);
        }
        else
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
