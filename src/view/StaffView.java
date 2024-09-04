package view;

import java.util.Scanner;

public class StaffView 
{
	private static Scanner sc=OnlineCourierService.sc;
	public void view()
	{
		System.out.println("Enter your MailId : ");
		String email=sc.next();
		sc.nextLine();
		System.out.println("Enter your password : ");
		String password=sc.next();
		sc.nextLine();
		
		
	}

}
