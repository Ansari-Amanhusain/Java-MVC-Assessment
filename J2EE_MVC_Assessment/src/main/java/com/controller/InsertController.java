package com.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InsertDAO;
import com.model.EmployeeModel;

@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmployeeModel emodel=new EmployeeModel();
		emodel.setFirstname(request.getParameter("firstname"));
		emodel.setLastname(request.getParameter("lastname"));
		emodel.setEmail(request.getParameter("email"));
		emodel.setMobile(request.getParameter("mobile"));
		emodel.setAddress(request.getParameter("address"));
		emodel.setGender(request.getParameter("gender"));
		emodel.setPassword(request.getParameter("password"));
		emodel.setConfirmpassword(request.getParameter("confirmpassword"));
		
		int x=new InsertDAO().employeeInsert(emodel);
		
		if(x>0)
		{
			request.setAttribute("msg", "Record inserted Successfully...");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Record not inserted...");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}
	}

}
