<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="nitin.project.Model" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Client</title>
</head>
<body>
<h3> DELETE CLIENT</h3>
<form action="RemoveCliInt.jsp" method="post">
 <table width="400">
 

  <% Model m = new Model();
     ArrayList<String> s= m.clients();
   %>
  <tr>
  <td><lable>Client Name:</lable> </td>
  
<td>
<select name="cl_name" >

<%for(int i=0;i<s.size();i++){ %>

<option style=margin:35px;><%=s.get(i) %></option>

<%} %>
</select>
</td> 
</tr>

  <tr>
    <td><input align="middle" type="submit" value="DELETE CLIENT" /></td>
  </tr>
</table>
 
</form>
<b>${delMsg}</b>
</body>

</html>