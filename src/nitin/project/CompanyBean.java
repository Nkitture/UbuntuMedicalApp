package nitin.project;

public class CompanyBean {

	private String cname,address,cperson,mobile;
	

	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCperson() {
		return cperson;
	}
	public void setCperson(String cperson) {
		this.cperson = cperson;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((cperson == null) ? 0 : cperson.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		CompanyBean other = (CompanyBean) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (cperson == null) {
			if (other.cperson != null)
				return false;
		} else if (!cperson.equals(other.cperson))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}
	
	public String validateCompany()
	{
		String msg="";

		if(cname==null||cname.trim().equals(""))
		{
			msg=msg+"company name should not be blank\n";
		}
		if(address==null||address.trim().equals(""))
		{
			msg=msg+"company address should not be blank\n";
		}
		
		if(cperson==null||cperson.trim().equals(""))
		{
			msg=msg+"contact person should not be blank\n";
		}
		
		if(mobile==null||mobile.trim().equals(""))
		{
			msg=msg+"mobile should not be blank";
		}
		if(mobile.length()>10)
		{
			msg=msg+"mobile number cannot be more than 10 digit";
		}
		if(mobile.length()<10)
		{
			msg=msg+"mobile number cannot be less than 10 digit";
		}
		if(msg.equals(""))
		{
			msg=Constant.success;
		}
		return msg;
	}

	
	}
