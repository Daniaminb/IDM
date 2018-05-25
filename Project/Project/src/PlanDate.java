/**
 * date schedule
 * @author dannydani
 *
 */
public class PlanDate {
	String address;
	String file;
	int day;
	int mounth;
	int year;
	public PlanDate(String address,String file,int day,int mounth,int year)
	{
		this.address=address;
		this.file=file;
		this.day=day;
		this.mounth=mounth;
		this.year=year;
		
	}
	public String getAddress()
	{
		return address;
	}
	public String getFile()
	{
		return file;
	}
	public int getDay()
	{
		return day;
	}
	public int getMounth()
	{
		return mounth;
	}
	public int getYear()
	{
		return year;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setFile(String file)
	{
		this.file=file;
	}
	public void setDay(int day)
	{
		this.day=day;
	}
	public void setMounth(int mounth)
	{
		this.mounth=mounth;
	}
	public void getYear(int year)
	{
		this.year=year;
	}
}
