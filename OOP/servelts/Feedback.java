package com.customer;

public class Feedback 
{
	private int id;
	private String feedback;
	private String name;
	private String email;
	private String phone;
	
	
	public Feedback(int id, String feedback, String name, String email, String phone) {
		super();
		this.id = id;
		this.feedback = feedback;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public String getFeedback() {
		return feedback;
	}



	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}



	public String getPhone() {
		return phone;
	}


	

}
