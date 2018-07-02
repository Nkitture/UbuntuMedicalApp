<jsp:useBean id="rcomp" class="nitin.project.CompanyBean" scope="request">
<jsp:setProperty name="rcomp" property="*" />
</jsp:useBean>
<jsp:forward page="companyremove.do"></jsp:forward>