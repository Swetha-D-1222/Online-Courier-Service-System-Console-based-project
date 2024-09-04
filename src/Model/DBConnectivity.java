package Model;
import java.sql.*;

public class DBConnectivity {
	public static Connection con=null;
    public  DBConnectivity(){
        String mySQL_Url = "jdbc:mysql://localhost:3308/onlinecourier";
        String mySQL_User = "root";
        String mySQL_Password = "As122205.";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mySQL_Url,mySQL_User,mySQL_Password);
        }
        catch (ClassNotFoundException|SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void createConn()
    {
        DBConnectivity obj=new DBConnectivity();
    }
    public static PreparedStatement getPreparedStatement(String query) throws SQLException
    {
        return con.prepareStatement(query);
    }
    public static PreparedStatement getPreparedStatement1(String query,int p) throws SQLException
    {
        return con.prepareStatement(query,p);
    }
    public static void closeConn()
    {
        try
        {
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
