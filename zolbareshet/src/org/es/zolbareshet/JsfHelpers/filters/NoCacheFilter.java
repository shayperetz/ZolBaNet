package org.es.zolbareshet.JsfHelpers.filters;

import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eilons on 4/4/2016.
 */

public class NoCacheFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            if (!request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
            }

            chain.doFilter(req, res);
        }

    @Override
    public void destroy() {

    }
}
