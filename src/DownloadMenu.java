import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
/**
 * information of new download
 * @author paml
 *
 */
public class DownloadMenu extends JPanel {
	static int numberOfDownloads;
	int number;
	JLabel downloadName;
	boolean click;
	JTextField URL;
	JTextField file;
	JProgressBar downloading;
	String time;
	JLabel speedOfDownloading;
	JLabel volumeOfFile;
	JLabel volumeOfDownloading;
	JLabel percentOfDownloading;
	int adding;
	
	
	static Timer t;
	int i;
	public DownloadMenu(String downloadName,String volumeOfFile,String time)
	{
		adding=-1;
		numberOfDownloads++;
		number=numberOfDownloads;
		int dim=5;
		this.downloadName=new JLabel(downloadName);
		downloading=new JProgressBar(0, 100);
		this.volumeOfFile=new JLabel(volumeOfFile);
		volumeOfDownloading=new JLabel("0/");
		percentOfDownloading=new JLabel("0%");
				
		file=new JTextField();
		URL=new JTextField();
		
		this.time=time;
		
		this.add(this.downloadName);
		this.add(downloading);
		this.add(this.volumeOfFile);
		this.add(volumeOfDownloading);
		this.add(percentOfDownloading);
		
		downloading.setStringPainted(true);
		
		
		SpringLayout layout=new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, this.downloadName, dim , SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, downloading, dim , SpringLayout.SOUTH, this.downloadName);
		layout.putConstraint(SpringLayout.WEST, downloading, dim , SpringLayout.WEST, this);
		
		
		layout.putConstraint(SpringLayout.NORTH, percentOfDownloading, dim , SpringLayout.SOUTH, this.downloadName);
		layout.putConstraint(SpringLayout.EAST, percentOfDownloading, -dim , SpringLayout.EAST, this);
	
		layout.putConstraint(SpringLayout.EAST, downloading, -dim , SpringLayout.WEST, percentOfDownloading);
		
		layout.putConstraint(SpringLayout.NORTH, this.volumeOfFile , dim , SpringLayout.SOUTH, downloading );
		layout.putConstraint(SpringLayout.EAST, this.volumeOfFile , -dim , SpringLayout.EAST,this );
		
		layout.putConstraint(SpringLayout.NORTH, volumeOfDownloading , dim , SpringLayout.SOUTH, downloading );
		layout.putConstraint(SpringLayout.EAST, volumeOfDownloading , -1 , SpringLayout.WEST,this.volumeOfFile );
		
		t=new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i==100)
				{
					System.out.println("Yes");
					t.stop();
				}
				else
				{
					i++;
					downloading.setValue(i);
					show();
				}
			}
		});
		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				
			}
			public void mousePressed(MouseEvent arg0) {
				setBackground(Color.blue);
				AddNewDownload.click(number);
				
			}
			public void mouseExited(MouseEvent arg0) {
				
			}
			public void mouseEntered(MouseEvent arg0) {
				
			}
			public void mouseClicked(MouseEvent arg0) {
	
				
			}
		});
		
		
		this.downloadName.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			public void mousePressed(MouseEvent arg0) {
				setBackground(Color.green);
				
			}
			public void mouseExited(MouseEvent arg0) {
				setBackground(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getButton() == MouseEvent.BUTTON3) {
		            System.out.println("yes");
		          }
				if(arg0.getButton() == MouseEvent.BUTTON1) {
					ShowInformation inf1=new ShowInformation(URL.getText(), file.getText(),time,"100","100","100");
					inf1.show();
					System.out.println(URL.getText());
		          }
				
			}
		});
		this.setLayout(layout);
	}
	public  void downloads()
	{
		t.start();
	}
	public void show()
	{
		percentOfDownloading.setText(String.valueOf(downloading.getValue())+"%");
	}
	public void setURL(String dic)
	{
		URL.setText(dic);
	}
	public void setFile(String dic)
	{
		file.setText(dic);
	}
	public void setClick(boolean a)
	{
		click=a;
	}
	public boolean getClick()
	{
		return click;
	}
	public String getDownloadName()
	{
		return downloadName.getText();
	}
	public String getURL()
	{
		return URL.getText();
	}
	public String getFile()
	{
		return file.getText();
	}
	public String getVolumeOfFile()
	{
		return  volumeOfFile.getText();
	}
	public String getVolumeOfDownloading()
	{
		return  volumeOfDownloading.getText();
	}
	public String getTime()
	{
		return time;
	}
	public void setVolumeOfDownloading(String volume)
	{
		volumeOfDownloading.setText(volume);
	}
	public void setNumber()
	{
		number--;
	}
	public int getNumber()
	{
		return number;
	}
	public void settingNumber(int n)
	{
		number=n;
	}

}
