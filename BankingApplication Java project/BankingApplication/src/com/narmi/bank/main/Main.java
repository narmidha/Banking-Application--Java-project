
package com.narmi.bank.main;
import com.narmi.bank.entity.User;
import com.narmi.bank.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
private static Scanner scanner=new Scanner(System.in);
static Main main=new Main();
static UserService userService=new UserService();
	
    public static void main (String[]args)
    {   while(true)
    {
    	//Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter your Username:");
    	String username=scanner.next();//error katum because mela private la iruku and enga public static la iruku so static ku mela kutukanum
    	System.out.println("Enter your"
    			+ " Password:");
    	String password=scanner.next();
    	//System.out.println(username +" "+password);
    	
    	User user=userService.login(username, password);
    	if(user != null && user.getRole().equals("admin"))
    	{
    		main.initiadmin();
    	}
    	else if(user != null && user.getRole().equals("user"))
    	{
    		main.initCustomer(user);
    	}
    	else
    	{
    		System.out.println("Login Falied");
    	}
    	
    	
    }}
    private void initiadmin()
	{   String userid="";
    	boolean flag=true;
    	while(flag)
    	{
    		System.out.println("1. Exit / Logout");
    		System.out.println("2. Add customer");
    		System.out.println("3. See All Transaction");
    		System.out.println("4. Check BankBalance");
    		System.out.println("5. Approve ChequeBook Request");
    		int selectoption1=scanner.nextInt();
    		switch(selectoption1)
    		{
    		case 1:
    			System.out.println("you are logged out successfully");
    			flag=false;
    			break;
    		case 2:
    			main.addNewCustomer();
    			break;
    		case 3:
    			System.out.println("Enter UserId:");
    			userid=scanner.next();
    			printTranscation(userid);
    			break;
    		case 4:
    			System.out.println("Enter userId");
    			userid=scanner.next();
    			Double accountBalance=checkBankBalance(userid);
    			System.out.println("Your AccountBalance is "+accountBalance);
    			break;
    		case 5:
    			List<String>userIds=getUseridforChequeBookRequest();
    			System.out.println("Please select UserId from below.....");
    			System.out.println(userIds);
    			userid=scanner.next();
    			approveChequeBookRequest(userid);
    			System.out.println("Cheque BookRequest is Approved...");
    			break;
    		default:
    			System.out.println("you are entered wrong option");
    		}
    	}
    	
	}
    private void addNewCustomer()
    {
    	System.out.println("Enter your name:");
    	String username=scanner.next();
    	System.out.println("Enter your password:");
    	String password=scanner.next();
    	System.out.println("Enter your contactnumber:");
    	Double contactnumber=scanner.nextDouble();
    	boolean result=userService.addNewCustomer(username, password, password);
    	if(result)
    	{
    		System.out.println("Customer account is created...");
    	}
    	else
    	{
    		System.out.println("Not created");
    	}
    	
    }
	private void initCustomer(User user)
	{
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Exit/Logout");
			System.out.println("2.Check BankBalance");
			System.out.println("3.Fund Transfer");
			System.out.println("4.See All Transcation");
			System.out.println("5.Raise ChequeBook Request");
			int selectoption2=scanner.nextInt();
			switch(selectoption2)
			{
			case 1:
    			System.out.println("you are logged out successfully");
    			flag=false;
    			break;
			case 2:
				Double balance=main.checkBankBalance(user.getUsername());
				if(balance!=null)
				{
					System.out.println("Your Bank Balance is "+balance);
				}
				else
				{
				  System.out.println("Check your Username");	
				}
				break;
			case 3:
				main.fundTransfer(user);
				break;
			case 4:
				main.printTranscation(user.getUsername());
				break;
			case 5:
				String userid=user.getUsername();
				Map<String,Boolean>map=getAllChequeBookRequest();
				if(map.containsKey(userid)&&(map.get(userid)))
				{
					System.out.println("You have already raised a request and It is already approved");
				}
				else if(map.containsKey(userid)&& !(map.get(userid)))
				{
					System.out.println("You have already raised a request and It is pending for approval");
				}
				else
				{
			    System.out.println("Request Raised Sucessfully.....");
				raiseChequeBookRequest(user.getUsername());
				}
				break;
    		default:
    			System.out.println("you are entered wrong option");
    		}
			}
		}
	public Double checkBankBalance(String userid)
    {
	 return userService.checkBankBalance(userid);	
    }
	private void  fundTransfer(User userDetails)
	{
		System.out.println("Enter payee account userid:");
		String payeeAccountId=scanner.next();
		User user=getUser(payeeAccountId);
		if(user!=null)
		{
			System.out.println("Enter amount to be transfer:");
			Double amount=scanner.nextDouble();
			Double userAccountBalance=checkBankBalance(userDetails.getUsername());
			if(userAccountBalance>=amount)
			{
				boolean result=userService.transferAmount(userDetails.getUsername(), payeeAccountId, amount);
				if(result)
				{
					System.out.println("Amount is transferred sucessfully...");
				}
				else
				{
					System.out.println("Transaction failed...");
				}
			}
			else
			{
				System.out.println("Your balance is insufficient "+userAccountBalance);
			}
		
		
		
		}
		else
		{
			System.out.println("Please enter validusername..");
		}
	}
	private User getUser(String userid)
	{
		return  userService.getUser(userid);
	}
	private void printTranscation(String userid)
	{
		userService.printTranscation(userid);
	}
	private void raiseChequeBookRequest(String userid)
	{
		userService.raiseChequeBookRequest(userid);
	}
	private Map<String,Boolean>getAllChequeBookRequest()
	{
		return userService.getAllChequeBookRequest();
	}
	private List<String>getUseridforChequeBookRequest()
	{
		return userService.getUseridforChequeBookRequest();
	}
	private void approveChequeBookRequest(String userid)
	{
		userService.approveChequeBookRequest(userid);
	}
    }
		
	
