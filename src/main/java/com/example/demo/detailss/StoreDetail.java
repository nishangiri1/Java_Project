package com.example.demo.detailss;

import com.example.demo.User;
import com.example.demo.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/inserted")
public class StoreDetail extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/welcome.html");
        rd.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            String name = req.getParameter("name");
            String roll1 = req.getParameter("roll");
            int roll = Integer.parseInt(roll1);
            String faculty = req.getParameter("faculty");
            User user=new User();
            user.setName(name);
            user.setRoll(roll);
            user.setFaculty(faculty);
            UserDaoD dbase = new UserDaoD();
            boolean s = dbase.insert(user);
            if (s) {
                PrintWriter out=res.getWriter();
                out.println("<p>Data inserted</p>");
                RequestDispatcher rd=req.getRequestDispatcher("/welcome.html");
                rd.include(req,res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("<p>Failed</p>");
                RequestDispatcher rd = req.getRequestDispatcher("/welcome.html");
                rd.include(req, res);


            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

//    public void service(HttpServletRequest req, HttpServletResponse res) {
//        try {
//            UserDaoD d = new UserDaoD();
//            List<User> users = new UserDaoD().selectALl();
//            PrintWriter out = res.getWriter();
//            out.println("<html><body><table>");
//            out.println("<tr><th>Name:</th><th>Roll:</th><th>Faculty:</th></tr>");
//            for (User i : users) {
//                out.println("<tr><td>" + i.getName() + "</td><td>" + i.getRoll() + "</td><td>" + i.getFaculty() + "</td></tr>");
//
//            }
//
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
}
