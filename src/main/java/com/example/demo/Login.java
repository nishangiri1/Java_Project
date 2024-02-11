package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher rd= req.getRequestDispatcher("/login.html");
        rd.forward(req,res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            UserDao userDao = new UserDao();

            if (userDao.authenticate(email, password)) {
                PrintWriter out=res.getWriter();
                out.println("<p>Success</p>");
                RequestDispatcher rd = req.getRequestDispatcher("/welcome.html");
                rd.forward(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("<p>Login failed</p>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
