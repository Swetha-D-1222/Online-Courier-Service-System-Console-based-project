package Model;
import static controller.CustomerOperation.*;
public class Customer {
	int Customer_Id;
	String Customer_Name;
	String Customer_Address;
	int Customer_PinCode;
	long Customer_PhoneNo;
	long Customer_AdhaarNo;
	String Customer_UserName;
	String Customer_Email;
	String Customer_Password;
	public Customer()
	{
		this.Customer_Id=0;
		this.Customer_Name=null;
		this.Customer_Address=null;
		this.Customer_PinCode=0;
		this.Customer_PhoneNo=0;
		this.Customer_AdhaarNo=0;
		this.Customer_UserName=null;
		this.Customer_Email=null;
		this.Customer_Password=null;
		
	}
	public Customer(int Customer_Id,String Customer_Name,String Customer_Address,int Customer_PinCode,long Customer_PhoneNo,Long Customer_AdhaarNo,String Customer_UserName,String Customer_Email,String Customer_Password)
	{
		this.Customer_Id=Customer_Id;
		this.Customer_Name=Customer_Name;
		this.Customer_Address=Customer_Address;
		this.Customer_PinCode=Customer_PinCode;
		this.Customer_PhoneNo=Customer_PhoneNo;
		this.Customer_AdhaarNo=Customer_AdhaarNo;
		this.Customer_UserName=Customer_UserName;
		this.Customer_Email=Customer_Email;
		this.Customer_Password=Customer_Password;
		
	}
	public void setCid(int cid)
	{
		this.Customer_Id=cid;
	}
	public int getCid()
	{
		return this.Customer_Id;
	}
	 public void setCname(String name)
	 {
		 this.Customer_Name=name;
	 }
	 public String getCname()
	 {
		 return this.Customer_Name;
	 }
	 public void setCaddress(String add)
	 {
		 this.Customer_Address=add;
	 }
	 public String getCaddress()
	 {
		 return this.Customer_Address;
	 }
	 public void setPinCode(int pincode)
	 {
		 this.Customer_PinCode=pincode;
	 }
	 public int getPinCode()
	 {
		 return this.Customer_PinCode;
	 }
	 public void setphno(long phno)
	 {
		 this.Customer_PhoneNo=phno;
	 }
	 public long getphno()
	 {
		 return this.Customer_PhoneNo;
	 }
	 public void setUsername(String uname)
	 {
		 this.Customer_UserName=uname;
	 }
	 public String getUsername()
	 {
		 return this.Customer_UserName;
	 }
	 public void setAdhaar(long adhaar)
	 {
		 this.Customer_AdhaarNo=adhaar;
	 }
	 public long getAdhaar()
	 {
		 return this.Customer_AdhaarNo;
	 }
	 public void setEmail(String mail)
	 {
		 this.Customer_Email=mail;
	 }
	 public String getEmail()
	 {
		 return this.Customer_Email;
	 }
	 public void setpass(String pass)
	 {
		 this.Customer_Password=pass;
	 }
	 public String getpass()
	 {
		 return this.Customer_Password;
	 }
	 public Customer validCustomer(String email, String pass) 
	 {
		 return valid_Customer(email,pass);
	 }
	public Customer registerCustomer(Customer customer) 
	{
		return register_Customer(customer);
		
	}
	
	

}
