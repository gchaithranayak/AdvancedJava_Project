package com.servlet;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.HospitalDAO;
import com.model.Patient;

public class UpdatePatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Patient p = new Patient(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("age")),
                "",
                "",
                req.getParameter("ailment"),
                req.getParameter("doctor")
            );

            HospitalDAO dao = new HospitalDAO();
            dao.updatePatient(p);

            res.sendRedirect("patientdisplay.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}