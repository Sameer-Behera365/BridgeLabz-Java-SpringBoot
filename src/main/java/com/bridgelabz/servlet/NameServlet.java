package com.bridgelabz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validateName")
public class NameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (name != null && name.length() >= 3
                && Character.isUpperCase(name.charAt(0))) {
            out.println("<html><body>");
            out.println("<h2>Valid Name: " + name + "</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Invalid! Name must start with capital letter and have min 3 characters</h2>");
            out.println("<a href='name.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}