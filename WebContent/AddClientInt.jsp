<jsp:useBean id="clientbean" class="nitin.project.ClientBean" scope="request">
<jsp:setProperty name="clientbean" property="*" />
</jsp:useBean>
<jsp:forward page="addclient.do"></jsp:forward>