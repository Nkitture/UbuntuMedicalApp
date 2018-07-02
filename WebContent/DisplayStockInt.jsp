<jsp:useBean id="dispstock" class="nitin.project.StockBean" scope="request">
<jsp:setProperty name="dispstock" property="*" />
</jsp:useBean>
<jsp:forward page="dispstock.do"></jsp:forward>