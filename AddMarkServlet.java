package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.Date;
import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/add")
public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {
            int marks = Integer.parseInt(req.getParameter("marks"));

            if (marks < 0 || marks > 100) {
                req.setAttribute("msg", "Marks must be between 0 and 100!");
                req.getRequestDispatcher("markadd.jsp").forward(req, res);
                return;
            }

            StudentMark sm = new StudentMark();
            sm.setStudentName(req.getParameter("name"));
            sm.setSubject(req.getParameter("subject"));
            sm.setMarks(marks);
            sm.setExamDate(Date.valueOf(req.getParameter("date")));

            new MarkDAO().addMark(sm);

            res.sendRedirect("markdisplay");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}