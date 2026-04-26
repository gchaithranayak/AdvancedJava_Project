package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.dao.HospitalDAO;
import com.model.Patient;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String type = req.getParameter("type");
        HospitalDAO dao = new HospitalDAO();
        List<Patient> list = new ArrayList<>();

        if("doctor".equals(type)) {
            list = dao.getByDoctor(req.getParameter("value"));
        } else if("ailment".equals(type)) {
            list = dao.getByAilment(req.getParameter("value"));
        } else {
            list = dao.getByDateRange(
                req.getParameter("from"),
                req.getParameter("to")
            );
        }

        req.setAttribute("data", list);
        RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
        rd.forward(req, res);
    }
}