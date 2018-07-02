package nitin.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.json.JSONArray;
//import org.json.JSONException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out= response.getWriter();  
        JSONObject json = new JSONObject();
        JSONArray jsonarry = new JSONArray();
	 		ArrayList<StockBean> l=m.items();
	 		System.out.println(" l.size() "+l.size());
	 		for(int i=0;i<l.size();i++)
	 		{
	 			String name=l.get(i).getIname();
	 			int qty=l.get(i).getIquantity();
	 			float price=l.get(i).getIprice();
	 			String loc=l.get(i).getLocation();
	 			
	 		   jsonarry.add(name);
	 		   jsonarry.add(qty);
	 		   jsonarry.add(price);
	 		   jsonarry.add(loc);
	 		  
	 		}
	 		System.out.println("Json array "+jsonarry);
	 		
            response.setContentType("application/json");
            out.println(jsonarry);
           
		process(request, response);
	}
    RequestDispatcher rd=null;
    Model m=new Model();
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
     String uri=request.getRequestURI();
     System.out.println("Request Comes to "+uri);
     
     
  
     if(uri.contains("/login.do"))
     {
    	 LoginBean lb=(LoginBean)request.getAttribute("log");
    	 String msg=lb.validate();
    	 if(msg.equals(Constant.success))
    	 {
    		 HttpSession session=request.getSession(true);
    		 session.setAttribute("user", lb.getEmail());
    		 rd=request.getRequestDispatcher("Menu.jsp");
    		 rd.forward(request, response);
    	  
    	 }
    	 else 
    	 {
    		 request.setAttribute("errorMsg", msg);
    		 rd=request.getRequestDispatcher("Login.jsp");
    		 rd.forward(request, response);
    	 }
     }
     
	//code for inserting data in database
     
     if(uri.contains("/company.do"))
     {
    	 CompanyBean cb=(CompanyBean)request.getAttribute("comp");
    	 String msg=m.companyCheck(cb);
    	 String insmsg="";
    	 if(msg.equals(Constant.success))
    	 {
    		 request.setAttribute("insertMsg", insmsg);
    		 request.setAttribute("userData", cb);
    		 rd=request.getRequestDispatcher("AddCompany.jsp");
    		 rd.forward(request, response);
    	 }
    	 else 
    	 {
    		 request.setAttribute("errorMsg", msg);
    		 rd=request.getRequestDispatcher("AddCompany.jsp");
    		 rd.forward(request, response);
    	 }
     }
    
    

    	 if(uri.contains("/addnewstock.do"))
         {
    		 StockBean sb=(StockBean)request.getAttribute("stockbean");
        	 String msg=m.stockadd(sb);
        	 String insmsg="Stock inserted successfully";
        	 if(msg.equals(Constant.success))
        	 {
        		 
        		 request.setAttribute("insertMsg", insmsg);
        		 request.setAttribute("userData", sb);
        		 rd=request.getRequestDispatcher("AddNewStock.jsp");
        		 rd.forward(request, response);
        	 }
        	 else 
        	 {
        	
        		 request.setAttribute("errorMsg", msg);
        		 rd=request.getRequestDispatcher("AddNewStock.jsp");
        		 rd.forward(request, response);
        	 }
        	
          }
    	 
    	 
    	 if(uri.contains("/addclient.do"))
         {
    		 ClientBean cb=(ClientBean)request.getAttribute("clientbean");
        	 String msg=m.clientAdd(cb);
        	 String insmsg="client inserted successfully";
        	 if(msg.equals(Constant.success))
        	 {
        		 
        		 request.setAttribute("insertMsg", insmsg);
        	//	 request.setAttribute("userData", cb);
        		 rd=request.getRequestDispatcher("AddClient.jsp");
        		 rd.forward(request, response);
        	 }
        	 else 
        	 {
        	
        		 request.setAttribute("errorMsg", msg);
        		 rd=request.getRequestDispatcher("AddClient.jsp");
        		 rd.forward(request, response);
        	 }
        	
          }
    	 
    	 
    	 
    	 
    	 if(uri.contains("/updatestock.do"))
         {
    		 StockBean sb=(StockBean)request.getAttribute("stockbean");
    		 
    		 String iname=sb.getIname();
        	 String msg=m.stockupdate(sb,iname);
        	 String insmsg="Stock table updated successfully";
        	 if(msg.equals(Constant.success))
        	 {
        		 request.setAttribute("insertMsg", insmsg);
        		 request.setAttribute("userData", sb);
        		 rd=request.getRequestDispatcher("UpdateStock.jsp");
        		 rd.forward(request, response);
        	 }
        	 else 
        	 {
        		
        		 request.setAttribute("errorMsg", msg);
        		 rd=request.getRequestDispatcher("UpdateStock.jsp");
        		 rd.forward(request, response);
        	 }
        	
          }
    	 
    
     
   
     if(uri.contains("/selectiname.do"))
     {
    	
    	 rd=request.getRequestDispatcher("UpdateStock.jsp");
		 rd.forward(request, response);
    	 ArrayList<StockBean> al=m.quntity();
    	 
    	 if(al!=null)
    	 {
    		 request.setAttribute("updatelist", al);
    		 rd=request.getRequestDispatcher("UpdateStock.jsp");
    		 rd.forward(request, response);
    	 }
     }
     
     
    //extra different code for remove and display
    	 
    	 if(uri.contains("/companyremove.do"))
         {
        	 CompanyBean cb=(CompanyBean)request.getAttribute("rcomp");
        	 
        	 String msg=m.companyRemove(cb);
        	 String delmsg="Record deleted successfully";
        	 if(msg.equals(Constant.success))
        	 {
        		 request.setAttribute("delMsg", delmsg);
        		 rd=request.getRequestDispatcher("RemoveCompany.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }
    	 
    	 if(uri.contains("/clientremove.do"))
         {
    		 ClientBean clb=(ClientBean)request.getAttribute("rclie");
        	 
        	 String msg=m.clientRemove(clb);
        	 System.out.println("ddskhgaksd "+msg);
        	 String delmsg="Record deleted successfully";
        	 if(msg.equals(Constant.success))
        	 {
        		 request.setAttribute("delMsg", delmsg);
        		 rd=request.getRequestDispatcher("RemoveClient.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }
    	 
    	 
    	 
    	 
    	 if(uri.contains("/stockremove.do"))
         {
        	 StockBean sb=(StockBean)request.getAttribute("rstock");
        	 
        	 String msg=m.stockRemove(sb);
        	 String delmsg="Record deleted successfully";
        	
        	 if(msg.equals(Constant.success))
        	 {
        		 request.setAttribute("delMsg", delmsg);
        		 rd=request.getRequestDispatcher("RemoveStock.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }
    	 
         if(uri.contains("/dispcompany.do"))
         {
        	 ArrayList<CompanyBean> al=m.companyDisplay();
        	 
        	 if(al!=null)
        	 {
        		 request.setAttribute("complist", al);
        		
        		 rd=request.getRequestDispatcher("CompanyList.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }	 
         
         if(uri.contains("/dispclient.do"))
         {
        	 ArrayList<CompanyBean> al=m.companyDisplay();
        	 
        	 if(al!=null)
        	 {
        		 request.setAttribute("clientlist", al);
        		
        		 rd=request.getRequestDispatcher("ClientList.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }
         
    	 
         if(uri.contains("/dispstock.do"))
         {
        	 ArrayList<StockBean> al=m.stockDisplay();
        	 
        	 
        	 if(al!=null)
        	 {
        		 request.setAttribute("stocklist", al);
        		 
        		 rd=request.getRequestDispatcher("ViewStock.jsp");
        		 rd.forward(request, response);
        	 }
        	
         }	
     
        
       
        
	}

}
