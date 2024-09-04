package controller;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static Model.DBConnectivity.getPreparedStatement;
import Model.*;

public class AdminOperations {
	public static Admin valid_Admin(String email,String pass){
		try {
			String query="select * from admin where Admin_Email=? and Admin_Password=?";
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1,email);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery();
			boolean b=rs.next();
			if(b) {
				return new Admin(rs.getInt("Admin_Id"),
						rs.getString("Admin_Name"),
						rs.getLong("Admin_PhoneNo"),
						rs.getString("Admin_Email"),
						rs.getString("Admin_Password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void add_Staff(Staff staff) {
		String query="insert into Staff(Staff_Name,Staff_PhoneNo,Staff_Email,Staff_Password) VALUES (?,?,?,?);";
		try {
			PreparedStatement stmt=getPreparedStatement(query);
			stmt.setString(1, staff.getStaff_Name());
			stmt.setLong(2,staff.getStaff_PhoneNo());
			stmt.setString(3, staff.getStaff_Email());
			stmt.setString(4, staff.getStaff_Password());
			stmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ArrayList<Staff> view_All_Staff() {
		String query="select * from Staff";
		try {
			ArrayList<Staff> staff=new ArrayList<>();
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				staff.add(new Staff(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5)));
			}
			return staff;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<SendingDetails> view_All_SendingDetails() {
		String query="select * from SendingDetails";
		try {
			ArrayList<SendingDetails> sendingDetails=new ArrayList<>();
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				sendingDetails.add(new SendingDetails(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getLong(7),rs.getString(8),rs.getInt(9)));
			}
			return sendingDetails;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<Transaction> view_Deliveries() {
		String query="select * from transaction";
		try {
			List<Transaction> transactions=new ArrayList<Transaction> ();
			PreparedStatement stmt=getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				transactions.add(new Transaction(rs.getInt(1),
						rs.getInt("Sending_Id"),
						rs.getDouble("Amount"),
						rs.getString("Delivered_Date"),
						rs.getString("IsDelivered")));
			}
			return transactions;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
