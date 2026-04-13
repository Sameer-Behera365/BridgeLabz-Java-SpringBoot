package com.bridgelabz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validatePassword")
public class PasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password != null && password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                if (Character.isLowerCase(c)) hasLower = true;
                if (Character.isDigit(c)) hasDigit = true;
                if ("!@#$%^&*".indexOf(c) >= 0) hasSpecial = true;
            }
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            out.println("<html><body>");
            out.println("<h2>Valid Password!</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Invalid Password!</h2>");
            out.println("<p>Password must have:</p>");
            out.println("<ul>");
            out.println("<li>Minimum 8 characters</li>");
            out.println("<li>At least one uppercase letter</li>");
            out.println("<li>At least one lowercase letter</li>");
            out.println("<li>At least one digit</li>");
            out.println("<li>At least one special character (!@#$%^&*)</li>");
            out.println("</ul>");
            out.println("<a href='password.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}