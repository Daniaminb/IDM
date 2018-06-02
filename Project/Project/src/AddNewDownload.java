import java.awt.Color;
import java.awt.Component; 
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

import javax.swing.JPanel;
/**
 * all download
 * @author paml
 *
 */

public class AddNewDownload extends JPanel {
	static ArrayList<DownloadMenu> array;
	static ArrayList<DownloadMenu> array2;
	static boolean persian=false;
	public AddNewDownload() {
		System.out.println(this.getSize());
		array=new ArrayList<>();
		array2=new ArrayList<>();
		this.setPreferredSize(new Dimension(6000, 700));
		//System.out.println(this.getBounds().height);
	}
	public static void adding(DownloadMenu download)
	{
		download.setPreferredSize(new Dimension(0, 100));
		//download.setMinimumSize(new Dimension(1650, 70));
		array.add(download);
	}
	public static void addToArray2(DownloadMenu download)
	{
		array2.add(download);
	}
	public void setting()
	{
		//System.out.println("size="+array.size());
		SpringLayout layout=new SpringLayout();
		Iterator<DownloadMenu> iterator=array.iterator();
		if (iterator.hasNext())
		{
			DownloadMenu m1=iterator.next();
			DownloadMenu m2;
			layout.putConstraint(SpringLayout.EAST, m1, 0, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.WEST, m1, 0, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, m1, 0, SpringLayout.NORTH, this);
			this.add(m1);
			while(iterator.hasNext())
			{
				m2=iterator.next();
				layout.putConstraint(SpringLayout.EAST, m2, 0, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.WEST, m2, 0, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, m2, 0, SpringLayout.SOUTH, m1);
				m1=m2;
				this.add(m2);
			}
		}
		this.setLayout(layout);
	}
	/**
	 * click a buutton
	 * @param num
	 */
	public static void click(int num)
	{
		System.out.println("num="+num);
		for(int i=0 ; i< array.size(); i++)
		{
			//System.out.println(i);
			if (i!=num)
			{
				//System.out.println("YES");
				array.get(i).setClick(false);
				array.get(i).setBackground(null);
			}
		}
		array.get(num).setClick(true);
		
	}
	/**
	 * all info to file
	 * @throws IOException
	 */
	public void toFile() throws IOException
	{
		File file=new File("list.jdm");
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
			Iterator<DownloadMenu> iterator=array.iterator();
			while(iterator.hasNext())
			{
				DownloadMenu dm=iterator.next();
				string=dm.getDownloadName();
				string=string+"\n";
				bw.write(string);
				string=dm.getTime();
				string=string+"\n";
				bw.write(string);
				string=dm.getVolumeOfFile();
				string=string+"\n";
				bw.write(string);
				string=dm.getURL();
				string=string+"\n";
				bw.write(string);
				string=dm.getFile();
				string=string+"\n";
				bw.write(string);
				string=dm.getVolumeOfDownloading();
				string=string+"\n";
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
		//System.out.println("Yes");
		
	}
	/**
	 * get info form file
	 */
	public  void getFile()
	{
		System.out.println("newwwwww");
		String firstLine="1";
		File file=new File("list.jdm");
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
				String gettingdownloadName=br.readLine();
				if (gettingdownloadName!=null)
				{
					String gettingTime=br.readLine();
					String gettingVolumeOfFile=br.readLine();
					DownloadMenu dl=new DownloadMenu(gettingdownloadName, gettingVolumeOfFile, gettingTime);
					firstLine=br.readLine();
					dl.setURL(firstLine);
					firstLine=br.readLine();
					dl.setFile(firstLine);
					firstLine=br.readLine();
					dl.setVolumeOfDownloading(firstLine);
					this.adding(dl);
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
			      this.setting();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
		
	}
	/**
	 * file of remove download
	 * @param i number of download
	 */
	public  void removeFile(int i)
	{
		File file=new File("removed.jdm");
		String string;
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			DownloadMenu dm=array.get(i);
			string=dm.getDownloadName();
			string=string+"\n";
			bw.write(string);
			string=dm.getURL();
			string=string+"\n";
			bw.write(string);
			System.out.println("iiiiiiiiii="+i);
			this.remove(array.get(i));
			this.revalidate();
			array.remove(i);
			System.out.println("remove file size"+array.size());
		}
		catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
			    	  
				 {
			    	  bw.close();
			    	  this.toFile();
			    	  this.setting();
				 }
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
		//System.out.println("Yes");
	}
	/**
	 * find sepcific download
	 * @throws IOException
	 */
	public void find() throws IOException
	{
		Iterator<DownloadMenu> iterator=array.iterator();
		int i=0;
		while(iterator.hasNext())
		{
			DownloadMenu dm=iterator.next();
			if (dm.getClick()==true)
			{
				removeFile(i);
				System.out.println("size="+array.size());
				System.out.println("finish+i"+i);
				for(int j=i; j<array.size() ; j++)
				{
					System.out.println("no"+j);
					array.get(j).setNumber();
					DownloadMenu.numberOfDownloads--;
				}
				break;
			}
			else
			{
				i++;
			}
		}
	}
	/**
	 * change look
	 */
	public void showRunTime()
	{
		this.revalidate();
		setting();
	}
	/**
	 * resume the download
	 */
	public static void resume() 
	{
		int kk=0;
		Iterator<DownloadMenu> iterator=array.iterator();
		while(iterator.hasNext())
		{
			DownloadMenu m=iterator.next();
			if (m.getClick()==true)
			{
				System.out.println(kk);
				m.setPausemood(false);
				//System.out.println(m.getPausemood()	);
				//System.out.println("Resuminggggg");
				break;
			}
			kk++;
		}
	}
	/**
	 * pause the download
	 * @throws InterruptedException
	 */
	public static void pause() throws InterruptedException
	{
		//System.out.println("pause");
		int kk=0;
		Iterator<DownloadMenu> iterator=array.iterator();
		while(iterator.hasNext())
		{
			DownloadMenu m=iterator.next();
			if (m.getClick()==true)
			{
				System.out.println(kk);
				m.setPausemood(true);
				break;
			}
			kk++;
		}
	}
	/**
	 * resume array2
	 */
	public static void resumeArray2()
	{
		if (array2.size()>=1)
		{
			System.out.println("yesssssssssssssssssssssssssssssssssssssssssssssssssssss");
			array2.get(0).setPausemood(false);
			System.out.println("asdfasdfdsafsadfsadfasdfsadfadsfsadfdsfhjoqeyigjfjgoflafjodwq");
			array2.remove(0);
		}
		else
		{
			System.out.println("Dont have any downloads");
		}
	}
	/**
	 * cancel download
	 */
	public static void cancel()
	{
		int kk=0;
		Iterator<DownloadMenu> iterator=array.iterator();
		while(iterator.hasNext())
		{
			DownloadMenu m=iterator.next();
			if (m.getClick()==true)
			{
				System.out.println(kk);
				m.setCancel(true);
				//System.out.println(m.getPausemood()	);
				//System.out.println("Resuminggggg");
				break;
			}
			kk++;
		}
	}
}
