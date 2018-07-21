<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page import="nitin.project.Model" %>
    <%@ page import="nitin.project.StockBean" %>
    <%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Stock</title>
</head>
<body>
<h3>View Stock</h3>
<form action="DisplayStockInt.jsp" method="post">
 <table width="600">
 <tr>
   <th align="left">Item Name</th>
   <th align="left">Details</th>
   <th align="left">Quantity</th>
   <th align="left">Price</th>
   <th align="left">Company</th>
   <th align="left">Expiry Date</th>
   <th align="left">Location</th>
 </tr>

   <% Model m = new Model();
     ArrayList<StockBean> s1= m.stockDisplay();
     
   %>
 

<%for(int i=0;i<s1.size();i++){ %>
<tr>
<td><%=s1.get(i).getIname() %></td>
<td><%=s1.get(i).getIdescrip() %></td>
<td><%=s1.get(i).getIquantity() %></td>
<td><%=s1.get(i).getIprice() %></td>
<td><%=s1.get(i).getCname() %></td>
<td><%=s1.get(i).getIexdate() %></td>
<td><%=s1.get(i).getLocation() %></td>

<%} %>

</tr> 
</table>
 
</form>
<b>${delMsg}</b>
</body>

</html>