package controller;
import java.beans.Statement;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.DBConnectivity;
import Model.SendingDetails;
public class SendingDetailsOperation {
	public static void insert_Record(SendingDetails detail) 
	{
		try
		{
			DBConnectivity.createConn();
			String query="insert into sendingdetails(Sender_Id,Product_Type,Receiver_Name,Receiver_Address,Receiver_PinCode,Receiver_PhoneNo,Receiver_Email,Receiver_Otp,Sending_Date) VALUES (?,?,?,?,?,?,?,?,curdate())";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement1(query,java.sql.Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, detail.getsenderId());
			stmt.setString(2, detail.getType());
			stmt.setString(3, detail.getRname());
			stmt.setString(4,detail.getRaddress());
			stmt.setInt(5, detail.getRpinCode());
			stmt.setLong(6, detail.getRphno());
			stmt.setString(7, detail.getRemail());
			stmt.setInt(8, detail.getRotp());
			stmt.execute();
			ResultSet res=stmt.getGeneratedKeys();
			if(res.next())
			{
				detail.setsendId(res.getInt(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			}
	public static SendingDetails get_SendingDetail(SendingDetails details)
	{
		try
		{
			DBConnectivity.createConn();
			String query="select * from sendingdetails";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				return new SendingDetails(rs.getInt("Sending_Id"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return details;
		
	}
	public static int get_Otp(String email)
	{
		try
		{
			DBConnectivity.createConn();
			String query="select Receiver_Otp from sendingdetails where Receiver_Email=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				int otp=rs.getInt(1);
				return otp;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
	public static int sending_Id(String email)
	{
		try
		{
			DBConnectivity.createConn();
			String query="select Sending_Id from sendingdetails where Receiver_Email=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				int sid=rs.getInt(1);
				return sid;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}

}
