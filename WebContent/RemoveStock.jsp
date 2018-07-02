<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="nitin.project.*" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REMOVE STOCK</title>
</head>
<body>
<h3>REMOVE STOCK</h3>
<form action="RemoveStockInt.jsp" method="post">
 <table width="400">
 
 <% Model m = new Model();
     ArrayList<StockBean> s= m.items();
     
     ArrayList<String> s1=new ArrayList<String>();
     for(int i=0;i<s.size();i++)
     {
    	 s1.add(i, s.get(i).getIname());
     }
   %>
   
  <tr>
    <td><lable>Item Name:</lable> </td>
    <td>
<select name="iname" >

<%for(int i=0;i<s1.size();i++){ %>

<option style=margin:35px;><%=s1.get(i) %></option>

<%} %>
</select>
</td> 
  </tr>

  <tr>
    <td><input type="submit" value="REMOVE STOCK" /></td>
   
  </tr>
</table>
 
</form>
<b>${delMsg}</b>
</body>
</html>