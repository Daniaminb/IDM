import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * schedule plan time
 * @author dannydani
 *
 */
public class PlanTime  {
	String address;
	String file;
	int sec;
	int min;
	int hour;
	public PlanTime(String address,String file,int sec,int min,int hour,AddNewDownload and)
	{

		Calendar rightNow = Calendar.getInstance();
		System.out.println(rightNow.get(Calendar.HOUR));
		System.out.println(rightNow.get(Calendar.MINUTE));
		System.out.println(rightNow.get(Calendar.SECOND));
		if (rightNow.get(Calendar.HOUR)>hour)
		{
			System.out.println("cant download");
		}
		else
		{this.address=address;
		this.file=file;
		this.sec=sec;
		this.min=min;
		this.hour=hour;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time=dateFormat.format(cal.getTime());
		DownloadMenu dm=new DownloadMenu(address, "0",time);
		dm.setURL(address);
		dm.setFile(file);
		System.out.println("heerrerere rwe googogogoogo");
		AddNewDownload.adding(dm);
		and.showRunTime();
		Thread t=new Thread(new Runnable() {
			@Override
			public void run() {	
				while(true)
				{
					Calendar rightNow = Calendar.getInstance();
					if (rightNow.get(Calendar.HOUR)==hour && (rightNow.get(Calendar.MINUTE))==min && (rightNow.get(Calendar.SECOND)==sec ))
					{
						new Thread(dm).start();
						break;
					}
					System.out.println("here");
				}		
				
			}
		});
		t.start();
		}
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
