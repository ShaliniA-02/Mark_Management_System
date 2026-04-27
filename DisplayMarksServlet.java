package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.dao.MarkDAO;

@WebServlet("/markdisplay")
public class DisplayMarksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        try {
            req.setAttribute("data", new MarkDAO().getAllMarks());
            req.getRequestDispatcher("markdisplay.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}