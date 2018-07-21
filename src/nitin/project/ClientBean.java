package nitin.project;
//--------
public class ClientBean {

	private String cl_id ,cl_name,cl_surname,cl_mobile,cl_address,cl_city;

	public String getCl_id() {
		return cl_id;
	}

	public void setCl_id(String cl_id) {
		this.cl_id = cl_id;
	}

	public String getCl_name() {
		return cl_name;
	}

	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}

	public String getCl_surname() {
		return cl_surname;
	}

	public void setCl_surname(String cl_surname) {
		this.cl_surname = cl_surname;
	}

	public String getCl_mobile() {
		return cl_mobile;
	}

	public void setCl_mobile(String cl_mobile) {
		this.cl_mobile = cl_mobile;
	}

	public String getCl_address() {
		return cl_address;
	}

	public void setCl_address(String cl_address) {
		this.cl_address = cl_address;
	}

	public String getCl_city() {
		return cl_city;
	}

	public void setCl_city(String cl_city) {
		this.cl_city = cl_city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cl_address == null) ? 0 : cl_address.hashCode());
		result = prime * result + ((cl_city == null) ? 0 : cl_city.hashCode());
		result = prime * result + ((cl_id == null) ? 0 : cl_id.hashCode());
		result = prime * result + ((cl_mobile == null) ? 0 : cl_mobile.hashCode());
		result = prime * result + ((cl_name == null) ? 0 : cl_name.hashCode());
		result = prime * result + ((cl_surname == null) ? 0 : cl_surname.hashCode());
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
		ClientBean other = (ClientBean) obj;
		if (cl_address == null) {
			if (other.cl_address != null)
				return false;
		} else if (!cl_address.equals(other.cl_address))
			return false;
		if (cl_city == null) {
			if (other.cl_city != null)
				return false;
		} else if (!cl_city.equals(other.cl_city))
			return false;
		if (cl_id == null) {
			if (other.cl_id != null)
				return false;
		} else if (!cl_id.equals(other.cl_id))
			return false;
		if (cl_mobile == null) {
			if (other.cl_mobile != null)
				return false;
		} else if (!cl_mobile.equals(other.cl_mobile))
			return false;
		if (cl_name == null) {
			if (other.cl_name != null)
				return false;
		} else if (!cl_name.equals(other.cl_name))
			return false;
		if (cl_surname == null) {
			if (other.cl_surname != null)
				return false;
		} else if (!cl_surname.equals(other.cl_surname))
			return false;
		return true;
	}
	
	
	
	public String validateClient()
	{
		String msg="";

		if(cl_name==null||cl_name.trim().equals(""))
		{
			msg=msg+"client name should not be blank\n";
		}
		if(cl_surname==null||cl_surname.trim().equals(""))
		{
			msg=msg+"client surname should not be blank\n";
		}
		
		if(cl_mobile==null||cl_mobile.trim().equals(""))
		{
			msg=msg+"client mobile should not be blank\n";
		}
		
		if(cl_address==null||cl_address.trim().equals(""))
		{
			msg=msg+"client address should not be blank\n";
		}
		
		if(cl_city==null||cl_city.trim().equals(""))
		{
			msg=msg+"client city should not be blank\n";
		}
		
		if(msg.equals(""))
		{
			msg=Constant.success;
		}
		return msg;
	}
	
}
