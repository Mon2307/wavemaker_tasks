package com.loginPage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.sql.DriverManager.getConnection;
import javax.servlet.RequestDispatcher;


public class newForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("form.html");
        rd.forward(req,resp);
    }
}




