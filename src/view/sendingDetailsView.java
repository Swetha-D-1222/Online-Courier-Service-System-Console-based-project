package view;

import java.util.Random;
import java.util.Scanner;

import Model.Customer;
//import java.util.random.*;
import Model.SendingDetails;
import Model.Transaction;
import controller.SendingDetailsOperation;
import controller.TransactionOperation;
public class sendingDetailsView {
	private static Scanner sc=OnlineCourierService.sc;
	public Customer EnterDetails(Customer customer)
	{
		System.out.println("Enter ProductType : ");
		String product_Type=sc.next();
		sc.nextLine();
		//System.out.println(product_Type);
		System.out.println("Enter Receiver Name : ");
		String receiverName=sc.nextLine();
		System.out.println("Enter Receiver Address : ");
		String receiverAddress=sc.nextLine();
		System.out.println("Enter Receiver PinCode :");
		int receiverPinCode=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Receiver Phone Number : ");
		long receiverPhno=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter Receiver Email : ");
		String receiverEmail=sc.nextLine();
		SendingDetails detail=new SendingDetails();
		detail.setsenderId(customer.getCid());
		detail.setType(product_Type);
		detail.setRname(receiverName);
		detail.setRaddress(receiverAddress);
		detail.setRpinCode(receiverPinCode);
		detail.setRphno(receiverPhno);
		detail.setRemail(receiverEmail);
		Random rand=new Random();
		int rotp=rand.nextInt(10000);
		detail.setRotp(rotp);
		//System.out.println(product_Type+" "+receiverName+" "+receiverAddress+" "+receiverPinCode+" "+receiverPhno+" "+receiverEmail+" "+customer.getCid()+" "+rotp);
		System.out.println("Enter send to start your sending process");
		String s=sc.next();
		if(s.equalsIgnoreCase("send"))
		{
			SendingDetailsOperation.insert_Record(detail);
			System.out.println("Your Courier will be processed");
			//TransactionView transaction=new TransactionView();
			TransactionOperation.insert_Record(detail);
		}
		else
		{
			System.out.println("Your courier is cannot be processed");
		}
		return customer;
		
		
	}
	public int getOtp(String email) 
	{
		SendingDetails sd=new SendingDetails();
		return sd.getOtp(email);
		
	}
	public int getSending_Id(String email) 
	{
		SendingDetails sd=new SendingDetails();
		return sd.getSending_Id(email);
	}
}
