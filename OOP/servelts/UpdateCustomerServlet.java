package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import com.customer.customerDBUtil;

@WebServlet ("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("fid");//input type name passed in the update form
		String feedback=request.getParameter("feedback");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");

		
		
		
		boolean isTrue;
		
		isTrue=customerDBUtil.updateFeedback(id,feedback, name, email, phone);
		
		if(isTrue==true)
		{
			List<Feedback> feedDetails=customerDBUtil.getFeedbackDetails(id);//cusDetails should be the same value in the jsp page items value
			request.setAttribute("feedDetails",feedDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
			
		}
		
		else
		{
			
			List<Feedback> feedDetails=customerDBUtil.getFeedbackDetails(id);//cusDetails should be the same value in the jsp page items value
			request.setAttribute("feedDetails",feedDetails);
			
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
			
		}
		
		
	}

}
