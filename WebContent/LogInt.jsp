<jsp:useBean id="log" class="nitin.project.LoginBean" scope="request">
<jsp:setProperty name="log" property="*" />
</jsp:useBean>
<jsp:forward page="login.do"></jsp:forward>