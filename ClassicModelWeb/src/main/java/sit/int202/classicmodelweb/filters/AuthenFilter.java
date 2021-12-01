package sit.int202.classicmodelweb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenFilter", servletNames = {"OfficeListServlet"})
public class AuthenFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        } else {
            chain.doFilter(request, response);
        }
    }
}
