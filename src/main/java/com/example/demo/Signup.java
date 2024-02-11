package com.example.demo;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/signup")
public class Signup extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher rd= req.getRequestDispatcher("/index.html");
        rd.forward(req,res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try
        {
            String email=req.getParameter("email");
            String pwd=req.getParameter("password");
            User user =new User();
            user.setEmail(email);
            user.setPassword(pwd);
            UserDao dbase= new UserDao();
            boolean s=dbase.signup(user);
            if(s)
            {
                RequestDispatcher rd= req.getRequestDispatcher("/login.html");
                rd.forward(req,res);
            }
            else
            {
                PrintWriter out=res.getWriter();
                out.println("<p>Failed</p>");
                RequestDispatcher rd= req.getRequestDispatcher("/index.html");
                rd.include(req,res);


            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}