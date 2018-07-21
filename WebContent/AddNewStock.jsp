<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="nitin.project.Model" %>
    <%@ page import="java.util.ArrayList" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Stock</title>
</head>
<body>
<h3> ADD NEW STOCK</h3>
<form action="AddStockInt.jsp" method="post">
 <table width="400">
 
 <% Model m = new Model();
     ArrayList<String> s= m.companies();
   %>
  <tr>
    <td><lable>Item Name:</lable> </td>
    <td><input type="text" name="iname"  style=margin:5px; required/></td>
  </tr>
  <tr>
    <td><lable>Item Detail:</lable></td>
    <td><input type="text" name="idescrip"  style=margin:5px; required/></td>
  </tr>
  <tr>
    <td><lable>Item Price:</lable></td>
    <td><input type="text" name="iprice" style=margin:5px; required/></td>
  </tr>
  <tr>
    <td><lable>Quantity:</lable></td>
    <td><input type="text" name="iquantity" style=margin:5px; required/></td>
  </tr>
  
  <tr>
    <td><lable>Company Name:</lable></td>
    <td>
    <select name="cname" style=margin:5px;>

<%for(int i=0;i<s.size();i++){ %>

<option style=margin:40px;><%=s.get(i) %></option>

<%} %>
</select>
</td>

  </tr>
  
  <tr>
    <td><lable>Location:</lable></td>
    <td><input type="text" name="location" style=margin:5px; required/></td>
  </tr>
  
  <tr>
    <td><lable>Expiry Date</lable></td>
    <td><input type="date" name="iexdate" style=margin:5px; required/></td>
  </tr>
  
  
  <tr>
    <td><input type="submit" value="ADD STOCK" /></td>
   
  </tr>
</table>
 
</form>
<b>${insertMsg}</b>
<b>${errorMsg}</b>
</body></html>