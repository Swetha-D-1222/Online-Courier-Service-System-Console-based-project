package Model;
import static controller.SendingDetailsOperation.*;
public class SendingDetails {
	int Sending_Id;
	int Sender_Id;
	String product_Type;
	String receiver_Name;
	String receiver_Address;
	int receiver_pinCode;
	long receiver_PhNo;
	String receiver_Email;
	int receiver_Otp;
	public SendingDetails(int Sending_Id, int Sender_Id, String product_Type, String receiver_Name, String receiver_Address, int receiver_pinCode, long receiver_PhNo, String receiver_Email, int receiver_Otp)
	{
		this.Sending_Id=Sending_Id;
		this.Sender_Id=Sender_Id;
		this.product_Type=product_Type;
		this.receiver_Name=receiver_Name;
		this.receiver_Address=receiver_Address;
		this.receiver_pinCode=receiver_pinCode;
		this.receiver_PhNo=receiver_PhNo;
		this.receiver_Email=receiver_Email;
		this.receiver_Otp=receiver_Otp;
	}
	public SendingDetails()
	{
		this.Sending_Id=0;
		this.Sender_Id=0;
		this.product_Type=null;
		this.receiver_Name=null;
		this.receiver_Address=null;
		this.receiver_pinCode=0;
		this.receiver_PhNo=0;
		this.receiver_Email=null;
		this.receiver_Otp=0;
	}
	public SendingDetails(int Sending_Id)
	{
		this.Sending_Id=Sending_Id;
	}
	public void setType(String type)
	{
		this.product_Type=type;
	}
	public String getType()
	{
		return this.product_Type;
	}
	public void setsendId(int sid)
	{
		this.Sending_Id=sid;
	}
	public int getsendId()
	{
		return this.Sending_Id;
	}
	public void setsenderId(int senderId)
	{
		this.Sender_Id=senderId;
	}
	public int getsenderId()
	{
		return this.Sender_Id;
	}
	public void setRname(String name)
	{
		this.receiver_Name=name;
	}
	public String getRname()
	{
		return this.receiver_Name;
	}
	public void setRaddress(String rAdd)
	{
		this.receiver_Address=rAdd;
	}
	public String getRaddress()
	{
		return this.receiver_Address;
	}
	public void setRpinCode(int pin)
	{
		this.receiver_pinCode=pin;
	}
	public int getRpinCode()
	{
		return this.receiver_pinCode;
	}
	public void setRphno(long phno)
	{
		this.receiver_PhNo=phno;
	}
	public long getRphno()
	{
		return this.receiver_PhNo;
	}
	public void setRemail(String email)
	{
		this.receiver_Email=email;
	}
	public String getRemail()
	{
		return this.receiver_Email;
	}
	public void setRotp(int otp)
	{
		this.receiver_Otp=otp;
	}
	public int getRotp()
	{
		return this.receiver_Otp;
	}
//	public SendingDetails insertRecord(SendingDetails sendingdetails)
//	{
//		return insert_Record(sendingdetails);
//		
//	}
	public int getOtp(String email) {
		// TODO Auto-generated method stub
		return get_Otp(email);
	}
	public int getSending_Id(String email) {
		// TODO Auto-generated method stub
		return sending_Id(email);
	}
	public SendingDetails getSendingDetails(SendingDetails details)
	{
		return get_SendingDetail(details);
		
	}
}
