package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDAO;
import com.model.AdminModel;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminModel rmodel=new AdminModel();
		rmodel.setFirstname(request.getParameter("firstname"));
		rmodel.setLastname(request.getParameter("lastname"));
		rmodel.setUsername(request.getParameter("username"));
		rmodel.setPassword(request.getParameter("password"));
		
		int x=new RegisterDAO().getAdminData(rmodel);
		
		if(x>0)
		{
			request.setAttribute("msg", "Registration Successfull...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Registration UnSuccessfull...");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
				
	}

}
