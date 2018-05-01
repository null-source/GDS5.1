package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("customersEmail");
		String password = request.getParameter("customersPassword");
		EmpHandle ch = new EmpHandle();
		int valid = ch.empExist(email, password, 1); //1 used to indicate customer type (should work with anything but 0)
		
		
		if (valid < 0) {
			//invalid credentials redirect to login
			response.sendRedirect("customerLogin.jsp");
		} else {
			///customer navigation page
			HttpSession session = request.getSession();
			//session.setAttribute("username", email);
			response.sendRedirect("customer.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
