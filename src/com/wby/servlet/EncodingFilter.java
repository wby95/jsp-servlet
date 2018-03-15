package com.wby.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wby on 2018/3/15.
 */
public class EncodingFilter implements Filter {
    private String charSet;

    /**
     * 获取配置文件的初始化参数
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.charSet=filterConfig.getInitParameter("charSet");
        System.out.println("encoding init..."+charSet);


    }

    /**
     * 逻辑处理
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.charSet);
        System.out.println("encoding  doFilter...");
        /*放行*/
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * 释放资源...
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");

    }
}
