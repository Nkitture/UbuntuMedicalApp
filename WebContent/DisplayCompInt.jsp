<jsp:useBean id="dispcomp" class="nitin.project.CompanyBean" scope="request">
<jsp:setProperty name="dispcomp" property="*" />
</jsp:useBean>
<jsp:forward page="dispcompany.do"></jsp:forward>