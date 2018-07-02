<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="nitin.project.Model" %>
    <%@ page import="nitin.project.StockBean" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
/* function loadFrame (elm){
    var frame1 = document.getElementById('frame1');
    frame1.src = elm.dataset.src;
} */


</script>

<script src="js/jquery-3.2.1.js"> </script>
<script type="text/javascript"> 



var lenn,arrl;
$(document).ready(function(){   
    $('#itemid').change(function(){
    	document.getElementById('sellqty').focus();
        var $country=$("#itemid").val();
        $.ajax({  
            url:'Controller',  
            type:'post',  
            dataType: 'json', 
            success: function(data) { 
            	lenn=data.length;
            	//alert(lenn);
            	arrl=lenn/4;
            	 for (var x = 0; x <lenn; x++) {
            		 
            		if(data[x]==$country)
            		 {
            			//$('#iname').val(data[x]);
            			$('#cq').val(data[x+1]);
            			$('#cp').val(data[x+2]);
            			$('#loc').val(data[x+3]);
            		 }
            	 }
            }
        });  
    }); 
});





var tot=0;


var data1 = new Array(arrl);
var qtysell=new Array(arrl);
var priceA=new Array(arrl);
var totalA=new Array(arrl);
function addRow(tableID) {


		  var name=document.getElementById("itemid").value;
		  var price=document.getElementById("cp").value;
		  var cqty=document.getElementById("cq").value;
		  var sellqt= document.getElementById("sellqty").value;
		  
	      
		   tot=parseInt(tot)+parseInt(sellqt);
		  
		  
		  if(isNaN(sellqt) || sellqt%1!=0)
			{
			  alert("Please Enter Qty in Proper format");
			  return false;
			}
		    
		
		  if(parseInt(sellqt)>parseInt(cqty))
		     {
		    	alert("Please check Available Quantity");
		    	return false;
		     }

		  
		     for(var i =1; i < data1.length; i++) {
		    if(data1[i]==name)
		    	{
		    	  alert(data1[i] +" is Already "+"added");
		    	  return false;
		    	}
		     }  
		   
			var table = document.getElementById(tableID);

			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);

			var cell1 = row.insertCell(0);
			var element1 = document.createElement("input");
			element1.type = "checkbox";
			element1.name="chkbox[]";
			cell1.appendChild(element1);

			var cell2 = row.insertCell(1);
			var element2 = document.createElement("input");
			element2.id="elname";
			element2.name="elname";
			element2.readOnly=true;
			element2.type = "text";
			element2.value=name;
			
			for(var j = rowCount; j <= rowCount; j++) {
			    data1.push(element2.value);
			  
			}
			
		
			cell2.appendChild(element2);

			var cell3 = row.insertCell(2);
			var element3 = document.createElement("input");
			element3.type = "text";
			element3.readOnly=true;
			element3.value=price;
			
			for(var j = rowCount; j <= rowCount; j++) {
				priceA.push(element3.value);
			  
			}
			
			cell3.appendChild(element3);
			
			var cell4 = row.insertCell(3);
			var element4 = document.createElement("input");
			element4.type = "text";
			element4.value=sellqt;
			
			if(element4.value==null || element4.value=='')
				{
				  alert("Please enter value for Quantity");
				}
			  for(var i = rowCount; i <= rowCount; i++) {
			    qtysell.push(element4.value);
			   // alert("qtysell "+qtysell);
			}  
			   
            			  
			cell4.appendChild(element4);
			
			
			var cell5 = row.insertCell(4);
			var element5 = document.createElement("input");
			element5.type = "text";
			element5.readOnly=true;
			element5.value=sellqt*price;
			
			for(var j = rowCount; j <= rowCount; j++) {
				totalA.push(element5.value);
			  
			}
			
			cell5.appendChild(element5);
			
			
			
			element4.onchange=function(){
				element5.value="";
				
				 for(var i = rowCount; i <= rowCount; i++) {
				   qtysell[i]=element4.value;//replace value of qtysell   
				}
				 
				if(isNaN(element4.value) || element4.value%1!=0 || element4.value=='')
				{
				  alert("Please Enter Qty in Proper formatt");
				  return false;
				}
				if(parseInt(element4.value)>parseInt(cqty))
			     {
			    	alert("Please check Available Quantity");
			    	return false;
			     }

				element5.value=element4.value*price;
				
				for(var j = rowCount; j <= rowCount; j++) {
					totalA[j]=element5.value;
				  
				}
				//p.value = qtysell;
				
			}
			 
		   	  //n.value = data1;
		   	  
		      //p.value = qtysell;
			
		}
		

		function deleteRow(tableID) {
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			for(var i=1; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					
					if (i > -1) {
					    data1.splice(i, 1);
					}
					if (i > -1) {
						qtysell.splice(i, 1);
					}
				   //alert("delete"+ data1.pop(i));
				   //alert("delete value"+qtysell.pop(i));
				
					rowCount--;
					i--;
				}

			}
			}catch(e) {
				alert("Hi "+e);
			}
		}
		
		window.onclick= function()
		{
			var tqty=0;
			var tprice=0;
			var tableid= document.getElementById("dataTable");
			var rowCnt = tableid.rows.length;
			for(var i=1; i<rowCnt; i++) {
				var row = tableid.rows[i];
				tqty=tqty+ parseInt(row.cells[3].childNodes[0].value);
				tprice=tprice+ parseInt(row.cells[4].childNodes[0].value);				
			}
			document.getElementById("TotIms").value =tqty;
			document.getElementById("TotPrc").value =tprice;
		}

		function dataArray()
		{
			
			
			 var n = document.getElementById("arr");
			 var p = document.getElementById("qtsell");
			 var pri=document.getElementById("pricea");
			 
			 var tolpri=document.getElementById("totalpri");
			 
			 var custom=document.getElementById("custname").value;
			 var toti= document.getElementById("TotIms").value;
			 var totp= document.getElementById("TotPrc").value;
				
			
		//	   alert("dataArray() "+data1);
			   n.value=data1;
			
			//	alert("dataArray() sell "+qtysell);
				p.value=qtysell;
				
			//	alert("dataArray() price "+priceA);
				pri.value=priceA;
				
			//	alert("dataArray() price "+totalA);
				tolpri.value=totalA;
				
			//	alert("customer name "+custom);
			//	alert("total items "+toti);
			//	alert("total price "+totp);
				
		}
	

