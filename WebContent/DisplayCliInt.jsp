<jsp:useBean id="dispcli" class="nitin.project.ClientBean" scope="request">
<jsp:setProperty name="dispcli" property="*" />
</jsp:useBean>
<jsp:forward page="dispclient.do"></jsp:forward>