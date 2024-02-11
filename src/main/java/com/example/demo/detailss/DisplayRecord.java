package com.example.demo.detailss;

import com.example.demo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/show")
public class DisplayRecord extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            UserDaoD d = new UserDaoD();
            List<User> users = d.selectALl();

            String data = "<style>" +
                    "table {" +
                    "  width: 100%;" +
                    "  border-collapse: collapse;" +
                    "}" +
                    "table, th, td {" +
                    "  border: 1px solid black;" +
                    "  padding: 8px;" +
                    "}" +
                    "th {" +
                    "  background-color: #f2f2f2;" +
                    "}" +
                    "</style>" +
                    "<table>" +
                    "<thead>" +
                    "<tr>" +
                    "<th>Id</th>" +
                    "<th>Name</th>" +
                    "<th>Roll</th>" +
                    "<th>Faculty</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>";

            for (User user : users) {
                data += "<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getRoll() + "</td><td>" + user.getFaculty() + "</td></tr>";
            }

            data += "</tbody></table>";

            PrintWriter out = res.getWriter();
            out.println(data);
            
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
