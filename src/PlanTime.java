
public class PlanTime {
	String address;
	String file;
	int sec;
	int min;
	int hour;
	public PlanTime(String address,String file,int sec,int min,int hour)
	{
		this.address=address;
		this.file=file;
		this.sec=sec;
		this.min=min;
		this.hour=hour;
	}
	public String getAddress()
	{
		return address;
	}
	public String getFile()
	{
		return file;
	}
	public int getSec()
	{
		return sec;
	}
	public int getMin()
	{
		return min;
	}
	public int getHour()
	{
		return hour;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setFile(String file)
	{
		this.file=file;
	}
	public void setSec(int sec)
	{
		this.sec=sec;
	}
	public void setMin(int min)
	{
		this.min=min;
	}
	public void setHour(int hour)
	{
		this.hour=hour;
	}
}
