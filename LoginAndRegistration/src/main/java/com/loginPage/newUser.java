package com.loginPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class newUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/userinfo";
            String userName="monika";
            String passw ="monika";

            Connection con = getConnection(url,userName,passw);
            String a=request.getParameter("username");
            String b=request.getParameter("password");
            String c=request.getParameter("name");
            String d=request.getParameter("Gender");
            String t=request.getParameter("City");

            {

                String query="insert into user_details(username,passwordd,name,gender,city) values (?,?,?,?,?)";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1,a);
                st.setString(2,b);
                st.setString(3,c);
                st.setString(4,d);
                st.setString(5,t);
                int count= st.executeUpdate();
                if(count==1){
                    out.println("Successfully registered!!! ");
                }
                st.close();
            }


        } catch (SQLException e) {
            out.println("An error occured while retrieving " + "all users: "
                    + e.toString());
        } catch (ClassNotFoundException e) {
            throw (new ServletException(e.toString()));
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
//        String opr=request.getParameter("submit");
//        if(opr.equals("submit")){
//            RequestDispatcher rd=request.getRequestDispatcher("second");
//            rd.forward(request,response);
//        }

        out.close();
    }
}




