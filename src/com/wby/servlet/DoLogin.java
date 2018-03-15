package com.wby.servlet;
import com.wby.bean.User;
import com.wby.dao.UserDao;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wby on 2018/3/15.
 */

/*  处理index.jsp提交过来的页面
* */
public class DoLogin extends HttpServlet {
    UserDao userDao=new UserDao();
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext=filterConfig.getServletContext();
        System.out.println("DoLogin init");

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setUserName(username);
        user.setPassword(password);
        if(userDao.valiUser(user)){
                System.out.print("DoLogin success");
            System.out.print(user);
            request.getSession().setAttribute("userSessionKey",user);
            response.sendRedirect(request.getContextPath()+"/page/success.jsp");
        }
        else{
            System.out.print(username);
            System.out.print(password);
            System.out.print("DoLogin flisae");
            response.sendRedirect(request.getContextPath()+"/page/index.jsp");
        }



    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        this.doGet(request,response);
    }
}
