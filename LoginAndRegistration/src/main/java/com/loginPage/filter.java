package com.loginPage;


import javax.servlet.Filter;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.sql.DriverManager.getConnection;

public class filter implements Filter {


    /*public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }*/

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean status=false;
        String name= servletRequest.getParameter("username");
        String pass= servletRequest.getParameter("userpass");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/userinfo";
            String userName="monika";
            String passw ="monika";

            Connection con = getConnection(url,userName,passw);
            PreparedStatement ps=con.prepareStatement(
                    "select name from user_details where username=? and passwordd=?");
            ps.setString(1,name);
            ps.setString(2,pass);

            ResultSet rs=ps.executeQuery();
            status=rs.next();
            PrintWriter out = servletResponse.getWriter();
            servletResponse.setContentType("text/html");
            if(status){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                out.println("Wrong credentials!!!");
            }

        }catch(Exception e){System.out.println(e);}

    }


    /*public void destroy() {
        Filter.super.destroy();
    }*/
}

