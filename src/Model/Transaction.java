package Model;

import java.util.ArrayList;
import java.util.List;

import static controller.TransactionOperation.*;
public class Transaction 
{
	int Transaction_Id;
	int Sending_Id;
	double Amount;
	String Delivered_Date;
	String Is_Delivered;
	public Transaction()
	{
		this.Transaction_Id=0;
		this.Sending_Id=0;
		this.Amount=0;
		this.Delivered_Date=null;
		this.Is_Delivered=null;
	}
	public Transaction(int Transaction_Id,int Sending_Id,double Amount,String Delivered_Date,String Is_Delivered)
	{
		this.Transaction_Id=Transaction_Id;
		this.Sending_Id=Sending_Id;
		this.Amount=Amount;
		this.Delivered_Date=Delivered_Date;
		this.Is_Delivered=Is_Delivered;
	}
	public Transaction(int Transaction_Id,String Delivered_Date,double Amount)
	{
		this.Transaction_Id=Transaction_Id;
		this.Delivered_Date=Delivered_Date;
		this.Amount=Amount;
	}
	public void setTransactionId(int sid)
	{
		this.Transaction_Id=sid;
	}
	public int getTransactionId()
	{
		return this.Transaction_Id;
	}
	public void setSendingId(int sid)
	{
		this.Sending_Id=sid;
	}
	public int getSendingId()
	{
		return this.Sending_Id;
	}
	public void setAmount(double amt)
	{
		this.Amount=amt;
	}
	public double getAmount()
	{
		return this.Amount;
	}
	public void setDeldate(String date)
	{
		this.Delivered_Date=date;
	}
	public String getDeldate()
	{
		return this.Delivered_Date;
	}
	public void setIsDelivered(String isDel)
	{
		this.Is_Delivered=isDel;
	}
	public String getIsDelivered()
	{
		return Is_Delivered;
	}
//	public Transaction insertRecord(Transaction transaction)
//	{
//		return insert_Record(transaction);
//	}
	public List<Transaction> viewAllDelivery(Transaction transaction)
	{
		return view_Deliveries(transaction);
	}
	public void update_Detail(int s_Id, int amount)
	{
		update_Details(s_Id,amount);
	}

}
