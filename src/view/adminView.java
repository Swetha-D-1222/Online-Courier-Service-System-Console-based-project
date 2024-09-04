package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.journaldev.maven.classes.SMSSender;

import Model.Admin;
import Model.SendingDetails;
import Model.Staff;
import Model.Transaction;
import controller.AdminOperations;
import controller.TransactionOperation;

public class adminView {
	private static Scanner sc=OnlineCourierService.sc;
	public void view()
	{
		System.out.println("Enter your Mail Id :");
		String email=sc.nextLine();
		System.out.println("Enter your Password :");
		String password=sc.nextLine();
		Admin admin=new Admin();
		admin=admin.validAdmin(email, password);
		if(admin!=null)
		{
			while(true)
			{
				SendingDetails sd=new SendingDetails();
				Transaction transaction =new Transaction();
				System.out.println("1) View All Delivery\n2) View Transaction \n3) Add Staff Member \n4) View All Staff Member");
				int choice=sc.nextInt();
				if(choice==1)
				{
					List<Transaction> trans=TransactionOperation.view_Deliveries(transaction);
					if(trans!=null)
					{
						for(Transaction t:trans)
						{
							System.out.println("Transaction Id : "+t.getTransactionId()+" Sending Id : "+t.getSendingId()+" Amount Payed :  "+t.getAmount()+" Delivered Date : "+t.getDeldate()+" Delivered Status : "+t.getIsDelivered());
						}
					}
					
				}
				if(choice==2)
				{
					System.out.println("1) View Transaction of a Particular Date");
					int n=sc.nextInt();
					if(n==1)
					{
						System.out.println("Enter Date : ");
						String date=sc.next();
						sc.nextLine();
						System.out.println("1) View Total Transaction Amount\n2) View All Transaction");
						int adminChoice=sc.nextInt();
						if(adminChoice==1)
						{
							int amount=admin.viewTotalAmount(date);
							System.out.println("Total Amount : "+amount);	
						}
						if(adminChoice==2)
						{
							List<Transaction> trans=admin.viewTransaction(date);
							for(Transaction t:trans)
							{
								System.out.println("Transaction Id : "+t.getTransactionId()+" Delivered Date : "+t.getDeldate()+" Amount Payed :  "+t.getAmount());
							}
							
						}
					}
				}
				if(choice ==3)
				{
					System.out.println("Enter Staff Name :");
					String staff_Name=sc.next();
					System.out.println("Enter Staff Phone Number : ");
					long staff_phNo=sc.nextLong();
					sc.nextLine();
					System.out.println("Enter Staff Email Id : ");
					String staff_Email=sc.next();
					sc.nextLine();
					System.out.println("Enter Staff password : ");
					String staff_Password=sc.next();
					sc.nextLine();
					Staff staff=new Staff();
					staff.setStaff_Name(staff_Name);
					staff.setStaff_PhoneNo(staff_phNo);
					staff.setStaff_Email(staff_Email);
					staff.setStaff_Password(staff_Password);
					AdminOperations.add_Staff(staff);
					
				}
				if(choice ==4)
				{
					List<Staff> staff=AdminOperations.view_All_Staff();
					for(Staff s:staff)
					{
						System.out.println("Staff Id : "+s.getStaff_Id()+" | Staff Name : "+s.getStaff_Name()+" | Staff Phone Number : "+s.getStaff_PhoneNo()+" | Staff Email : "+s.getStaff_Email()+" | Staff Password : "+s.getStaff_Password());
					}
				}
			}
		}
	}
	public void requestTosendOtp() 
	{
		System.out.println("Enter receiver Email Id :");
		String email=sc.next();
		sc.nextLine();
		System.out.println(email);
		sendingDetailsView sd=new sendingDetailsView();
		int otp=sd.getOtp(email);
		int s_Id=sd.getSending_Id(email);
		SMSSender sms=new SMSSender();
		boolean b=SMSSender.sendOtpToCustomer(otp,email);
		if(b)
		{
			System.out.println("Amount to be payed");
			int amount=sc.nextInt();
			TransactionView trans=new TransactionView();
			trans.updateDetails(s_Id,amount);
		}
	}
}
