package web.filter;

import javax.servlet.*;
import java.io.IOException;

public class CalcFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getParameter("op1") != null &&
        servletRequest.getParameter("op2") != null &&
        servletRequest.getParameter("op") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
