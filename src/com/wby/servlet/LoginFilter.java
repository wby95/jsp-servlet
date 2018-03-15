package com.wby.servlet;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wby on 2018/3/15.
 */
public class LoginFilter implements Filter {
    String userSessionKey;
    String   redirectPage;
    String uncheckedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext=filterConfig.getServletContext();
        System.out.println("LoginFilter init...");
        userSessionKey=servletContext.getInitParameter("userSessionKey");
        redirectPage=servletContext.getInitParameter(" redirectPage");
        uncheckedUrls=servletContext.getInitParameter("uncheckedUrls");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        System.out.println("LoginFilter do...");
        Object user=request.getSession().getAttribute("userSessionKey");
        
        //获取请求的servletPath
        String servletPath=request.getServletPath();
        //哪些资源不必拦截
        List<String>urls= Arrays.asList(uncheckedUrls.split(","));
        if(urls.contains(servletPath)){
            System.out.print("user....  " +user);
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //用户为null值，说明还没登录过
        if(user==null){
            System.out.print("user  " +user);
            response.sendRedirect( request.getContextPath()+"/index.jsp");
            return;
        }
        //下一个处理器处理
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {

    }
}
