package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SBT-Smirnov-VA on 21.07.2017.
 */
public class LoginFilter implements Filter {

    private String indexPageUrl;
    private String loginPageUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        if (filterConfig != null) {
            indexPageUrl = filterConfig.getInitParameter("indexPageUrl");
            loginPageUrl = filterConfig.getInitParameter("loginPageUrl");
        }
        if (indexPageUrl == null || loginPageUrl == null) {
            throw new ServletException("Не установлен параметр инициализации");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request  = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //Разрешаем переходить по страницам только если пользователь прошел авторизацию, либо на разрешенные урлы
        if (userIsLogin(request) || isAcceptedUrl(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            response.sendRedirect(request.getContextPath() + indexPageUrl);
        }
    }

    private boolean userIsLogin(HttpServletRequest request){
        return "true".equals(request.getSession().getAttribute("login"));
    }

    private boolean isAcceptedUrl(HttpServletRequest request){
        return indexPageUrl.equals(request.getServletPath()) || loginPageUrl.equals(request.getServletPath());
    }

    @Override
    public void destroy() {

    }
}
