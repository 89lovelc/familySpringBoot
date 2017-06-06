package com.hjh.cn.filter;

import com.hjh.cn.po.UserPo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 89lovelc on 2017/6/3.
 */
//@WebFilter(filterName="filter",urlPatterns="/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        UserPo user = (UserPo) session.getAttribute("user");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String str = request.getRequestURL().toString();

        if(user == null && str.indexOf("login") < 0 && str.indexOf("regis") < 0){
            response.sendRedirect("http://localhost:8330/family/fmr/login");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
