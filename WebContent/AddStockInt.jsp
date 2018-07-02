<jsp:useBean id="stockbean" class="nitin.project.StockBean" scope="request">
<jsp:setProperty name="stockbean" property="*" />
</jsp:useBean>
<jsp:forward page="addnewstock.do"></jsp:forward>