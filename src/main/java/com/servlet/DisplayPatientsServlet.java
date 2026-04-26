package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DisplayPatientsServlet")
public class DisplayPatientsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Patient List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Disease</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitaldb", "root", "root123");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patients");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getInt(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("</tr>");
            }

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.println("</table>");
    }
}