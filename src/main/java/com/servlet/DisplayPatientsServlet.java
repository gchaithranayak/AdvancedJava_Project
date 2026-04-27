
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

        // ===== HTML START =====
        out.println("<html><head><title>Patient Records</title>");

        // ===== CSS DESIGN =====
        out.println("<style>");
        out.println("body { font-family:'Segoe UI'; margin:0; background: linear-gradient(to right,#5a0000,#f8f8f8); }");

        out.println(".header { text-align:center; padding:20px; margin:20px auto; max-width:900px;"
                + " background:rgba(255,255,255,0.25); backdrop-filter:blur(10px); border-radius:20px;"
                + " color:#5a0000; }");

        out.println(".table-box { width:90%; margin:auto; padding:20px;"
                + " background:rgba(255,255,255,0.3); backdrop-filter:blur(10px); border-radius:20px;"
                + " box-shadow:0 8px 20px rgba(0,0,0,0.2); }");

        out.println("table { width:100%; border-collapse:collapse; }");

        out.println("th { background:#800000; color:white; padding:12px; }");

        out.println("td { padding:10px; text-align:center; border-bottom:1px solid #ccc; }");

        out.println("tr:nth-child(even){ background:rgba(0,0,0,0.05); }");

        out.println("tr:hover { background:rgba(128,0,0,0.15); }");

        out.println("a { display:block; text-align:center; margin:20px; color:#800000; font-weight:bold; text-decoration:none; }");

        out.println("</style></head><body>");

        // ===== HEADER =====
        out.println("<div class='header'>");
        out.println("<h2>📋 Patient Records</h2>");
        out.println("<p>All registered patients</p>");
        out.println("</div>");

        // ===== TABLE START =====
        out.println("<div class='table-box'>");
        out.println("<table>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Age</th>");
        out.println("<th>Gender</th>");
        out.println("<th>Date</th>");
        out.println("<th>Ailment</th>");
        out.println("<th>Doctor</th>");
        out.println("</tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitaldb", "root", "root123");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Patients");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;

                out.println("<tr>");
                out.println("<td>" + rs.getInt("PatientID") + "</td>");
                out.println("<td>" + rs.getString("PatientName") + "</td>");
                out.println("<td>" + rs.getInt("Age") + "</td>");
                out.println("<td>" + rs.getString("Gender") + "</td>");
                out.println("<td>" + rs.getDate("AdmissionDate") + "</td>");
                out.println("<td>" + rs.getString("Ailment") + "</td>");
                out.println("<td>" + rs.getString("AssignedDoctor") + "</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='7' style='color:red;'>No Records Found</td></tr>");
            }

            con.close();

        } catch (Exception e) {
            out.println("<tr><td colspan='7'>Error: " + e.getMessage() + "</td></tr>");
        }

        out.println("</table></div>");

        // ===== BACK BUTTON =====
        out.println("<a href='index.jsp'>⬅ Back to Home</a>");

        out.println("</body></html>");
    }
}
