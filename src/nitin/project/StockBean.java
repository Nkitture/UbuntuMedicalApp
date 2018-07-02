package nitin.project;

public class StockBean {

	private String iname,idescrip,cname,iexdate,location;
	private float iprice;
	private int iquantity;
	
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIdescrip() {
		return idescrip;
	}
	public void setIdescrip(String idescrip) {
		this.idescrip = idescrip;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIexdate() {
		return iexdate;
	}
	public void setIexdate(String iexdate) {
		this.iexdate = iexdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getIprice() {
		return iprice;
	}
	public void setIprice(float iprice) {
		this.iprice = iprice;
	}
	public int getIquantity() {
		return iquantity;
	}
	public void setIquantity(int iquantity) {
		this.iquantity = iquantity;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((idescrip == null) ? 0 : idescrip.hashCode());
		result = prime * result + ((iexdate == null) ? 0 : iexdate.hashCode());
		result = prime * result + ((iname == null) ? 0 : iname.hashCode());
		result = prime * result + Float.floatToIntBits(iprice);
		result = prime * result + iquantity;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		StockBean other = (StockBean) obj;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (idescrip == null) {
			if (other.idescrip != null)
				return false;
		} else if (!idescrip.equals(other.idescrip))
			return false;
		if (iexdate == null) {
			if (other.iexdate != null)
				return false;
		} else if (!iexdate.equals(other.iexdate))
			return false;
		if (iname == null) {
			if (other.iname != null)
				return false;
		} else if (!iname.equals(other.iname))
			return false;
		if (Float.floatToIntBits(iprice) != Float.floatToIntBits(other.iprice))
			return false;
		if (iquantity != other.iquantity)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
	
	public String validateStock()
	{
		String msg="";

		if(iname==null||iname.trim().equals(""))
		{
			msg=msg+"item name should not be blank\n";
		}
		if(idescrip==null||idescrip.trim().equals(""))
		{
			msg=msg+"item description should not be blank\n";
		}
		
		if(location==null||location.trim().equals(""))
		{
			msg=msg+"contact person should not be blank\n";
		}
		
		/*if (iexdate==null||iexdate.trim().equals(""))
			 msg=msg+"Date of birth should not null..!"+"<br/>";
		 else
		   if (!iexdate.matches("\\d{4}-\\d{2}-\\d{2}"))  
			   msg=msg+"please enter date in (yyyy-mm-dd) format..!"+"<br/>";
*/
		
		if(msg.equals(""))
		{
			msg=Constant.success;
		}
		return msg;
	}

	
}
