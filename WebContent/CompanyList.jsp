<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page import="nitin.project.Model" %>
    <%@ page import="nitin.project.CompanyBean" %>
    <%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>VIEW COMPANY LIST</h3>
<form action="DisplayCompInt.jsp" method="post">
 <table width="400">

   <% Model m = new Model();
     ArrayList<CompanyBean> s= m.companyDisplay();
   %>
  <tr>
  <th align="left">Company</th>
   <th align="left">Contact Name</th>
   <th align="left">Address</th>
   <th align="left">Mobile</th>
   
 </tr>
 

<%for(int i=0;i<s.size();i++){ %>
<tr>
<td><%=s.get(i).getCname() %></td>
<td><%=s.get(i).getCperson() %></td>
<td><%=s.get(i).getAddress() %></td>
<td><%=s.get(i).getMobile() %></td>
<%} %>

</tr> 
</table>
 
</form>
<b>${delMsg}</b>
</body>

</html>