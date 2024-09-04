package controller;
import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static controller.TransactionOperation.*;

import Model.Admin;
import Model.DBConnectivity;
import Model.Transaction;
public class AdminOperation {
	public static Admin valid_Admin(String email,String pass)//(Transaction transaction)
	{
		try
		{
			DBConnectivity.createConn();
			String query="select * from admin where Admin_Email=? and Admin_Password=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1,email);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b)
			{
				return new Admin(rs.getInt("Admin_Id"),
						rs.getString("Admin_Name"),
						rs.getLong("Admin_PhoneNo"),
						rs.getString("Admin_Email"),
						rs.getString("Admin_Password"));
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}
	public static List<Transaction> viewDeliveries(Transaction transaction)
	{
		return view_Deliveries(transaction);
		
	}
	public static int view_TotalAmount(String date) 
	{
		return view_Total(date);
	}
	public static List<Transaction> TransactionDetails(String date)
	{
		return transaction_Detail(date);
	}

}
