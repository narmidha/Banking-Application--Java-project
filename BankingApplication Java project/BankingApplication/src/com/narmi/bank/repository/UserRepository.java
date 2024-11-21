package com.narmi.bank.repository;

import com.narmi.bank.entity.Transaction;
import com.narmi.bank.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepository {
     private static  Set<User>users=new HashSet<>();
     private static List<Transaction>transactions=new ArrayList<>();
     Map<String,Boolean>ChequeBookRequest=new HashMap<>();
     //static la detaila la kutukurom
     static {
    	 User user1=new User("admin","admin234","123456","admin",0.0);
    	 User user2=new User("revathy","revathy7","6711","user",10000.0);
    	 User user3=new User("balu","balu4","123","user",20000.0);
    	 User user4=new User("susi","susi4","123456","user",13000.0);
    	 User user5=new User("prasanna","susi4","123456","user",9000.0);
    	 
    	 users.add(user1);
    	 users.add(user2);
    	 users.add(user3);
    	 users.add(user4);
    	 users.add(user5);
    	 
     }
     public void printUser() {
    	 System.out.println(users);
     }
     public User login(String username,String password)
     {
    	List<User>finallist= users.stream().filter(user -> user.getUsername().equals(username)&& user.getPassword().equals(password)).collect(Collectors.toList());
    	
    	if(!finallist.isEmpty())
    	{
    		return finallist.get(0);
    	}
    	else
    	{
         return null;
    	}     
    	}
     public boolean addNewCustomer(String username,String password,String contactnumber)
     {   User user=new User(username,password,contactnumber,"user",500.00);
    	 return users.add(user);
     }
     public Double checkBankBalance(String userid)
     {
    	 List<User>result=users.stream().filter(user -> user.getUsername().equals(userid)).
    			 collect(Collectors.toList());
    	 if(!result.isEmpty())
    	 {
    		 return result.get(0).getAccountBalance();
    	 }
    	 else
    	 {
    		 return null;
    	 }
     }
     public User getUser(String userid)
     {
    	 List<User>result=users.stream().filter(user->user.getUsername().equals(userid)).collect(Collectors.toList());
    	 if(!result.isEmpty()) {
    		 return result.get(0);
    	 }
    	 else {
    	 return null;
    	 }
     }
     private boolean debit(String userid,Double amount,String payeeuserid)//for debit
     {
    	User user=getUser(userid);
    	Double accountBalance=user.getAccountBalance();
    	users.remove(user);
    	Double finalBalance=accountBalance-amount;
    	user.setAccountBalance(finalBalance);
    	Transaction transaction=new Transaction(
    			LocalDate.now(),
    			payeeuserid,
    			amount,"debit",accountBalance,finalBalance,userid
    			);
    	System.out.println(transaction);
    	transactions.add(transaction);
    	
    			
    	return users.add(user);
     }
     private boolean credit(String payeeuserid,Double amount,String userid)//for credit
     {
    	User user=getUser(payeeuserid);
    	Double accountBalance=user.getAccountBalance();
    	users.remove(user);
    	Double finalBalance=accountBalance+amount;
    	user.setAccountBalance(finalBalance);
    	Transaction transaction=new Transaction(
    			LocalDate.now(),
    			userid,
    			amount,"credit",accountBalance,finalBalance,payeeuserid
    			);
    	System.out.println(transaction);
    	transactions.add(transaction);
    			
    	return users.add(user);
     }
     public boolean transferAmount(String userid,String payeeuserid,Double amount)
     {
    	 boolean isDebit=debit(userid,amount, payeeuserid);
    	 boolean isCredit=credit(payeeuserid,amount, userid);
    	 return isDebit&&isCredit;
     }
     public void printTransaction(String userid)
     {
    	 List<Transaction>filteredtransaction=transactions.stream().filter(transaction -> transaction.getTransactionPerformedBy().equals(userid)).collect(Collectors.toList());
    	 System.out.println("  Date \t\t Userid \tAmount \t\t Type \t\t InitialBlance \t\t FinalBalance");
    	 System.out.println("-------------------------------------------------------------------------------------------------------");
    	 for(Transaction t: filteredtransaction)
    	 {
    		 System.out.println(t.getTranscationDate()+"\t"+t.getTransactionuserid()+"\t"+t.getTransactionAmount()+"\t\t "+t.getTransactionType()+"\t\t   "+t.getInitialBalance()+"\t\t    "+t.getFinalBalance());
    	 }
     	 System.out.println("-------------------------------------------------------------------------------------------------------");
     }
     public void raiseChequeBookRequest(String userid)
 	{
    	 ChequeBookRequest.put(userid,false);
 	}
     public Map<String,Boolean>getAllChequeBookRequest()
 	{
 		return ChequeBookRequest;
 	}
     public List<String>getUseridforChequeBookRequest()
 	{
 		List<String>userIds=new ArrayList<>();
 		for(Map.Entry<String,Boolean>entry :ChequeBookRequest.entrySet())
              {
	           if(!entry.getValue())
	           {
	        	   userIds.add(entry.getKey());
	           }
              }
 		return userIds;
 	}
     public  void approveChequeBookRequest(String userid)
 	{
 		if(ChequeBookRequest.containsKey(userid))
 		{
 			ChequeBookRequest.put(userid, true);
 		}
 	}
     
}
