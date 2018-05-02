package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Handle ch = new Handle();
		String type = null;
		int valid = ch.userExist(username, password, 0);
		
		if (valid < 0) {
			//This is where you will navigate to a employee view page
			response.sendRedirect("EmployeeLogin.jsp");
		} else {
			//This is where you will recurse to the login page
			HttpSession session = request.getSession();
			session.setAttribute("user", ch.getEmployee(username, password));
			switch(valid) {
			case 0:
				type = "Manager";
				session.setAttribute("type", type);
				response.sendRedirect("manager.jsp");
				break;	
			case 1:
				type = "Maintainer";
				session.setAttribute("type", type);
				response.sendRedirect("maintainer.jsp");
				break;
			case 2:
				type = "Shopper";
				session.setAttribute("type", type);
				response.sendRedirect("shopper.jsp");
				break;
			case 3:
				type = "Driver";
				session.setAttribute("type", type);
				response.sendRedirect("driver.jsp");
				break;
			default:
				response.sendRedirect("EmployeeLogin.jsp");
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
