package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ViewDAO;
import com.model.EmployeeModel;


@WebServlet("/EditController")
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeidParam = request.getParameter("id"); // Ensure this matches the query parameter name in the JSP
        if (employeeidParam == null || employeeidParam.isEmpty()) {
            request.setAttribute("msg", "Invalid employee ID.");
            request.getRequestDispatcher("view.jsp").forward(request, response);
            return;
        }

        try {
            int employeeid = Integer.parseInt(employeeidParam);
            EmployeeModel employee = new ViewDAO().getEmployeeById(employeeid);
            
            if (employee != null) {
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Employee not found.");
                request.getRequestDispatcher("view.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("msg", "Invalid employee ID format.");
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeidParam = request.getParameter("employeeid");
        if (employeeidParam == null || employeeidParam.isEmpty()) {
            request.setAttribute("msg", "Invalid employee ID.");
            request.getRequestDispatcher("edit.jsp").forward(request, response);
            return;
        }

        try {
            int employeeid = Integer.parseInt(employeeidParam);
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");

            EmployeeModel emp = new EmployeeModel();
            emp.setEmployeeid(employeeid);
            emp.setFirstname(firstname);
            emp.setLastname(lastname);
            emp.setEmail(email);
            emp.setMobile(mobile);
            emp.setAddress(address);
            emp.setGender(gender);
            emp.setPassword(password);

            boolean isUpdated = new ViewDAO().updateEmployee(emp);

            if (isUpdated) {
                request.setAttribute("msg", "Employee updated successfully.");
                response.sendRedirect("ViewController"); // Redirect to avoid form resubmission issue
            } else {
                request.setAttribute("msg", "Failed to update employee.");
                request.setAttribute("employee", emp);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("msg", "Invalid employee ID format.");
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }
}