</script>

<title>Existing Client</title>
</head>
<body>
<h3> EXISTING CLIENT</h3>
<form action="get.jsp" method="POST">
<!-- <form action="RemoveCompInt.jsp" method="post"> -->
 <table width="600">
 
  <% Model m = new Model();
     ArrayList<String> s=m.clients();
     ArrayList<StockBean> s1=m.items();
     
   %>
   
  <tr>
  <td align="right">Select Customer Name: </td>
  
<td align="left">
<select id="custname" name="custname">

<%for(int i=0;i<s.size();i++){ %>

<option style=margin:2px;><%=s.get(i) %></option>

<%} %>
</select>
</td> 
</tr>

<tr>
<td align="right"><lable>Select Item:</lable> </td> 
<td>
<select name="iname" id="itemid">

<%for(int i=0;i<s1.size();i++){ %>

<option style=margin:2px;><%=s1.get(i).getIname() %></option>

<%} %>
</select>
</td> 
</tr>

  <tr>
  <td align="left"><lable>Quantity:</lable>
  <input type="text" id="cq" name="cqty" size="6"  style=margin:2px; readonly/>
  </td>
  
  <td align="left"><lable>Price:</lable>
  <input type="text" id="cp" name="cprc" size="6" style=margin:2px; readonly/>
  </td>
   
   <td align="left"><lable>Location:</lable> 
   <input type="text" id="loc" name="cloc" size="6" style=margin:2px; readonly/>
   </td>
   
   <td align="left"><lable>Sell Qty:</lable> 
   <input type="text" id="sellqty" name="sqty" size="6" style=margin:2px; onclick="addRow('dataTable')"/>
   </td>
   
  </tr>
  
</table>
 
<!--  </form> -->




<INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
 <TABLE id="dataTable" width="50px" border="1">

	<tr>
	</tr>
</TABLE>
	
<!-- <form action="RemoveCompInt.jsp" method="post"> -->

 <table width="400">
 <tr>
 
 <td>Total Items: </td>
 <td><input type="text" id="TotIms" name="TotIms" size="6"  name="Ims"  readonly/></td>
 <td> Total Price: </td>
 <td><input type="text" id="TotPrc" name="TotPrc" size="6" name="Prc"  readonly/></td>
 
 </tr>

 </table>
 
<!--   </form> -->
<!-- <iframe id="frame1" align="center" scrolling="yes" height="250" width="380"></iframe>
<button id="b1" data-src="SubmitOrder.jsp" onClick="loadFrame(this)">Submit</button> -->
<b>${delMsg}</b>





<input type="hidden" id="arr" name="arr" value=""/>
<input type="hidden" id="qtsell" name="qtsell" value=""/>
<input type="hidden" id="pricea" name="pricea" value=""/>
<input type="hidden" id="totalpri" name="totalpri" value=""/>

<input type="submit" value="submit Order" onclick="dataArray()"/>
</form>

   
</body>

</html>