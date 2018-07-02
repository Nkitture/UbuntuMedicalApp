<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="nitin.project.Model" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="nitin.project.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX calls to Servlet using JQuery and JSON</title>
<script src="js/jquery-3.2.1.js"> </script>
<script type="text/javascript"> 
$(document).ready(function(){   
    $('#itemid').change(function(){
        var $country=$("#itemid").val();
        $.ajax({  
            url:'Controller',  
            type:'post',  
            dataType: 'json', 
            success: function(data) { 
            	console.log(data);
            //	$.each(data,function(k,v)
            	//{
            		//alert(data[1]);
            	//	if(k==$country)
            		//	{	 
            	 for (var x = 0; x < data.length; x++) {
            		if(data[x]==$country)
            		 {
            			$('#cq').val(data[x+1]);
            		 }
            	 }
            }
        });  
    });  
});
</script>
</head>
<body>
<h3>UPDATE STOCK</h3>
<form action="UpdateStockInt.jsp" method="post">
 <table width="400">
 
 <% Model m = new Model();
     ArrayList<StockBean> s= m.items();
   %>
  <tr>
    <td><lable>Item Name:</lable> </td>
     <td><select id="itemid" name="iname">

<%for(int i=0;i<s.size();i++){ %>

<option style=margin:35px;><%=s.get(i).getIname() %></option>

<%} %>
</select>
</td>

  </tr>
  
  <tr>
  <td><lable>Current Qty:</lable></td>
   
  <td><input type="text" id="cq" name="cqty"  style=margin:5px;/></td>
     
  </tr>
  <tr>
    <td><lable>Quentity:</lable></td>
    <td><input type="text" id="iquantity" name="iquantity" required style=margin:5px;/></td>
  </tr>
  <tr>

  
  <tr>
    <td><input type="submit" value="UPDATE STOCK" /></td>
   
  </tr>
</table>
 
</form>
<b>${insertMsg}</b>
<b>${errorMsg}</b>
</body>
</html>