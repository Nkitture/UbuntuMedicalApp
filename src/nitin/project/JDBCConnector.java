package nitin.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {

	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
		  Class.forName(Constant.DRIVER);
		  con=DriverManager.getConnection(Constant.URL,Constant.UID,Constant.PASS);
		//  System.out.println("Print "+con);
		  return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection c)
	{
		if(c!=null)
		{
			try
			{
				c.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement c)
	{
		if(c!=null)
		{
			try
			{
				c.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet c)
	{
		if(c!=null)
		{
			try
			{
				c.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
}
