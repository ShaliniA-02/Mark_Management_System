package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.dao.MarkDAO;

@WebServlet("/delete")
public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            boolean deleted = new MarkDAO().deleteMark(id);

            if (deleted) {
                req.setAttribute("msg", "Record Deleted Successfully!");
            } else {
                req.setAttribute("msg", "ID not found!");
            }

        } catch (Exception e) {
            req.setAttribute("msg", "Error deleting record!");
        }

        req.getRequestDispatcher("markdelete.jsp").forward(req, res);
    }
}