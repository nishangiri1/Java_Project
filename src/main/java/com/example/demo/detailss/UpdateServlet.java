package com.example.demo.detailss;

import com.example.demo.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/update")
    public class UpdateServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse res)

            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(req.getParameter("id"));

            String name = req.getParameter("name");

            String roll = req.getParameter("roll");

            String faculty = req.getParameter("faculty");


            User user = new User();

            user.setId(id);

            user.setName(name);

            user.setRoll(Integer.parseInt(roll));

            user.setFaculty(faculty);


            UserDaoD userDao = new UserDaoD();

            boolean isUpdated = userDao.update(user);


            if (isUpdated) {
                PrintWriter out=res.getWriter();
                out.println("<p>Data updated</p>");

                RequestDispatcher rd = req.getRequestDispatcher("/update.html");

                rd.include(req, res);

            } else {

                PrintWriter out = res.getWriter();

                out.println("<p>Failed to update the record.</p>");

                RequestDispatcher rd = req.getRequestDispatcher("/update.html");

                rd.include(req, res);

            }

        } catch (Exception e) {

            // Handle the exception by displaying a user-friendly error message

            PrintWriter out = res.getWriter();

            out.println("<p>An error occurred while updating the record. Please try again later.</p>");

            e.printStackTrace(); // Print the stack trace for debugging purposes

        }

    }
    }
