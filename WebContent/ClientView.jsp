<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function loadFrame (elm){
    var frame1 = document.getElementById('frame1');
    frame1.src = elm.dataset.src;
}

</script>
<title>Client Page</title>
<link type="text/css" rel="stylesheet" href="style.css"/>
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
</head>


<body>

<b>Well Come ${user}</b>

   <div class="firstcontainer light">
     <div class="wrapper" id="top_div">
        <div id="top_right">
        ${user}
<!-- 		Email:xxxxxxxxxxxxxxxxxxx@gmail.com -->
		</div>
		<div id="top_left">
		Mobile no:91 1234567891
		</div>
		<div id="clear">
		</div>
     </div>
   </div>
   
   
   
   <div class="firstcontainer dark">
   <div class="wrapper">
   
    <div class="dropdown">
	<span class="dropbtn">STOCK</span>
	<div class="dropdown-content">
	<a href="StockView.jsp">New Stock</a>
    <a href="StockView.jsp">Update Stock</a>
    <a href="StockView.jsp">Delete Stock</a>
	<a href="StockView.jsp">View Stock</a>
	</div>
   </div>
   
    <div class="dropdown">
	<span class="dropbtn" >SELL</span>
	<div class="dropdown-content">
	<a href="SellView.jsp">Existing Client </a>
    <a href="SellView.jsp">New Client </a>
	</div>
   </div>
   
   <div class="dropdown">
	<span class="dropbtn">CLIENTS</span>
	<div class="dropdown-content">
	<a href="ClientView.jsp">Add New </a>
    <a href="ClientView.jsp">Delete</a>
    <a href="ClientView.jsp">View</a>
	</div>
   </div>
   
   <div class="dropdown">
	<span class="dropbtn">REPORTS</span>
	<div class="dropdown-content">
	<a href="#">Daily Report</a>
    <a href="#">Monthly Report</a>
    <a href="#">Yearly Report</a>
	</div>
   </div>
   
   <div class="dropdown">
	<span class="dropbtn">MANAGE USER</span>
	<div class="dropdown-content">
	<a href="#">Add New</a>
    <a href="#">Delete</a>
    <a href="#">Reports</a>
	<a href="#">Change Password</a>
	</div>
   </div>
   
   <div class="dropdown">
	<span class="dropbtn">COMPANY</span>
	<div class="dropdown-content">
	<a href="CompanyView.jsp">Add Company</a>
    <a href="CompanyView.jsp">Remove Company</a>
    <a href="CompanyView.jsp">Company List</a>
	</div>
   </div>
   <a href=" Login.jsp">Logout</a>
   </div>
   </div>
   
   <center>ADD/DELETE CLIENT DETAIL HERE !!</center>
   
    <button id="b1" data-src="AddClient.jsp" onClick="loadFrame(this)">ADD NEW CLIENT</button>
    <button id="b2" data-src="RemoveClient.jsp" onClick="loadFrame(this)">DELETE CLIENT</button>
    <button id="b3" data-src="ClientList.jsp" onClick="loadFrame(this)">CLIENT LIST</button>
    
    <iframe id="frame1" scrolling="yes" height="400" width="400"></iframe> 
    
</body>
</html>