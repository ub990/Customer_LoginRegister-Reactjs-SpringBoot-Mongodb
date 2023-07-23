package com.example.SpringBoot_Code.bean;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	@Transient
	public static final String SEQUNCE_NAME = "user_sequence";
	
	@Id
	private int custid;
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
	
	public Customer() {
		
	}

	public Customer(int custid, String username, String password, String firstName, String lastName, String email, String phone) 
	{
		super();
		this.custid=custid; 
		this.username=username; 
		this.password=password; 
		this.firstName=firstName; 
		this.lastName=lastName; 
		this.email=email; 
		this.phone=phone; 
		
	}



	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + "]";
	}
	
}

