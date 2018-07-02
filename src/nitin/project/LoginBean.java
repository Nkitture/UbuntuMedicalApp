package nitin.project;

public class LoginBean {
	
	private String email,password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public String validate()
	{
		String msg="";
		/*if(email==""||email.trim().equals(""))
		{
			msg=msg+"email should not be blank";
		}
		if(password==""||password.trim().equals(""))
		{
			msg=msg+"password should not be blank";
		}
		if(msg!="" && email.equals("xyz@gmail.com") && password.equals("xyz") )
		{
			msg= Constant.success;
		}*/
		if(email.equals("xyz@gmail.com") && password.equals("xyz"))
		{
			msg= Constant.success;
		}
		else
		{
			msg="Wrong user name and password";
		}
		return msg;
	}
	

}
