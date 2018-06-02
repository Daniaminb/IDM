import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileSystemView;

import java.net.HttpURLConnection;
import java.net.URL;
/**
 * information of new download
 * @author paml
 *
 */
public class DownloadMenu extends JPanel implements Runnable {
	//limited download
	static int lmd;
	static int numberOfDownloads;
	int cc;
	int number;
	static int length;
	JLabel downloadName;
	boolean click;
	JTextField link;
	JTextField file;
	JProgressBar downloading;
	String time;
	JLabel speedOfDownloading;
	JLabel volumeOfFile;
	JLabel volumeOfDownloading;
	JLabel percentOfDownloading;
	JLabel pic;
	Double pd=0.0;
	Double pp=new Double(0.0);
	
	
	int adding;
	boolean pausemood=false;
	boolean cancle=false;
	
	int i;
	/**
	 * constructor of download menut
	 * @param downloadName2 download name
	 * @param volumeOfFile volume of file
	 * @param time time of download
	 */
	public DownloadMenu(String downloadName2,String volumeOfFile,String time)
	{
		adding=-1;
		numberOfDownloads++;
		number=numberOfDownloads;
		int dim=5;
		this.downloadName=new JLabel(downloadName2);
		downloading=new JProgressBar(0, 100);
		this.volumeOfFile=new JLabel(volumeOfFile);
		volumeOfDownloading=new JLabel("0/");
		percentOfDownloading=new JLabel("0%");
		pic=new JLabel();
		ImageIcon i=new ImageIcon("if_icon-6-smiling-face_314591.png");
		pic.setIcon(i);
		speedOfDownloading=new JLabel("0");
				
		file=new JTextField();
		link=new JTextField();
		
		this.time=time;
		this.add(this.downloadName);
		this.add(downloading);
		this.add(this.volumeOfFile);
		this.add(volumeOfDownloading);
		this.add(percentOfDownloading);
		this.add(pic);
		pic.setBackground(Color.YELLOW);
		
		
		downloading.setStringPainted(true);
		
		
		SpringLayout layout=new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, this.downloadName, 25 , SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.downloadName, 5 , SpringLayout.EAST, pic);
		
		
		layout.putConstraint(SpringLayout.WEST, pic, 0 , SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, pic, 0 , SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, pic, 0 , SpringLayout.SOUTH, this);
		pic.setPreferredSize(new Dimension(60, 0));
		
		
		layout.putConstraint(SpringLayout.NORTH, downloading, dim , SpringLayout.SOUTH, this.downloadName);
		layout.putConstraint(SpringLayout.WEST, downloading, 5 , SpringLayout.EAST,pic);
		
		
		layout.putConstraint(SpringLayout.NORTH, percentOfDownloading, dim , SpringLayout.SOUTH, this.downloadName);
		layout.putConstraint(SpringLayout.EAST, percentOfDownloading, -dim , SpringLayout.EAST, this);
	
		layout.putConstraint(SpringLayout.EAST, downloading, -dim , SpringLayout.WEST, percentOfDownloading);
		
		
		layout.putConstraint(SpringLayout.NORTH, this.volumeOfFile , dim , SpringLayout.SOUTH, downloading );
		layout.putConstraint(SpringLayout.EAST, this.volumeOfFile , -dim , SpringLayout.EAST,this );
		
		layout.putConstraint(SpringLayout.NORTH, volumeOfDownloading , dim , SpringLayout.SOUTH, downloading );
		layout.putConstraint(SpringLayout.EAST, volumeOfDownloading , -1 , SpringLayout.WEST,this.volumeOfFile );
		
		
		
		/**
		 * action listener for the panel
		 */
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
		
