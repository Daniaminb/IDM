import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
/**
 * make a queue
 * @author dannydani
 **/
public class Queue implements Runnable {
	ArrayList<String> queueURL;
	ArrayList<String> queueADDRESS;
	AddNewDownload and;
	static boolean queuemood=false;
	
	JFrame frame;
	
	
	JButton add;
	JButton start;
	JButton showQueue;
	
	
	
	JPanel panel;
	public Queue(AddNewDownload and)
	{
		this.and=and;
		frame=new JFrame("Queue");
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300, 345));
		
		
		queueURL=new ArrayList<>();
		queueADDRESS=new ArrayList<>();
		getFile();
		panel=new JPanel();
		
		if (AddNewDownload.persian==false)
		{add=new JButton("Add");
		showQueue=new JButton("Show");
		start=new JButton("Start");}
		else
		{
			add=new JButton("اضافه");
			showQueue=new JButton("نمایش");
			start=new JButton("شروع");
		}
		
		
		
		add.setBorderPainted(true);
		showQueue.setBorderPainted(true);
		start.setBorderPainted(true);
		
		
		add.setForeground(Color.WHITE);
		showQueue.setForeground(Color.WHITE);
		start.setForeground(Color.WHITE);
		
		
		add.setBackground(Color.BLACK);
		showQueue.setBackground(Color.BLACK);
		start.setBackground(Color.BLACK);
		
		
		add.setFont(new Font("Arial", Font.ITALIC, 20));
		showQueue.setFont(new Font("Arial", Font.ITALIC, 20));
		start.setFont(new Font("Arial", Font.ITALIC, 20));
		
		
		add.setHorizontalAlignment(SwingConstants.CENTER);
		showQueue.setHorizontalAlignment(SwingConstants.CENTER);
		start.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel.add(add);
		panel.add(showQueue);
		panel.add(start);
		
		
		SpringLayout layout=new SpringLayout();
		layout.putConstraint(SpringLayout.EAST, add, 0, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, add, 0, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, add, 0, SpringLayout.NORTH, panel);
		add.setPreferredSize(new Dimension(0, 100));
		
		layout.putConstraint(SpringLayout.EAST, showQueue, 0, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, showQueue, 0, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, showQueue, 0, SpringLayout.SOUTH, add);
		showQueue.setPreferredSize(new Dimension(0, 100));

		layout.putConstraint(SpringLayout.EAST, start, 0, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, start, 0, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, start, 0, SpringLayout.SOUTH, showQueue);
		layout.putConstraint(SpringLayout.SOUTH, start, 0, SpringLayout.SOUTH, panel);
		
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JFrame frame1;
				
				
				JPanel panelAdress;
				JPanel panelFile;
				JPanel panelButton;
				JPanel opening;
				JPanel totalPanel;
				
				JLabel textOfAddress;
				JLabel textOfFile;
				JLabel openingtext;
				
				
				JButton download1;
				
				
				JTextField address;
				JTextField file;
				
				String dic;
				frame1=new JFrame("Add new to Queue");
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame1.setPreferredSize(new Dimension(900, 300));
					
					panelAdress=new JPanel();
					panelFile=new JPanel();
					panelButton=new JPanel();
					opening=new JPanel();
					totalPanel=new JPanel();
					
					
					totalPanel.add(panelAdress);
					totalPanel.add(panelButton);
					totalPanel.add(panelFile);
					totalPanel.add(opening);
					
					if (AddNewDownload.persian==false)
					{textOfAddress=new JLabel("Address");
					textOfFile=new JLabel("File");}
					else
					{
						textOfAddress=new JLabel("ادرس");
						textOfFile=new JLabel("فایل");	
					}
					textOfAddress.setEnabled(false);
					textOfFile.setEnabled(false);
					address=new JTextField();
					//address.setText("please enter the address");
					address.setFont(new Font("Arial", Font.PLAIN, 20));
					file=new JTextField();
					file.setText("/home/paml");
					
					file.setFont(new Font("Arial", Font.PLAIN, 20));
					
					
					
					
					if (AddNewDownload.persian==false)
					{download1=new JButton("ADD");}
					else
					{
						download1=new JButton("اضافه");
					}
					download1.setBorderPainted(true);
					download1.setForeground(Color.WHITE);
					download1.setBackground(Color.BLACK);
					download1.setFont(new Font("Arial", Font.ITALIC, 20));
					download1.setHorizontalAlignment(SwingConstants.CENTER);
					
					
					openingtext=new JLabel("ADD TO QUEUE");
					openingtext.setForeground(Color.WHITE);
					openingtext.setHorizontalAlignment(SwingConstants.CENTER);
					openingtext.setFont(new Font("Arial", Font.ITALIC, 20));
					openingtext.setEnabled(false);
					opening.add(openingtext);
					
					panelButton.add(download1);
					

					panelAdress.add(address);
					panelFile.add(file);
					panelAdress.add(textOfAddress);
					panelFile.add(textOfFile);
					
					
					SpringLayout layoutFrame=new SpringLayout();
					SpringLayout layoutFile=new SpringLayout();
					SpringLayout layoutButton=new SpringLayout();
					SpringLayout layoutOpenning=new SpringLayout();
					SpringLayout layoutAddress=new SpringLayout();
					

					
					
					layoutAddress.putConstraint(SpringLayout.WEST, textOfAddress, 20, SpringLayout.WEST, panelAdress);
					textOfAddress.setPreferredSize(new Dimension(80, 40));
					textOfAddress.setFont(new Font("Arial", Font.ITALIC, 20));
					textOfAddress.setForeground(Color.white);
					layoutAddress.putConstraint(SpringLayout.WEST, address, 10, SpringLayout.EAST, textOfAddress);
					layoutAddress.putConstraint(SpringLayout.EAST, address, -10, SpringLayout.EAST, panelAdress);
					address.setPreferredSize(new Dimension(0, 40));
					panelAdress.setBackground(Color.BLACK);
					
					
					
					layoutFile.putConstraint(SpringLayout.WEST, textOfFile, 50, SpringLayout.WEST, panelFile);
					textOfFile.setPreferredSize(new Dimension(40, 40));
					textOfFile.setFont(new Font("Arial", Font.ITALIC, 20));
					textOfFile.setForeground(Color.white);
					layoutFile.putConstraint(SpringLayout.WEST, file, 18, SpringLayout.EAST, textOfFile);
					layoutFile.putConstraint(SpringLayout.EAST, file, -10, SpringLayout.EAST, panelFile);
					file.setPreferredSize(new Dimension(700, 40));
					panelFile.setBackground(Color.BLACK);
					
	
					
					
					layoutButton.putConstraint(SpringLayout.NORTH, download1, 0, SpringLayout.NORTH, panelButton);
					layoutButton.putConstraint(SpringLayout.SOUTH, download1, 0, SpringLayout.SOUTH, panelButton);
					layoutButton.putConstraint(SpringLayout.EAST, download1, 0, SpringLayout.EAST, panelButton);
					layoutButton.putConstraint(SpringLayout.WEST, download1, 0, SpringLayout.WEST, panelButton);
					
					
					layoutOpenning.putConstraint(SpringLayout.EAST, openingtext, 0, SpringLayout.EAST, opening);
					layoutOpenning.putConstraint(SpringLayout.WEST, openingtext, 0, SpringLayout.WEST, opening);
					layoutOpenning.putConstraint(SpringLayout.NORTH, openingtext, 0, SpringLayout.NORTH, opening);
					layoutOpenning.putConstraint(SpringLayout.SOUTH, openingtext, 0, SpringLayout.SOUTH, opening);
					
					
					
					
					
					layoutFrame.putConstraint(SpringLayout.NORTH, opening, 0, SpringLayout.NORTH, totalPanel);
					layoutFrame.putConstraint(SpringLayout.EAST, opening, 0, SpringLayout.EAST, totalPanel);
					layoutFrame.putConstraint(SpringLayout.WEST, opening, 0, SpringLayout.WEST, totalPanel);
					opening.setPreferredSize(new Dimension(0, 50));
					opening.setBackground(Color.BLACK);
					
					
					
					
					
					
					
					layoutFrame.putConstraint(SpringLayout.NORTH, panelAdress, 0, SpringLayout.SOUTH, opening);
					layoutFrame.putConstraint(SpringLayout.EAST, panelAdress, 0, SpringLayout.EAST, totalPanel);
					layoutFrame.putConstraint(SpringLayout.WEST, panelAdress, 0, SpringLayout.WEST, totalPanel);
					panelAdress.setPreferredSize(new Dimension(0, 50));
					
					
					
					
					
					layoutFrame.putConstraint(SpringLayout.NORTH, panelFile, 0, SpringLayout.SOUTH, panelAdress);
					layoutFrame.putConstraint(SpringLayout.EAST, panelFile, 0, SpringLayout.EAST, totalPanel);
					layoutFrame.putConstraint(SpringLayout.WEST, panelFile, 0, SpringLayout.WEST, totalPanel);
					panelFile.setPreferredSize(new Dimension(0, 50));
					
					
					
					
					layoutFrame.putConstraint(SpringLayout.NORTH, panelButton, 0, SpringLayout.SOUTH, panelFile);
					layoutFrame.putConstraint(SpringLayout.EAST, panelButton, 0, SpringLayout.EAST, totalPanel);
					layoutFrame.putConstraint(SpringLayout.WEST, panelButton, 0, SpringLayout.WEST, totalPanel);
					layoutFrame.putConstraint(SpringLayout.SOUTH, panelButton, 0, SpringLayout.SOUTH, totalPanel);
					//panelButton.setBackground(Color.BLACK);
					//opening.setPreferredSize(new Dimension(0, 30));*/
					
					
					download1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (address.getText().isEmpty()!=true && file.getText().isEmpty()!=true)
							{
								System.out.println(address.getText());
								System.out.println(file.getText());
								queueURL.add(address.getText());
								queueADDRESS.add(file.getText());
								//address.setText("please enter the address");
								//file.setText("please enter the direction");
								address.setText(null);
								file.setText(null);
								toFile();
							}
						}
					});

					panelAdress.setLayout(layoutAddress);
					panelFile.setLayout(layoutFile);
					opening.setLayout(layoutOpenning);
					panelButton.setLayout(layoutButton);
					totalPanel.setLayout(layoutFrame);
							
					
					totalPanel.setBackground(Color.BLACK);
					frame1.add(totalPanel);
					//frame.setLayout(null);
					frame1.pack();
					frame1.setVisible(true);
				
			}
		});
		showQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame2;
				
				
				JPanel panelAdress;
				JPanel panelFile;
				JPanel panelButton;
				JPanel opening;
				JPanel totalPanel;
				
				JLabel textOfAddress;
				JLabel textOfFile;
				JLabel openingtext;
				
				
				JButton exit;
				
				
				JLabel address;
				JLabel file;
				

				frame2=new JFrame("Showing Queue");
				frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame2.setPreferredSize(new Dimension(900, 300));	
					panelButton=new JPanel();
					opening=new JPanel();
					totalPanel=new JPanel();
					
					

					totalPanel.add(opening);
					
					
					Iterator<String> iterator=queueURL.iterator();
					Iterator<String> iterator2=queueADDRESS.iterator();
					while(iterator.hasNext())
					{
						textOfAddress=new JLabel("Address");
						textOfAddress.setEnabled(false);
						textOfFile=new JLabel("File");
						textOfFile.setEnabled(false);
						textOfAddress.setFont(new Font("Arial", Font.ITALIC, 20));
						textOfAddress.setForeground(Color.white);
						textOfFile.setFont(new Font("Arial", Font.ITALIC, 20));
						textOfFile.setForeground(Color.white);
						panelAdress=new JPanel();
						panelFile=new JPanel();
						address=new JLabel();
						file=new JLabel();
						address.setFont(new Font("Arial", Font.ITALIC, 20));
						address.setForeground(Color.white);
						address.setBackground(Color.BLACK);
						file.setForeground(Color.white);
						file.setBackground(Color.black);
						file.setFont(new Font("Arial", Font.PLAIN, 20));
						address.setText(iterator.next());
						file.setText(iterator2.next());

						panelAdress.add(address);
						panelFile.add(file);
						panelAdress.add(textOfAddress);
						panelFile.add(textOfFile);
						
						panelAdress.setPreferredSize(new Dimension(900, 40));
						panelFile.setPreferredSize(new Dimension(900, 40));
						SpringLayout layout1=new SpringLayout();
						layout1.putConstraint(SpringLayout.WEST, textOfAddress, 10, SpringLayout.WEST, panelAdress);
						layout1.putConstraint(SpringLayout.NORTH, textOfAddress, 0, SpringLayout.NORTH, panelAdress);
						layout1.putConstraint(SpringLayout.SOUTH, textOfAddress, 0, SpringLayout.SOUTH, panelAdress);
						textOfAddress.setPreferredSize(new Dimension(100, 0));
						
						layout1.putConstraint(SpringLayout.NORTH, address, 0, SpringLayout.NORTH, panelAdress);
						layout1.putConstraint(SpringLayout.SOUTH, address, 0, SpringLayout.SOUTH, panelAdress);
						layout1.putConstraint(SpringLayout.WEST, address, 10, SpringLayout.EAST, textOfAddress);
						layout1.putConstraint(SpringLayout.EAST, address, -10, SpringLayout.EAST, panelAdress);
						
						
						SpringLayout layout2=new SpringLayout();
						layout2.putConstraint(SpringLayout.WEST, textOfFile, 10, SpringLayout.WEST, panelFile);
						layout2.putConstraint(SpringLayout.NORTH, textOfFile, 0, SpringLayout.NORTH, panelFile);
						layout2.putConstraint(SpringLayout.SOUTH, textOfFile, 0, SpringLayout.SOUTH, panelFile);
						textOfFile.setPreferredSize(new Dimension(100, 0));
						layout2.putConstraint(SpringLayout.NORTH, file, 0, SpringLayout.NORTH, panelFile);
						layout2.putConstraint(SpringLayout.SOUTH, file, 0, SpringLayout.SOUTH, panelFile);
						layout2.putConstraint(SpringLayout.WEST, file, 10, SpringLayout.EAST, textOfFile);
						layout2.putConstraint(SpringLayout.EAST, file, -10, SpringLayout.EAST, panelFile);
						
						panelAdress.setLayout(layout1);
						panelFile.setLayout(layout2);
						totalPanel.add(panelAdress);
						totalPanel.add(panelFile);
					}
					exit=new JButton("Exit");
					exit.setBorderPainted(true);
					exit.setForeground(Color.WHITE);
					exit.setBackground(Color.BLACK);
					exit.setFont(new Font("Arial", Font.ITALIC, 20));
					exit.setHorizontalAlignment(SwingConstants.CENTER);
					exit.setPreferredSize(new Dimension(900, 300));
					
					
					
					openingtext=new JLabel("Show queue");
					openingtext.setForeground(Color.WHITE);
					openingtext.setHorizontalAlignment(SwingConstants.CENTER);
					openingtext.setFont(new Font("Arial", Font.ITALIC, 20));
					openingtext.setEnabled(false);
					opening.add(openingtext);
					opening.setPreferredSize(new Dimension(900, 50));
					
					
					
					panelButton.add(exit);
					//totalPanel.add(panelButton);
					//totalPanel.setLayout(new FlowLayout());


					exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame2.dispose();
						}
					});
					//totalPanel.setBackground(Color.BLACK);
					frame2.setBackground(Color.BLACK);
					frame2.add(totalPanel);
					frame2.pack();
					
					
					frame2.setVisible(true);
				
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (queueURL.size()==0)
				{
					System.out.println("NO queue");
					return ;
				}
				else
				{
					toFile();
					new Thread(new Queue(and)).start();
				}
			}
		});
		panel.setLayout(layout);
		frame.add(panel);
		frame.pack();
	}
	public void show()
	{
		frame.setVisible(true);
	}
	public void toFile()
	{
		String URL,ADDRESS;
		File file=new File("queue.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			Iterator<String> iterator=queueURL.iterator();
			Iterator<String> iterator2=queueADDRESS.iterator();
			while(iterator.hasNext())
			{
				URL=iterator.next();
				URL=URL+"\n";
				bw.write(URL);
				ADDRESS=iterator2.next();
				ADDRESS=ADDRESS+"\n";
				bw.write(ADDRESS);
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
	public  void getFile()
	{
		System.out.println("newwwwww");
		String string="1";
		File file=new File("queue.jdm");
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
				string=br.readLine();
				if (string!=null)
				{
					queueURL.add(string);
					string=br.readLine();
					queueADDRESS.add(string);
				}
				else
				{
					string=null;
				}
			}while(string!=null);
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
	@Override
	public void run() {
		SwingWorker<Void, Void> worker=new SwingWorker<Void,Void>()
		{
			@Override
			protected Void doInBackground() throws Exception {
				while(queueURL.size()!=0)
				{
					boolean bl=false;
					boolean bl2=false;
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
					String time=dateFormat.format(cal.getTime());
					System.out.println("lmd="+DownloadMenu.lmd);
					if (LimitedDownloads.limitedDownload==-1 || LimitedDownloads.limitedDownload>=DownloadMenu.lmd)
					{
						System.out.println("newwwwww");
						String firstLine="1";
						File file2=new File("URL.jdm");
						BufferedWriter bw=null;
						try
						{	
							if (!file2.exists())
							{
								file2.createNewFile();
							}
							BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
							do
							{
								String string=br.readLine();
								if (string!=null)
								{
									for(int i=0 ; i<string.length();i++)
									{
										if (string.charAt(i)=='/')
										{
											if (string.charAt(i+1)=='/')
											{
												i++;
											}
											else
											{
												bl=true;
												break;
											}
										}
									}
									if (bl==true)
									{
										if (queueURL.get(0).equals(string)==true)
										{
											bl2=true;
										}
									}
									if (bl==false)
									{
										if (queueURL.get(0).contains(string)==true)
										{
											bl2=true;
										}
									}
								}	
								else
								{
									firstLine=null;
								}
								string=br.readLine();
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
									if (bl2==false)
									{
										DownloadMenu dm=new DownloadMenu(queueURL.get(0), "0",time);
										dm.setURL(queueURL.get(0));
										dm.setFile(queueADDRESS.get(0));
										System.out.println("address="+queueADDRESS.get(0));
										System.out.println("heerrerere rwe googogogoogo");
										AddNewDownload.adding(dm);
										new Thread(dm).start();
										and.showRunTime();
										while(dm.getPercent()!=100)
										{
											System.out.println("Waiting");
											continue;
										}
										queueURL.remove(0);
										queueADDRESS.remove(0);
									}
									else
									{
										queueURL.remove(0);
										queueADDRESS.remove(0);
									}
								}catch(Exception ex){
									System.out.println("Error in closing the BufferedWriter"+ex);
								}
							}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Limited downloads","Alert",JOptionPane.WARNING_MESSAGE);
						if (queueURL.size()!=0)
						{
							System.out.println("newwwwww");
							String firstLine="1";
							File file2=new File("URL.jdm");
							BufferedWriter bw=null;
							try
							{	
								if (!file2.exists())
								{
									file2.createNewFile();
								}
								BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
								do
								{
									String string=br.readLine();
									if (string!=null)
									{
										for(int i=0 ; i<string.length();i++)
										{
											if (string.charAt(i)=='/')
											{
												if (string.charAt(i+1)=='/')
												{
													i++;
												}
												else
												{
													bl=true;
													break;
												}
											}
										}
										if (bl==true)
										{
											if (queueURL.get(0).equals(string)==true)
											{
												bl2=true;
											}
										}
										if (bl==false)
										{
											if (queueURL.get(0).contains(string)==true)
											{
												bl2=true;
											}
										}
									}	
									else
									{
										firstLine=null;
									}
									string=br.readLine();
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
									if (bl2==false)
									{
										DownloadMenu dm=new DownloadMenu(queueURL.get(0), "0",time);
										dm.setURL(queueURL.get(0));
										dm.setFile(queueADDRESS.get(0));
										System.out.println("address="+queueADDRESS.get(0));
										System.out.println("heerrerere rwe googogogoogo");
										AddNewDownload.adding(dm);
										AddNewDownload.addToArray2(dm);
										new Thread(dm).wait();
										and.showRunTime();
										while(dm.getPercent()!=100)
										{
											System.out.println("Waiting");
											continue;
										}
										queueADDRESS.remove(0);
										queueURL.remove(0);
									}
									else
									{
										queueADDRESS.remove(0);
										queueURL.remove(0);
									}
								}catch(Exception ex){
									System.out.println("Error in closing the BufferedWriter"+ex);
								}
							}
						}
						and.showRunTime();
					}
				}
				return null;
			}
		};
		worker.execute();
	}
}
