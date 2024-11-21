package com.revathy.bank.service;
import java.util.List;
import java.util.Map;

import com.revathy.bank.entity.User;
import com.revathy.bank.repository.UserRepository;
public class UserService {
    
	UserRepository userRepository=new UserRepository();
	
	/*public void printUser()
	{
		userRepository.printUser();
	} */
	
	public User login(String username,String password)
	{
		return userRepository.login(username, password);
		
	}
	public boolean addNewCustomer(String username,String password,String contactnumber)
    {
   	 return userRepository.addNewCustomer(username, password, contactnumber);
    }
	public Double checkBankBalance(String userid)
    {
		return userRepository.checkBankBalance(userid);
    }
	public User getUser(String userid)
    {
		return userRepository.getUser(userid);
    }
	 public boolean transferAmount(String userid,String payeeuserid,Double amount)
     {
       return userRepository.transferAmount(userid, payeeuserid, amount);
     }
	 public void printTranscation(String userid)
	 {
		 userRepository.printTransaction(userid);
	 }
	 public void raiseChequeBookRequest(String userid)
	 	{
		 userRepository.raiseChequeBookRequest(userid);
	 	}
	 public Map<String,Boolean>getAllChequeBookRequest()
	 	{
	 		return userRepository.getAllChequeBookRequest();
	 	}
	 public List<String>getUseridforChequeBookRequest()
	 	{
	 	return userRepository.getUseridforChequeBookRequest();
	 	}
	 public  void approveChequeBookRequest(String userid)
	 	{
		 userRepository.approveChequeBookRequest(userid);
	 	}
}