		/**
		 * actrion listener for downlaod name
		 */
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
			/**
			 * mouseclicked of this
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getButton() == MouseEvent.BUTTON3) {
		            System.out.println("yes");
		            Desktop d = Desktop.getDesktop(); 
		            File f = new File(file.getText()+"//"+downloadName.getText()); 
		            System.out.println(file.getText());
		            System.out.println(file.getText()+"//"+downloadName.getText());
		            try {
						d.open(f);
					} catch (IOException e) {
						e.printStackTrace();
					}   
		          }
				if(arg0.getButton() == MouseEvent.BUTTON1) {
					ShowInformation inf1=new ShowInformation(link.getText(), file.getText(),time,"100","100","100");
					inf1.show();
					System.out.println(link.getText());
					System.out.println("asdasdasd");
		          }
				
			}
		});
		this.setLayout(layout);
	}
	/**
	 * set url
	 * @param dic directory
	 */
	public void setURL(String dic)
	{
		link.setText(dic);
	}
	/**
	 * set File
	 * @param file
	 */
	public void setFile(String dic)
	{
		file.setText(dic);
	}
	/**
	 * set click
	 * @param a mood of click
	 */
	public void setClick(boolean a)
	{
		click=a;
	}
	/**
	 * get mood of click
	 * @return mood of click
	 */
	public boolean getClick()
	{
		return click;
	}
	/**
	 * get DownloadName
	 * @return
	 */
	public String getDownloadName()
	{
		return downloadName.getText();
	}
	/**
	 * get Url
	 * @return
	 */
	public String getURL()
	{
		return link.getText();
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
	public  void setPausemood(boolean a)
	{
		pausemood=a;
	}
	public boolean getPausemood()
	{
		return pausemood;
	}
	public int getPercent()
	{
		return downloading.getValue();
	}
	public void setCancel(boolean a)
	{
		cancle=a;
	}
	public  synchronized void run()  {
		System.out.println("herhehrhehrere");
		SwingWorker<Void, Void> worker=new SwingWorker<Void,Void>()
		{
			@Override
			protected Void doInBackground() throws Exception {
				try {
					URL url=new URL(null,link.getText());
					String kk=link.getText();
					int size=kk.length();
					size--;
					while(kk.charAt(size)!='/')
					{
						size--;	
					}
					kk=kk.substring(size+1, kk.length());
					downloadName.setText(kk);
					File f=new File(file.getText()+"//"+downloadName.getText());
					
					
					File f1=new File(file.getText()+"//"+downloadName.getText());
					File f2=new File(file.getText()+"//"+downloadName.getText()+"2");
					
					
					
					HttpURLConnection http=(HttpURLConnection)url.openConnection();
					HttpURLConnection http2=(HttpURLConnection)url.openConnection();
					HttpURLConnection http3=(HttpURLConnection)url.openConnection();
					
					
					http2.getResponseCode();
					int p = http2.getContentLength();
					length=p;
					System.out.println(length);
					if (p%2!=0)
					{
						p--;
						System.out.println("سلام");
						System.out.println("p/2="+p/2);
					}
					http2.disconnect();
					http.setRequestProperty("Range", "bytes=" +0 + "-");
					http3.setRequestProperty("Range", "bytes=" + (p-p/2)+ "-");
					http.getResponseCode();
					http3.getResponseCode();
					System.out.println("Response message: " + http.getResponseMessage());
		            System.out.println("Follow redirects: " + HttpURLConnection.getFollowRedirects());
		            System.out.println("Content length: " + http.getContentLength());
		            System.out.println("Content type: " + http.getContentType());
		            //System.out.println(http.getContentLength());
					volumeOfFile.setText("/"+p);
					Thread t = new Thread(new Runnable() {
				         @Override
				         public void run() {
				        	 BufferedInputStream in = null;
							try {
								in = new BufferedInputStream(http.getInputStream());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(f1);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								BufferedOutputStream bout=new BufferedOutputStream(fos,1024);
								byte[] buffer=new byte[1024];
								int read=0;
								try {
									read=in.read(buffer,0,1024);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								if (read>=0)
								{
									lmd++;
								}
								while (read>= 0)
								{
									while(pausemood==true)
									{
										if(number==0)
										{System.out.println(pausemood);}
										continue;
									}
									if (cancle==true)
									{
										f1.delete();
										downloading.setValue(0);
										volumeOfDownloading.setText("0");
										volumeOfFile.setText("0");
										return;
									}
									try {
										bout.write(buffer,0,read);
									} catch (IOException e) {
										e.printStackTrace();
									}
									pp+=read;
									volumeOfDownloading.setText(pp+"");
									pd=(pp*100)/(DownloadMenu.length);
									downloading.setValue(pd.intValue());
									percentOfDownloading.setText(pd.intValue()+"%");
									//System.out.println("Downloading");
									//long timetime=System.nanoTime();
									try {
										read=in.read(buffer,0,1024);
										//long timetime2=System.nanoTime();
										//long time3time=timetime2-timetime;
										//time3time=time3time/1000;
										//System.out.println((double)read/(time3time));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									}
								try {
									bout.close();
									bout.flush();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								try {
									in.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				         }
					});
					t.start();
					Thread t2 = new Thread(new Runnable() {
				         @Override
				         public void run() {
				        	 BufferedInputStream in = null;
							try {
								in = new BufferedInputStream(http3.getInputStream());
							} catch (IOException e) {
								e.printStackTrace();
							}
								FileOutputStream fos = null;
								try {
									fos = new FileOutputStream(f2);
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								BufferedOutputStream bout=new BufferedOutputStream(fos,1024);
								byte[] buffer=new byte[1024];
								int read=0;
								try {
									read=in.read(buffer,0,1024);
								} catch (IOException e) {
									e.printStackTrace();
								}
								while (read>= 0)
								{
									while(pausemood==true)
									{
										if(number==0)
										{System.out.println(pausemood);}
										continue;
									}
									try {
										bout.write(buffer,0,read);
									} catch (IOException e) {
										e.printStackTrace();
									}
									pp+=read;
									volumeOfDownloading.setText(pp+"");
									pd=(pp*100)/(DownloadMenu.length);
									downloading.setValue(pd.intValue());
									percentOfDownloading.setText(pd.intValue()+"%");
									//System.out.println("Downloading");
									try {
										read=in.read(buffer,0,1024);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								try {
									bout.close();
									bout.flush();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								try {
									in.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				         }
					});
					//t2.start();
					while(downloading.getValue()!=100)
					{
						//System.out.println("Downloading");
					}
					
					IOCopier.joinFiles(f, new File[] {
				                f1, f2 });
					lmd--;
					kk=link.getText();
					size=kk.length();
					System.out.println(kk);
					size--;
					while(kk.charAt(size)!='.')
					{
						size--;	
					}
					kk=kk.substring(size+1, kk.length());
					//System.out.println(kk);
					if (kk.equals("mp3"))
					{
						ImageIcon i=new ImageIcon("if_icon-71-document-file-mp3_315868.png");
						pic.setIcon(i);
					}
					if (kk.equals("mp4"))
					{
						ImageIcon i=new ImageIcon("if_icon-72-document-file-mp4_315869.png");
						pic.setIcon(i);
					}
					if (kk.equals("exe"))
					{
						ImageIcon i=new ImageIcon("if_icon-105-document-file-exe_315590.png");
						pic.setIcon(i);
					}
					if (kk.equals("gif"))
					{
						ImageIcon i=new ImageIcon("if_icon-130-document-file-gif_314203.png");
						pic.setIcon(i);
					}
					if (kk.equals("pdf"))
					{
						ImageIcon i=new ImageIcon("if_icon-70-document-file-pdf_315274.png");
						pic.setIcon(i);
					}
					if (kk.equals("mpg"))
					{
						ImageIcon i=new ImageIcon("if_icon-117-document-file-mpg_315602.png");
						pic.setIcon(i);
					}
					if (kk.equals("doc"))
					{
						ImageIcon i=new ImageIcon("if_icon-94-document-file-doc_314536.png");
						pic.setIcon(i);
					}
					if (kk.equals("java"))
					{
						ImageIcon i=new ImageIcon("if_icon-78-document-file-java_315875.png");
						pic.setIcon(i);
					}
					if (kk.equals("png"))
					{
						ImageIcon i=new ImageIcon("if_icon-69-document-file-png_315149.png");
						pic.setIcon(i);
					}
					if (kk.equals("docx"))
					{
						ImageIcon i=new ImageIcon("if_icon-97-document-file-docx_314538.png");
						pic.setIcon(i);
					}
					if (kk.equals("zip"))
					{
						ImageIcon i=new ImageIcon("if_icon-124-document-file-zip_315084.png");
						pic.setIcon(i);
					}
					if (kk.equals("mkv"))
					{
						ImageIcon i=new ImageIcon("if_icon-66-document-play_315190.png");
						pic.setIcon(i);
					}
					System.out.println("FINISH");
					//System.out.println(lmd);
				
				}
				catch(IOException ex)
				{
					System.out.println("not connected");
				}
				if (lmd<LimitedDownloads.limitedDownload)
				{
					System.out.println("hererser2wdfsdfweqweasdasdasdasd");
					AddNewDownload.resumeArray2();
				}
				return null;
			}
		};
		worker.execute();
	}
}
