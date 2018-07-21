<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page import="nitin.project.Model" %>
    <%@ page import="nitin.project.ClientBean" %>
    <%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>
</head>
<body>
<h3>VIEW CLIENT LIST</h3>
<form action="DisplayCliInt.jsp" method="post">
 <table width="400">

   <% Model m = new Model();
     ArrayList<ClientBean> s= m.clientDisplay();
   %>
  <tr>
  <th align="left">FirstName</th>
   <th align="left">LastName</th>
   <th align="left">Mobile</th>
   <th align="left">Address</th>
   <th align="left">City</th>
   
 </tr>

<%for(int i=0;i<s.size();i++){ %>
<tr>
<td><%=s.get(i).getCl_name() %></td>
<td><%=s.get(i).getCl_surname() %></td>
<td><%=s.get(i).getCl_mobile() %></td>
<td><%=s.get(i).getCl_address() %></td>
<td><%=s.get(i).getCl_city() %></td>
<%} %>

</tr> 
</table>
 
</form>
<b>${delMsg}</b>
</body>

</html>