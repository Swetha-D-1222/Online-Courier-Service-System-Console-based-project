package view;
import java.util.Scanner;

import Model.Admin;
import Model.Customer;
public class customerView 
{
	private static Scanner sc=OnlineCourierService.sc;
	public void view()
	{
		System.out.println("1) LOGIN\n2)REGISTER");
		int customerChoice=sc.nextInt();
		if(customerChoice==1)
		{
			CustomerLogin();
		}
			
		if(customerChoice==2)
		{
			System.out.println("~~~~~~~~ CUSTOMER REGISTER ~~~~~~~~");
			sc.nextLine();
			System.out.println("Enter your Name : ");
			String Customer_Name=sc.nextLine();
			System.out.println("Enter your Address :");
			String Customer_Address=sc.nextLine();
			System.out.println("Enter your PinCode :");
			int Customer_PinCode=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your Phone Number : ");
			long Customer_PhoneNo=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter your Aadhaar Number :");
			long Customer_AadhaarNo=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter a valid userName :");
			String Customer_UserName=sc.nextLine();
			System.out.println("Enter your Email Id :");
			String Customer_Email=sc.nextLine();
			System.out.println("Enter your Password : ");
			String Customer_Passowrd=sc.nextLine();
			Customer customer=new Customer();
			customer.setCname(Customer_Name);
			customer.setCaddress(Customer_Address);
			customer.setPinCode(Customer_PinCode);
			customer.setphno(Customer_PhoneNo);
			customer.setAdhaar(Customer_AadhaarNo);
			customer.setEmail(Customer_Email);
			customer.setUsername(Customer_UserName);
			customer.setpass(Customer_Passowrd);
			customer=customer.registerCustomer(customer);
			if(customer!=null)
			{
				System.out.println("Customer Registered Successfully");
				System.out.println("You can now login an proceed with the service ");
				CustomerLogin();
			}
		}
	}
	private void CustomerLogin() {
		System.out.println("~~~~~~~~ CUSTOMER LOGIN ~~~~~~~~");
		System.out.println("Enter your Mail Id : ");
		String Customer_MailId=sc.next();
		sc.nextLine();
//		System.out.println(Customer_MailId);
		System.out.println("Enter your password : ");
		String Customer_Password=sc.nextLine();
		Customer customer=new Customer();
		customer=customer.validCustomer( Customer_MailId, Customer_Password);
		//System.out.println(customer);
		if(customer!=null)
		{
			while(true)
			{
				System.out.println(".-.-.-.-.- WELCOME -.-.-.-.-.");
				System.out.println("1) SEND\n2) REQUEST OTP");
				int yourChoice=sc.nextInt();
				if(yourChoice==1)
				{
					sendingDetailsView sdv=new sendingDetailsView();
					sdv.EnterDetails(customer);
				}
				if(yourChoice==2)
				{
					adminView admin=new adminView();
					admin.requestTosendOtp();
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
}
