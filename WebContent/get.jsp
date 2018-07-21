<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="nitin.project.Model" %>
    <%@ page import="nitin.project.StockBean" %>
    <script type="text/javascript">
   // alert("");
    </script>
<%
String val = request.getParameter("arr");
String sellqty = request.getParameter("qtsell");
String customer=request.getParameter("custname");
String totalitem=request.getParameter("TotIms");
String totalprice=request.getParameter("TotPrc");

String pri=request.getParameter("pricea");
String tolpri=request.getParameter("totalpri");

String aa[]=val.split(",");
String bb[]=sellqty.split(",");

String priArr[]=pri.split(",");

String tolpriArr[]=tolpri.split(",");

Model m = new Model();

String message= m.updateTable(aa,bb);


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<center><b> ORDER DETAILS</b> </center>
<br>
<center> Customer Name: <%=customer %> </center>
<br>
<!-- <B align="center">Total Order</B> -->
<table width="400" align="center">

 <tr>
  <td align="left">Item Name</td>
  <td align="left">Item Qty</td>
  <td align="left">Item Price</td> 
   <td align="left">Total</td>
 </tr>
 
 
 
<% for(int i=1;i<aa.length;i++)
  {%>
    <tr>
    <td>
     <%=aa[i] %>	
 </td>

<% for(int j=i;j<=i;j++)
   {%>
   <td>
     <%=bb[j]%>	
<% 
  }
 %>
 
 <% for(int k=i;k<=i;k++)
   {%>
   <td>
     <%=priArr[k]%>
     </td>
<% 
  }
 %>
 
 <% for(int l=i;l<=i;l++)
   {%>
   <td>
     <%=tolpriArr[l]%>
     </td>
<% 
  }
 %>
 
 <% 
  }
 %>
 </td>
 </tr> 

</table>
</br>
</br>
<center>
Total Items: <%=totalitem%>
&nbsp;&nbsp;Total Price: <%=totalprice%>
</br>
</br>
</br>
<input type="submit" value="Print"/>
</center>
</body>
</html>