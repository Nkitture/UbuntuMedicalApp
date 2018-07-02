package nitin.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

	public String companyCheck(CompanyBean cb)
	{
		String msg=cb.validateCompany();
		if(msg.equals(Constant.success))
		{
			
			PreparedStatement pst=null;
			Connection con=null;
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("insert into company(cname,person,address,contact)values(?,?,?,?)");
				pst.setString(1, cb.getCname());
				pst.setString(2, cb.getCperson());
				pst.setString(3, cb.getAddress());
				pst.setString(4, cb.getMobile());
				pst.execute();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in company table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		   } 
		return msg;
	}
	
	
	public String updateTable(String[]aa,String[]bb)
	{
		String item="";
		String value="";
		
		for(int i=1;i<aa.length;i++)
		{
			System.out.println("lllllllll "+aa[i]);
			for(int j=i;j<=i;j++)
			{
			   item=aa[i];
			  value=bb[j];
			  System.out.println("item "+item);
			  System.out.println("value "+value);
			  
			    PreparedStatement pst=null;
				Connection con=null;
				ResultSet rs=null;
				
				try
				{
					con=JDBCConnector.getConnection();
					pst=con.prepareStatement("select i_quantity from stock where i_name=? ");
					pst.setString(1, item);
					pst.execute();
					rs=pst.getResultSet();
					int s=0;
					while(rs.next())
					{
					   s=rs.getInt("i_quantity");
					}
					System.out.println("sssss "+s+"  "+item);
					pst=con.prepareStatement("update stock set i_quantity=? where i_name=? ");
					//System.out.println("Inside Model "+sb.getIquantity());
					pst.setInt(1, s-Integer.parseInt(value));
					pst.setString(2,item);
					pst.execute();
					//return Constant.success;
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Error updating stock table");
				}
			//return Constant.success;  
			  
			}
			
		}
		return Constant.success;
	}
	
	
	public String stockupdate(StockBean sb,String iname)
	{
	
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("update stock set i_quantity=? where i_name=? ");
				System.out.println("Inside Model "+sb.getIquantity());
				pst.setInt(1, sb.getIquantity());
				pst.setString(2, iname);
				pst.execute();
				return Constant.success;
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error updating stock table");
			}
		return Constant.success;
	}
	
	public String stockadd(StockBean sb)
	{
		String msg=sb.validateStock();
		if(msg.equals(Constant.success))
		{
			
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("select i_name from stock");
				pst.execute();
				rs=pst.getResultSet();
				String itembean=sb.getIname();
				while(rs.next())
				{
				   String item=rs.getString("i_name");
				   if(itembean.equals(item))
				   {
					   return "Item already available";   
				   }
				}
		    	
			 // return l;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while selecting company");
			}
			
			
			
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("insert into stock(i_name,i_descrip,i_quantity,i_price,c_name,i_ex_date,i_location)values(?,?,?,?,?,?,?)");
				pst.setString(1, sb.getIname());
				pst.setString(2, sb.getIdescrip());
				pst.setInt(3, sb.getIquantity());
				pst.setFloat(4, sb.getIprice());
				pst.setString(5, sb.getCname());
				pst.setString(6, sb.getIexdate());
				pst.setString(7, sb.getLocation());
				pst.execute();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in company table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		   } 
		return msg;
	}
	
	
	
	
	
	
	
	public String clientAdd(ClientBean cb)
	{
		String msg=cb.validateClient();
		if(msg.equals(Constant.success))
		{
			
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			
			/*try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("select i_name from stock");
				pst.execute();
				rs=pst.getResultSet();
				String itembean=sb.getIname();
				while(rs.next())
				{
				   String item=rs.getString("i_name");
				   if(itembean.equals(item))
				   {
					   return "Item already available";   
				   }
				}
		    	
			 // return l;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while selecting company");
			}*/
			
			
			
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("insert into client(cl_name,cl_surname,cl_mobile,cl_address,cl_city)values(?,?,?,?,?)");
				pst.setString(1, cb.getCl_name());
				pst.setString(2, cb.getCl_surname());
				pst.setString(3, cb.getCl_mobile());
				pst.setString(4, cb.getCl_address());
				pst.setString(5, cb.getCl_city());
				pst.execute();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in client table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		   } 
		return msg;
	}

	
	
	public ArrayList<String> clients()
	{
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet rs=null;
		ArrayList<String> l=new ArrayList<String>();
		try
		{
			con=JDBCConnector.getConnection();
			pst=con.prepareStatement("select cl_name from client");
			pst.execute();
			rs=pst.getResultSet();
			while(rs.next())
			{
			   l.add(rs.getString("cl_name"));
			}
	    	
		  return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error while selecting company");
		}
		finally
		{
	      try
	      {
	    	  JDBCConnector.close(pst);
	    	  JDBCConnector.close(con);
	      }
	      catch(Exception e)
	      {
	  		e.printStackTrace();
			System.out.println("Error while closing connection");    	
	      }
		}
		return l;
		
   	
	}
	
	
	
	
	public ArrayList<String> companies()
	{
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet rs=null;
		ArrayList<String> l=new ArrayList<String>();
		try
		{
			con=JDBCConnector.getConnection();
			pst=con.prepareStatement("select cname from company");
			pst.execute();
			rs=pst.getResultSet();
			while(rs.next())
			{
			   l.add(rs.getString("cname"));
			}
	    	
		  return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error while selecting company");
		}
		finally
		{
	      try
	      {
	    	  JDBCConnector.close(pst);
	    	  JDBCConnector.close(con);
	      }
	      catch(Exception e)
	      {
	  		e.printStackTrace();
			System.out.println("Error while closing connection");    	
	      }
		}
		return l;
		
   	
	}
	
	
	public ArrayList<StockBean> items()
	{
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet rs=null;
		ArrayList<StockBean> l=new ArrayList<StockBean>();
		
		try
		{
			con=JDBCConnector.getConnection();
			pst=con.prepareStatement("select i_name,i_quantity,i_price,i_location from stock");
			pst.execute();
			rs=pst.getResultSet();
			while(rs.next())
			{
				StockBean c=new StockBean();
				c.setIname(rs.getString("i_name"));
				c.setIquantity(rs.getInt("i_quantity"));
				c.setIprice(rs.getFloat("i_price"));
				c.setLocation(rs.getString("i_location"));
			    l.add(c);
			}
		
		  return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error while selecting company");
		}
		finally
		{
	      try
	      {
	    	  JDBCConnector.close(pst);
	    	  JDBCConnector.close(con);
	      }
	      catch(Exception e)
	      {
	  		e.printStackTrace();
			System.out.println("Error while closing connection");    	
	      }
		}
		return l;
   	
	}
	
	public ArrayList<StockBean> quntity()
	{
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			ArrayList<StockBean> companies=new ArrayList<StockBean>(); 
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Select I_QUANTITY from stock");
				pst.execute();
				rs=pst.getResultSet();
				while(rs.next())
				{
					StockBean c=new StockBean();
					c.setIquantity(rs.getInt("I_QUANTITY"));
				  // c.setCname(rs.getString("cname"));
				   companies.add(c);
				}
				return companies;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in company table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		return null;
	 
	}

	
	
	public String companyRemove(CompanyBean cb)
	{
			PreparedStatement pst=null;
			Connection con=null;
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Delete from company where cname=?");
				pst.setString(1, cb.getCname());
				pst.execute();
				con.commit();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while deleting company ");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			 
		return null;
	}
	
	
	
	public String clientRemove(ClientBean cb)
	{
			PreparedStatement pst=null;
			Connection con=null;
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Delete from client where cl_name=?");
				pst.setString(1, cb.getCl_name());
				System.out.println(cb.getCl_name());
				pst.execute();
				con.commit();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while deleting company ");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			 
		return null;
	}

	
	
	
	public String stockRemove(StockBean sb)
	{
			PreparedStatement pst=null;
			Connection con=null;
			
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Delete from stock where i_name=?");
				pst.setString(1, sb.getIname());
				pst.execute();
				con.commit();
				return Constant.success;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while deleting company ");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			 
		return null;
	}
	
	
	
	public ArrayList<CompanyBean> companyDisplay()
	{
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			ArrayList<CompanyBean> companies=new ArrayList<CompanyBean>(); 
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Select * from company");
				pst.execute();
				rs=pst.getResultSet();
				while(rs.next())
				{
				   CompanyBean c=new CompanyBean();
				   c.setCname(rs.getString("cname"));
				   c.setCperson(rs.getString("person"));
				   c.setAddress(rs.getString("address"));
				   c.setMobile(rs.getString("contact"));
				   companies.add(c);
				}
				return companies;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in company table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		return null;
	 
	}
	


	public ArrayList<ClientBean> clientDisplay()
	{
			PreparedStatement pst=null;
			Connection con=null;
			ResultSet rs=null;
			ArrayList<ClientBean> clients=new ArrayList<ClientBean>(); 
			try
			{
				con=JDBCConnector.getConnection();
				pst=con.prepareStatement("Select * from client");
				pst.execute();
				rs=pst.getResultSet();
				while(rs.next())
				{
					ClientBean cb=new ClientBean();
					cb.setCl_name(rs.getString("cl_name"));
				    cb.setCl_surname(rs.getString("cl_surname"));
				    cb.setCl_mobile(rs.getString("cl_mobile"));
				    cb.setCl_address(rs.getString("cl_address"));
				    cb.setCl_city(rs.getString("cl_city"));
				    clients.add(cb);
				}
				return clients;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error while inserting in company table");
			}
			finally
			{
		      try
		      {
		    	  JDBCConnector.close(pst);
		    	  JDBCConnector.close(con);
		      }
		      catch(Exception e)
		      {
		  		e.printStackTrace();
				System.out.println("Error while closing connection");    	
		      }
			}
			
		return null;
	 
	}
	
	
	

public ArrayList<StockBean> stockDisplay()
{
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet rs=null;
		ArrayList<StockBean> stock=new ArrayList<StockBean>(); 
		try
		{
			con=JDBCConnector.getConnection();
			pst=con.prepareStatement("Select * from stock");
			pst.execute();
			rs=pst.getResultSet();
			while(rs.next())
			{
			   StockBean s=new StockBean();
			   s.setCname(rs.getString("c_name"));
			   s.setIdescrip(rs.getString("i_descrip"));
			   s.setIexdate(rs.getString("i_ex_date"));
			   s.setIname(rs.getString("i_name"));
			   s.setIprice(rs.getFloat("i_price"));
			   s.setIquantity(rs.getInt("i_quantity"));
			   s.setLocation(rs.getString("i_location"));
			   stock.add(s);
			}
			return stock;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error while selecting from stock table");
		}
		finally
		{
	      try
	      {
	    	  JDBCConnector.close(pst);
	    	  JDBCConnector.close(con);
	      }
	      catch(Exception e)
	      {
	  		e.printStackTrace();
			System.out.println("Error while closing connection");    	
	      }
		}
		
	return null;
 
}

}