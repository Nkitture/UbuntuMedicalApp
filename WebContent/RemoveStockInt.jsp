<jsp:useBean id="rstock" class="nitin.project.StockBean" scope="request">
<jsp:setProperty name="rstock" property="*" />
</jsp:useBean>
<jsp:forward page="stockremove.do"></jsp:forward>