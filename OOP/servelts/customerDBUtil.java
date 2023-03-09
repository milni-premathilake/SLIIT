package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class customerDBUtil 
{
	public static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
	/*public static List<Customer> validate(String userName,String password)
	{
		ArrayList<Customer> cus=new ArrayList<>();
		
		//create database connection
		
		
		//validate
		try 
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			
			
			String sql="select * from customer where username='" +userName+"' and password='" +password+"' ";
			
			rs=stmt.executeQuery(sql);
			
			
			if(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String userU=rs.getString(5);
				String passU=rs.getString(6);
				
				Customer c=new Customer(id,name,email,phone,userU,passU);
				cus.add(c);
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		//return details to the customer class variables
		return cus;
	}
	*/
	
	public static boolean validation(String username,String password)
	{
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from customer where username='"+username+"'and password='"+password+"'";
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				isSuccess=true;
			}
			
			else
			{
				isSuccess=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
	
	public static List<Customer> getCustomer(String uname)
	{
		ArrayList<Customer> customer=new ArrayList<>();
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from customer where username='"+uname+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String username=rs.getString(5);
				String password=rs.getString(6);
				
				Customer cus=new Customer(id,name,email,phone,username,password);
				customer.add(cus);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return customer;
		
	}
	
	
	public static List<Feedback> getFeedback(String name)
	{
		ArrayList<Feedback> Feedback=new ArrayList<>();
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from feedback where name='"+name+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String feedback=rs.getString(2);
				String fname=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				
				Feedback fd=new Feedback(id,feedback,fname,email,phone);
				Feedback.add(fd);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return Feedback;
		
	}
	
	public static boolean InsertCustomer(String feedback,String name,String email,String phone)
	{
		boolean isSuccess=false;
		
		
		try
		{
			//create db connection
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			
			
			String sql="insert into feedback values (0,'"+feedback+"' ,'"+name+"', '"+email+"', '"+phone+"')";
			int rs=stmt.executeUpdate(sql);//returns two values 1 and 0 if successfull 2 if not 0
			
			if(rs>0)
			{
				isSuccess=true;
			}
			
			else
			{
				isSuccess=false;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	public static boolean updateFeedback(String id,String feedback,String name,String email,String phone)
	{
		int convertedID=Integer.parseInt(id); 
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="update customer set feedback='"+feedback+"', name='"+name+"',email='"+email+"',phone='"+phone+"'"+"where id='"+ convertedID+"'";
			
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0)
			{
				isSuccess=true;
			}
			else
			{
				isSuccess=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
	public static List<Customer> getCustomerDetails(String id)
	{
		int convertedID=Integer.parseInt(id);
		
		ArrayList<Customer> cus=new ArrayList<>();
		
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from customer where id='"+convertedID+"'";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())//next method returns boolean value
			{
				int Id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String username=rs.getString(5);
				String password=rs.getString(6);
				
				Customer c= new Customer(Id,name,email,phone,username,password);
				cus.add(c);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return cus;
	}
	
	
	public static List<Feedback> getFeedbackDetails(String id)
	{
		int convertedID=Integer.parseInt(id);
		
		ArrayList<Feedback> fd=new ArrayList<>();
		
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from feedback where id='"+convertedID+"'";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next())//next method returns boolean value
			{
				int Id=rs.getInt(1);
				String feedback=rs.getString(2);
				String name=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				
				Feedback f= new Feedback(Id,feedback,name,email,phone);
				fd.add(f);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return fd;
	}
	
	
	
	
	public static boolean deleteCustomer(String id)
	{
		int convId=Integer.parseInt(id);
		
		try
		{
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="delete from customer where id='"+convId+"'";
			int r=stmt.executeUpdate(sql);
			
			if(r>0)
			{
				isSuccess=true;
			}
			else
			{
				isSuccess=false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}

}




