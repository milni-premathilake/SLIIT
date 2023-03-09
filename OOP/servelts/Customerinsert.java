package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

@WebServlet("/Customerinsert")
public class Customerinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//creating variables to catch the variables passed through form
		String feedback=request.getParameter("feedback");//input type name given in the form
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		
		boolean isTrue;
		isTrue=customerDBUtil.InsertCustomer(feedback,name, email, phone);
		
		if(isTrue==true)
		{
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request,response);
		}
		
		else
		{
			RequestDispatcher dis1=request.getRequestDispatcher("unsuccess.jsp");
			dis1.forward(request,response);
			
		}
		
		
		
		
	}

}
