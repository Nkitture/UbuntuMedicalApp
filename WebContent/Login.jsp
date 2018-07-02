<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>This is Home Page</title>
<link rel="stylesheet" href="style.css">

</head>
<body>



  
  <form  action="LogInt.jsp" method="post">
 
      <label for="un"><b>Username</b></label>
      <input id="un" type="text" placeholder="Enter Username" name="email" required>

      <label for="ps"><b>Password</b></label>
      <input id="ps" type="password" placeholder="Enter Password" name="password" required>
        
      <button id="bt3" type="submit">Login</button>
      

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
  <b>${errorMsg}</b>


<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>
