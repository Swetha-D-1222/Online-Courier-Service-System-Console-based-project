package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Customer;
import Model.DBConnectivity;

public class CustomerOperation {
	public static Customer valid_Customer(String email, String pass) 
	{
		try
		{
			DBConnectivity.createConn();
			String query="select * from customer where Customer_MailId = ? and Customer_Password = ? ";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, email);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b)
			{
				return new Customer(rs.getInt("Customer_Id"),
						rs.getString("Customer_Name"),
						rs.getString("Customer_Address"),
						rs.getInt("Customer_PinCode"),
						rs.getLong("Customer_PhoneNo"),
						rs.getLong("Customer_AdhaarNo"),
						rs.getString("Customer_UserName"),
						rs.getString("Customer_MailId"),
						rs.getString("Customer_Password"));
			}
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	public static Customer register_Customer(Customer customer) 
	{
		try
		{
			DBConnectivity.createConn();
			String query="insert into customer(Customer_Name,Customer_Address,Customer_PinCode,Customer_PhoneNo,Customer_AdhaarNo,Customer_UserName,Customer_MailId,Customer_Password) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, customer.getCname());
			stmt.setString(2,customer.getCaddress());
			stmt.setInt(3, customer.getPinCode());
			stmt.setLong(4, customer.getphno());
			stmt.setLong(5,customer.getAdhaar());
			stmt.setString(6, customer.getUsername());
			stmt.setString(7, customer.getEmail());
			stmt.setString(8, customer.getpass());
			stmt.execute();
			return customer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
