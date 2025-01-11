package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.model.AdminModel;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminModel lmodel=new AdminModel();
		lmodel.setUsername(request.getParameter("username"));
		lmodel.setPassword(request.getParameter("password"));
		
		AdminModel model=new LoginDAO().loginData(lmodel);
		if(model != null)
		{
			HttpSession session = request.getSession(); 
			session.setAttribute("model", model); 
			session.setMaxInactiveInterval(60*2);
			response.sendRedirect("HomeController?action=showuser&userid="+model.getUserid());
		}
		else
		{
			request.setAttribute("msg", "Invalid UserName and Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
