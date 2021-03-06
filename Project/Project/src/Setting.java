import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * information of setting
 * @author dannydani
 *
 */
public class Setting {
	JFrame frame;
	JPanel panel;
	JButton limitedDownloads;
	JButton locationOfDownloads;
	JButton selectLookAndFeel;
	JButton invalidSite;
	private static String defaultFileDic;
	/**
	 * Constructor of setting
	 */
	
	
	/**
	 * constructor of setting
	 */
	public Setting()
	{
		frame=new JFrame("Setting");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 700));
		limitedDownloads=new JButton("Limited Downloads");
		locationOfDownloads=new JButton("Location Of Downloads");
		selectLookAndFeel=new JButton("Select Look and Feel");
		invalidSite=new JButton("Invalid site");
		panel=new JPanel();

		frame.add(panel);
		panel.add(limitedDownloads);
		panel.add(locationOfDownloads);
		panel.add(selectLookAndFeel);
		panel.add(invalidSite);
		

		SpringLayout layout=new SpringLayout();
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, limitedDownloads, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, limitedDownloads, 5, SpringLayout.NORTH, panel);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, locationOfDownloads, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, locationOfDownloads, 5, SpringLayout.SOUTH, limitedDownloads);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, selectLookAndFeel, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, selectLookAndFeel, 5, SpringLayout.SOUTH, locationOfDownloads);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, invalidSite, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, invalidSite, 5, SpringLayout.SOUTH, selectLookAndFeel);
		
		panel.setLayout(layout);
		frame.pack();
		
		limitedDownloads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				LimitedDownloads l1=new LimitedDownloads();
				l1.show();	
			}
		});
		/**
		 * look and feel
		 */
		selectLookAndFeel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				LookAndFeel a1=new LookAndFeel();
				a1.show();
			}
		});
		/**
		 * locantion of download
		 */
		locationOfDownloads.addActionListener(new ActionListener() {
			private JFileChooser fileChooser;
			private int returnval;
				
			public void actionPerformed(ActionEvent arg0) {
				fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				returnval=fileChooser.showOpenDialog(null);
				if (returnval==fileChooser.APPROVE_OPTION)
				{
					defaultFileDic=fileChooser.getSelectedFile().getAbsolutePath();
				}
				else if (returnval==fileChooser.ERROR_OPTION)
				{
					actionPerformed(arg0);
				}
			}
		});
		/**
		 * invalid site
		 */
		invalidSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame frame1;
				
				
				JPanel panelAdress;
				JPanel opening;
				JPanel totalPanel;
				
				JLabel textOfAddress;
				JLabel openingtext;
				
				
				JTextField address;
				
				String dic;
				frame1=new JFrame("Add new to Queue");
				frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame1.setPreferredSize(new Dimension(900, 300));
					
					panelAdress=new JPanel();
					opening=new JPanel();
					totalPanel=new JPanel();
					
					
					totalPanel.add(panelAdress);
					totalPanel.add(opening);
					
					
					textOfAddress=new JLabel("Address");
					textOfAddress.setEnabled(false);
					address=new JTextField();
					address.setText("please enter the address");
					address.setFont(new Font("Arial", Font.PLAIN, 20));
					
					
					
					
					
					
					
					openingtext=new JLabel("Invalid Website");
					openingtext.setForeground(Color.WHITE);
					openingtext.setHorizontalAlignment(SwingConstants.CENTER);
					openingtext.setFont(new Font("Arial", Font.ITALIC, 20));
					openingtext.setEnabled(false);
					opening.add(openingtext);
					
					

					panelAdress.add(address);
					panelAdress.add(textOfAddress);
					
					
					SpringLayout layoutFrame=new SpringLayout();
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
					layoutFrame.putConstraint(SpringLayout.SOUTH, panelAdress, 0, SpringLayout.SOUTH, totalPanel);
					
					
					
					
					
					
					panelAdress.setLayout(layoutAddress);
					opening.setLayout(layoutOpenning);
					totalPanel.setLayout(layoutFrame);
							
					
					totalPanel.setBackground(Color.BLACK);
					frame1.add(totalPanel);
					//frame.setLayout(null);
					frame1.pack();
					frame1.setVisible(true);
					address.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							File file=new File("URL.jdm");
							BufferedWriter bw=null;
							try
							{	
								if (!file.exists())
								{
									file.createNewFile();
								}
								FileWriter fw=new FileWriter(file);
								bw=new BufferedWriter(fw);
								String string=address.getText()+"\n";
								bw.write(string);
							}
							catch (IOException ioe) {
								ioe.printStackTrace();
								}
								finally
								{ 
									try{
							      if(bw!=null)
							    	  bw.close();
							      address.setText(null);
									}catch(Exception ex){
										System.out.println("Error in closing the BufferedWriter"+ex);
									}
								}
						//System.out.println("Yes");
						
						}
							
						
					});
			}
		});
		
	}
	
	
	
	public void show()
	{
		frame.setVisible(true);
	}
	/**
	 * write to file
	 * @throws IOException
	 */
	
	
	public static void toFile() throws IOException
	{
		File file=new File("setting.jdm");
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
			System.out.println("hereeeeeeeee");
			string=defaultFileDic;
			string=string+"\n";
			bw.write(string);
			string=UIManager.getSystemLookAndFeelClassName();
			string=string+"\n";
			bw.write(string);
			b=LimitedDownloads.limitedDownload;
			string="\n";
			bw.write(b);
			bw.write(string);
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
	/**
	 * get information from file
	 */
	public  static void getFileDate()
	{
		System.out.println("newwwwww");
		String firstLine="1";
		File file=new File("setting.jdm");
		BufferedWriter bw=null;
		try
		{	
			if (!file.exists())
			{
				file.createNewFile();
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String path=br.readLine();
			String lookandfeel=br.readLine();
			int number=br.read();
			LimitedDownloads.limitedDownload=number;
			defaultFileDic=path;
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
	/**
	 * get default directory
	 * @return directory
	 */
	public String getFile()
	{
		return defaultFileDic;
	}
	

}
