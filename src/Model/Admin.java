package Model;
import java.util.*;

import static controller.AdminOperation.*;
public class Admin {
	int Admin_Id=0;
	String Admin_Name="";
	long Admin_PhoneNo=0;
	String Admin_Email="";
	String Admin_Password="";
	public Admin()
	{
		this.Admin_Id=0;
		this.Admin_Name=null;
		this.Admin_PhoneNo=0;
		this.Admin_Email=null;
		this.Admin_Password=null;
	}
	public Admin(int Admin_Id, String Admin_Name, long Admin_PhoneNo, String Admin_Email,String Admin_Password)
	{
		this.Admin_Id=Admin_Id;
		this.Admin_Name=Admin_Name;
		this.Admin_PhoneNo=Admin_PhoneNo;
		this.Admin_Email=Admin_Email;
		this.Admin_Password=Admin_Password;
	}
	public void setAid(int aid)
	{
		this.Admin_Id=aid;
	}
	public int getAid()
	{
		return this.Admin_Id;
	}
	public void setAname(String name)
	 {
		 this.Admin_Name=name;
	 }
	 public String getAname()
	 {
		 return this.Admin_Name;
	 }
	 public void setphno(long phno)
	 {
		 this.Admin_PhoneNo=phno;
	 }
	 public long getphno()
	 {
		 return this.Admin_PhoneNo;
	 }
	  public void setEmail(String mail)
	 {
		 this.Admin_Email=mail;
	 }
	 public String getEmail()
	 {
		 return this.Admin_Email;
	 }
	 public void setpass(String pass)
	 {
		 this.Admin_Password=pass;
	 }
	 public String getpass()
	 {
		 return this.Admin_Password;
	 }
	public Admin validAdmin(String Admin_Email, String Admin_Password )
	{
		return valid_Admin(Admin_Email,Admin_Password);
		
	}
	public static List<Transaction> viewAllDelivery(Transaction transaction)
	{
		return viewDeliveries(transaction);
	}
	public int viewTotalAmount(String date)
	{
		return view_TotalAmount(date);
	}
	public List<Transaction> viewTransaction(String date)
	{
		return TransactionDetails(date);
	}

}
