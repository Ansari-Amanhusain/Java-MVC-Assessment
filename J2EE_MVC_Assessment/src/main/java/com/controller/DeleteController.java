package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ViewDAO;


@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeidParam = request.getParameter("id");
        if (employeeidParam == null || employeeidParam.isEmpty()) {
            request.setAttribute("msg", "Invalid employee ID.");
            request.getRequestDispatcher("view.jsp").forward(request, response);
            return;
        }

        try {
            int employeeid = Integer.parseInt(employeeidParam);
            boolean isDeleted = new ViewDAO().deleteEmployeeById(employeeid);
            
            if (isDeleted) {
                request.setAttribute("msg", "Employee deleted successfully.");
            } else {
                request.setAttribute("msg", "Failed to delete employee.");
            }
            request.getRequestDispatcher("ViewController").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("msg", "Invalid employee ID format.");
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }
}

