package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.HospitalDAO;
import com.model.Patient;


public class AddPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String date = request.getParameter("date");
            String ailment = request.getParameter("ailment");
            String doctor = request.getParameter("doctor");

            Patient p = new Patient(id, name, age, gender, date, ailment, doctor);

            HospitalDAO dao = new HospitalDAO();
            boolean result = dao.addPatient(p);

            if (result) {
                response.sendRedirect("index.jsp?msg=success");
            } else {
                response.sendRedirect("index.jsp?msg=fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?msg=error");
        }
    }
}