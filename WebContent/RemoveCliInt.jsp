<jsp:useBean id="rclie" class="nitin.project.ClientBean" scope="request">
<jsp:setProperty name="rclie" property="*" />
</jsp:useBean>
<jsp:forward page="clientremove.do"></jsp:forward>