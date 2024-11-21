
package com.narmi.bank.entity;

import java.util.Objects;

/**
 * 
 */
public class User {
	private String username;
	private String password;
	private String contactnumber;
	private String role;
	private Double accountBalance;
  
  public User(String username,String password, String contactnumber,String role,Double accountBalance)
  {
	  this.username=username;
	  this.password=password;
	  this.contactnumber=contactnumber;
	  this.role=role;
	  this.accountBalance=accountBalance;
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



public String getContactnumber() {
	return contactnumber;
}



public void setContactnumber(String contactnumber) {
	this.contactnumber = contactnumber;
}



public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = role;
}



public Double getAccountBalance() {
	return accountBalance;
}



public void setAccountBalance(Double accountBalance) {
	this.accountBalance = accountBalance;
}



	public String toString()
	{
		return "User{"+"username="+username+'/'+"password="+password+'/'+"contactno="+contactnumber+'/'+"role="+role+'/'+"accountBalance="+accountBalance+'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactnumber, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contactnumber, other.contactnumber) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
	
	
}
