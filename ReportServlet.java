package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        try {
            String type = req.getParameter("type");
            MarkDAO dao = new MarkDAO();
            List<StudentMark> list = new ArrayList<>();

            if (type.equals("above")) {
                list = dao.getAboveMarks(Integer.parseInt(req.getParameter("marks")));
            } else if (type.equals("subject")) {
                list = dao.getBySubject(req.getParameter("subject"));
            } else {
                list = dao.getTopN(Integer.parseInt(req.getParameter("n")));
            }

            req.setAttribute("data", list);
            req.getRequestDispatcher("report_result.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}