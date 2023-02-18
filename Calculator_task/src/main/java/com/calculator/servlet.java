package com.calculator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
public class servlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head>" +
                        "<title>Calculate me</title></head><body>");
        int n1 = Integer.parseInt(req.getParameter("first"));
        int n2 = Integer.parseInt(req.getParameter("second"));
        int result =0;
        String opr=req.getParameter("operator");
        if(opr.equals("+")){
            result=n1+n2;
            out.println("<h2>The results</h2>");
            out.println("<p> Adding "+n1 +" to " + n2  +" gives " +result+"</p>");
        }

        if(opr.equals("*")){
            result=n1*n2;
            out.println("<h2>The results</h2>");
            out.println("<p> Multiplying " + n1 +" by " + n2+ " gives " +result+"</p>");
        }

        if(opr.equals("-")) {
            result=n1-n2;
            out.println("<h2>The results</h2>");
            out.println("<p> Subtracting " + n2 +" from " + n1 + " gives " +result+"</p>");
        }
        if(opr.equals("/")){
            result=n1/n2;
            out.println("<h2>The results</h2>");
            out.println("<p> Dividing " + n1 +" by " + n2+ " gives " +result+"</p>");
        }

        out.println("</body></html>");
    }
}
