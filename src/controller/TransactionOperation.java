package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Model.DBConnectivity;
import Model.SendingDetails;
import Model.Transaction;
public class TransactionOperation {
	public static void insert_Record(SendingDetails detail)
	{
		try
		{
			DBConnectivity.createConn();
			String query="Insert into transaction(Sending_Id,IsDelivered) values(?,'no')";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setInt(1, detail.getsendId());
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//return transaction;
	}
	public static List<Transaction> view_Deliveries(Transaction transaction)
	{
		List<Transaction> DeliveryDetails=new ArrayList<Transaction> ();
		try
		{
			DBConnectivity.createConn();
			String query="select * from transaction";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				DeliveryDetails.add(new Transaction(rs.getInt(1),
						rs.getInt("Sending_Id"),
						rs.getDouble("Amount"),
						rs.getString("Delivered_Date"),
						rs.getString("IsDelivered")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return DeliveryDetails;
		
	}
	public static int view_Total(String date)
	{
		try
		{
			DBConnectivity.createConn();
			String query="select sum(Amount) from transaction where Delivered_Date=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			//ArrayList<ArrayList<String>> TransactionDetail=new ArrayList<ArrayList<String>>();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public static List<Transaction> transaction_Detail(String date)
	{
		List<Transaction> trans=new ArrayList<>();
		try
		{
			DBConnectivity.createConn();
			String query="select Transaction_Id,Delivered_Date,Amount from transaction where Delivered_Date=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setString(1, date);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				trans.add(new Transaction(rs.getInt(1),
						rs.getString("Delivered_Date"),
						rs.getDouble("Amount")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trans;
		
	}
	public static void update_Details(int s_Id,int amount)
	{
		try
		{
			DBConnectivity.createConn();
			String query="update transaction set Amount=?,Delivered_Date=curdate(),IsDelivered='yes' where Sending_Id=?";
			PreparedStatement stmt=DBConnectivity.getPreparedStatement(query);
			stmt.setInt(1, amount);
			stmt.setInt(2, s_Id);
			stmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
