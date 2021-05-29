package org.myharvest.common;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 跨域配置
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "crossOrigin")
public class CrossOriginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("crossOrigin init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}