import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * all information of schedule
 * @author danny dani
 *
 */
public class Plan {
	static ArrayList<PlanTime> arrayTime;
	static ArrayList<PlanDate> arrayDate;
	public Plan() {
		arrayTime=new ArrayList<>();
		arrayDate=new ArrayList<>();
	}
	public static void addTime(PlanTime a) throws IOException
	{
		arrayTime.add(a);
		System.out.println("hereeeeeeeee321");
		toFileTime();
	}
	public static void addDate(PlanDate a) throws IOException
	{
		arrayDate.add(a);
		System.out.println("hereeeeeeeee123");
		toFileDate();
	}
	public static void toFileDate() throws IOException
	{
		File file=new File("schedulDate.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			String string;
			int b;
			Iterator<PlanDate> iterator=arrayDate.iterator();
			System.out.println("hereeeeeeeee");
			while(iterator.hasNext())
			{
				PlanDate dm=iterator.next();
				string=dm.getAddress();
				string=string+"\n";
				bw.write(string);
				string=dm.getFile();
				string=string+"\n";
				bw.write(string);
				b=dm.getDay();
				string="\n";
				bw.write(b);
				bw.write(string);
				b=dm.getMounth();
				string="\n";
				bw.write(b);
				bw.write(string);
				b=dm.getYear();
				string="\n";
				bw.write(b);
				bw.write(string);
			}
		}
		catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
	}
	public  static void getFileDate()
	{
		System.out.println("newwwwww");
		String firstLine="1";
		File file=new File("schedulDate.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			do
			{
				String gettingAddress=br.readLine();
				if (gettingAddress!=null)
				{
					String gettingFile=br.readLine();
					int gettingDay=br.read();
					int gettingMounth=br.read();
					int gettingYear=br.read();
					PlanDate dl=new PlanDate(gettingAddress, gettingFile, gettingDay,gettingMounth,gettingYear);
					arrayDate.add(dl);
				}
				else
				{
					firstLine=null;
				}
			}while(firstLine!=null);
		}
		catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
		
	}
	public static void toFileTime() throws IOException
	{
		File file=new File("schedulTime.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			String string;
			int b;
			Iterator<PlanTime> iterator=arrayTime.iterator();
			while(iterator.hasNext())
			{
				PlanTime dm=iterator.next();
				string=dm.getAddress();
				string=string+"\n";
				bw.write(string);
				string=dm.getFile();
				string=string+"\n";
				bw.write(string);
				b=dm.getSec();
				string="\n";
				bw.write(b);
				bw.write(string);
				b=dm.getMin();
				string="\n";
				bw.write(b);
				bw.write(string);
				b=dm.getHour();
				string="\n";
				bw.write(b);
				bw.write(string);
			}
		}
		catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
	}
	public  static void getFileTime()
	{
		System.out.println("newwwwww");
		String firstLine="1";
		File file=new File("schedulTime.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			do
			{
				String gettingAddress=br.readLine();
				if (gettingAddress!=null)
				{
					String gettingFile=br.readLine();
					int gettingSec=br.read();
					int gettingMin=br.read();
					int gettingHour=br.read();
					PlanTime dl=new PlanTime(gettingAddress, gettingFile, gettingSec,gettingMin,gettingHour);
					arrayTime.add(dl);
				}
				else
				{
					firstLine=null;
				}
			}while(firstLine!=null);
		}
		catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
		
	}
}
