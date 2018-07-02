<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> ADD NEW CLIENT</h3>
<form action="AddClientInt.jsp" method="post">
 <table width="400">
  <tr>
    <td><lable>Client Name:</lable> </td>
    <td><input type="text" name="cl_name" required style=margin:5px; /></td>
  </tr>
  <tr>
    <td><lable>Surname:</lable></td>
    <td><input type="text" name="cl_surname" required style=margin:5px;/></td>
  </tr>
  <tr>
    <td><lable>Mobile:</lable></td>
    <td><input type="text" name="cl_mobile" required style=margin:5px;/></td>
  </tr>
  <tr>
    <td><lable>Address:</lable></td>
    <td><input type="text" name="cl_address" required style=margin:5px;/></td>
  </tr>
  
  <tr>
    <td><lable>City:</lable></td>
    <td><input type="text" name="cl_city" required style=margin:5px;/></td>
  </tr>
 
  <tr>
    <td><input type="submit" value="ADD CLIENT" /></td>
   
  </tr>
</table>
 
</form>
<b>${insertMsg}</b>
<b>${errorMsg}</b>
</body></html>