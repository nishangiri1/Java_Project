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
import java.util.List;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)

            throws ServletException, IOException {
        try

        {
            int id = Integer.parseInt(req.getParameter("id"));

            UserDaoD userDao = new UserDaoD();

            boolean isDeleted = userDao.delete(id);

            if (isDeleted) {
                PrintWriter out=res.getWriter();
                out.println("<p>Record deleted</p>");
                RequestDispatcher rd= req.getRequestDispatcher("/delete.html");
                rd.include(req,res);

            } else {

                PrintWriter out = res.getWriter();

                out.println("<p>Failed to delete the record.</p>");

                RequestDispatcher rd = req.getRequestDispatcher("/show");

                rd.include(req, res);

            }

        }catch (Exception e)
        {
            e.getMessage();
        }


    }
}
