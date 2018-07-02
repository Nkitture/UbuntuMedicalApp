<jsp:useBean id="comp" class="nitin.project.CompanyBean" scope="request">
<jsp:setProperty name="comp" property="*" />
</jsp:useBean>
<jsp:forward page="company.do"></jsp:forward>