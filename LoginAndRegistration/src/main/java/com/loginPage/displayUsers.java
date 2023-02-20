package com.loginPage;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class displayUsers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head ><title>All Users</title></head>");
        out.println("<body style='background-color:#e6e6fa'>");
        out.println("<center><h1>All Users</h1>");
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/userinfo";
            String userName="monika";
            String passw ="monika";

            Connection con = getConnection(url,userName,passw);

            stmt = con.createStatement();
            String listt = request.getParameter("tocheck");
            String query = "select username,name,gender,city from user_details";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String Username=rs.getString("name");
                String UserId =rs.getString("username");
                String Gender =rs.getString("Gender");
                String City =rs.getString("city");

                out.println("<p> The UserId " +UserId + " has following Details"+"</p>");
                out.println("<p style='color:#9370db'>Name : " + Username+"</p>");
                out.println("<p style='color:#9370db'>Gender : " + Gender+"</p>");
                out.println("<p style='color:#9370db'>City : " + City+"</p>");
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
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}


