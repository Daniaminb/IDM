import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
/**
 * show information of new download
 * @author dannydani
 *
 */
public class ShowInformation {
	JFrame frame1;
	JPanel panelAdress;
	JPanel panelFile;
	JPanel opening;
	JPanel panelTime;
	JPanel panelVolumeOfDownloading;
	JPanel panelPercentOfDownloadding;
	JPanel panelVolumeOfFile;
	JPanel totalPanel;
	
	JLabel textOfAddress;
	JLabel textOfFile;
	JLabel openingtext;
	JLabel textOfTime;
	JLabel textOfVolumeofDownlodin;
	JLabel textOfPercentOfDOwnloding;
	JLabel textOfVolumeOfFile;
	
	
	JLabel volumeOfDownloadin;
	JLabel percentOfDownloading;
	JLabel volumeOfFile;
	JLabel time;
	JLabel address;
	JLabel file;
	/**
	 * Constructor of ishow information
	 * @param Url url
	 * @param filePath filepath
	 * @param time time of downloading
	 * @param volumeOfDownloading volume of downloading
	 * @param percentOfDownloading percent of downloading
	 * @param volumeOfFile volume of file
	 */
	public ShowInformation(String Url,String filePath,String time,String volumeOfDownloading,String percentOfDownloading,String volumeOfFile)
	{
		frame1=new JFrame("Information Of Download");
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(900, 300));
		
		
		panelAdress=new JPanel();
		panelFile=new JPanel();
		opening=new JPanel();
		panelPercentOfDownloadding=new JPanel();
		panelTime=new JPanel();
		panelVolumeOfDownloading=new JPanel();
		panelVolumeOfFile=new JPanel();
		totalPanel=new JPanel();
		
		
		totalPanel.add(panelAdress);
		totalPanel.add(panelFile);
		totalPanel.add(opening);
		totalPanel.add(panelTime);
		totalPanel.add(panelPercentOfDownloadding);
		totalPanel.add(panelVolumeOfFile);
		totalPanel.add(panelVolumeOfDownloading);
		
		
		textOfAddress=new JLabel("Address");
		textOfAddress.setEnabled(false);
		textOfFile=new JLabel("File");
		textOfFile.setEnabled(false);
		textOfTime=new JLabel("Time Of Start");
		textOfTime.setEnabled(false);
		textOfPercentOfDOwnloding=new JLabel("Percent of Downloads");
		textOfPercentOfDOwnloding.setEnabled(false);
		textOfVolumeofDownlodin=new JLabel("Volume of Downloads");
		textOfVolumeofDownlodin.setEnabled(false);
		textOfVolumeOfFile=new JLabel("Volume of File");
		textOfVolumeOfFile.setEnabled(false);
		
		address=new JLabel();
		address.setText(Url);
		address.setForeground(Color.WHITE);
		address.setFont(new Font("Arial", Font.PLAIN, 20));
		
		System.out.println("aaaaaaaaaaaaaaaa="+address.getText());
		address.setEnabled(false);
		file=new JLabel();
		file.setText(filePath);
		file.setFont(new Font("Arial", Font.PLAIN, 20));
		file.setForeground(Color.WHITE);
		file.setEnabled(false);
		
		
		openingtext=new JLabel("Information of download");
		openingtext.setForeground(Color.WHITE);
		openingtext.setHorizontalAlignment(SwingConstants.CENTER);
		openingtext.setFont(new Font("Arial", Font.ITALIC, 20));
		openingtext.setEnabled(false);
		opening.add(openingtext);
		
		this.volumeOfDownloadin=new JLabel();
		this.volumeOfDownloadin.setForeground(Color.WHITE);
		this.volumeOfDownloadin.setText(volumeOfDownloading);
		this.volumeOfDownloadin.setEnabled(false);
		this.volumeOfDownloadin.setFont(new Font("Arial", Font.ITALIC, 20));
		panelVolumeOfDownloading.add(this.volumeOfDownloadin);
		panelVolumeOfDownloading.add(textOfVolumeofDownlodin);
		
		
		this.time=new JLabel();
		this.time.setForeground(Color.WHITE);
		this.time.setText(time);
		this.time.setEnabled(false);
		this.time.setFont(new Font("Arial", Font.ITALIC, 20));
		panelTime.add(this.time);
		panelTime.add(textOfTime);


		this.volumeOfFile=new JLabel();
		this.volumeOfFile.setForeground(Color.WHITE);
		this.volumeOfFile.setText(volumeOfFile);
		this.volumeOfFile.setEnabled(false);
		this.volumeOfFile.setFont(new Font("Arial", Font.ITALIC, 20));
		panelVolumeOfFile.add(this.volumeOfFile);
		panelVolumeOfFile.add(textOfVolumeOfFile);
		
		
		this.percentOfDownloading=new JLabel();
		this.percentOfDownloading.setForeground(Color.WHITE);
		this.percentOfDownloading.setText(percentOfDownloading);
		this.percentOfDownloading.setEnabled(false);
		this.percentOfDownloading.setFont(new Font("Arial", Font.ITALIC, 20));
		panelPercentOfDownloadding.add(this.percentOfDownloading);
		panelPercentOfDownloadding.add(textOfPercentOfDOwnloding);
		
		panelAdress.add(address);
		panelFile.add(file);
		panelAdress.add(textOfAddress);
		panelFile.add(textOfFile);
		
		
		SpringLayout layoutFrame=new SpringLayout();
		SpringLayout layoutFile=new SpringLayout();
		SpringLayout layoutOpenning=new SpringLayout();
		SpringLayout layoutAddress=new SpringLayout();
		SpringLayout layoutTime=new SpringLayout();
		SpringLayout layoutPercent=new SpringLayout();
		SpringLayout layoutvf=new SpringLayout();
		SpringLayout layoutvd=new SpringLayout();
		
		
		
		layoutAddress.putConstraint(SpringLayout.WEST, textOfAddress, 50, SpringLayout.WEST, panelAdress);
		textOfAddress.setPreferredSize(new Dimension(300, 40));
		textOfAddress.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfAddress.setForeground(Color.white);
		layoutAddress.putConstraint(SpringLayout.WEST, address, 18, SpringLayout.EAST, textOfAddress);
		layoutAddress.putConstraint(SpringLayout.EAST, address, -10, SpringLayout.EAST, panelAdress);
		address.setPreferredSize(new Dimension(0, 40));
		panelAdress.setBackground(Color.BLACK);
		
		
		
		layoutFile.putConstraint(SpringLayout.WEST, textOfFile, 50, SpringLayout.WEST, panelFile);
		textOfFile.setPreferredSize(new Dimension(300, 40));
		textOfFile.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfFile.setForeground(Color.white);
		layoutFile.putConstraint(SpringLayout.WEST, file, 18, SpringLayout.EAST, textOfFile);
		layoutFile.putConstraint(SpringLayout.EAST, file, -10, SpringLayout.EAST, panelFile);
		file.setPreferredSize(new Dimension(700, 40));
		panelFile.setBackground(Color.BLACK);
		

		layoutPercent.putConstraint(SpringLayout.WEST, textOfPercentOfDOwnloding, 50, SpringLayout.WEST, panelPercentOfDownloadding);
		textOfPercentOfDOwnloding.setPreferredSize(new Dimension(300, 40));
		textOfPercentOfDOwnloding.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfPercentOfDOwnloding.setForeground(Color.white);
		layoutPercent.putConstraint(SpringLayout.WEST, this.percentOfDownloading, 18, SpringLayout.EAST, textOfPercentOfDOwnloding);
		layoutPercent.putConstraint(SpringLayout.EAST, this.percentOfDownloading, -10, SpringLayout.EAST, panelPercentOfDownloadding);
		this.percentOfDownloading.setPreferredSize(new Dimension(700, 40));
		panelPercentOfDownloadding.setBackground(Color.BLACK);
		
		
		
		layoutvf.putConstraint(SpringLayout.WEST, textOfVolumeOfFile, 50, SpringLayout.WEST, panelVolumeOfFile);
		textOfVolumeOfFile.setPreferredSize(new Dimension(300, 40));
		textOfVolumeOfFile.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfVolumeOfFile.setForeground(Color.white);
		layoutvf.putConstraint(SpringLayout.WEST, this.volumeOfFile, 18, SpringLayout.EAST, textOfVolumeOfFile);
		layoutvf.putConstraint(SpringLayout.EAST, this.volumeOfFile, -10, SpringLayout.EAST, panelVolumeOfFile);
		this.volumeOfFile.setPreferredSize(new Dimension(700, 40));
		panelVolumeOfFile.setBackground(Color.BLACK);
		
		
		
		layoutvd.putConstraint(SpringLayout.WEST, textOfVolumeofDownlodin, 50, SpringLayout.WEST, panelVolumeOfDownloading);
		textOfVolumeofDownlodin.setPreferredSize(new Dimension(300, 40));
		textOfVolumeofDownlodin.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfVolumeofDownlodin.setForeground(Color.white);
		layoutvd.putConstraint(SpringLayout.WEST, this.volumeOfDownloadin, 18, SpringLayout.EAST, textOfVolumeofDownlodin);
		layoutvd.putConstraint(SpringLayout.EAST, this.volumeOfDownloadin, -10, SpringLayout.EAST, panelVolumeOfDownloading);
		this.volumeOfDownloadin.setPreferredSize(new Dimension(700, 40));
		panelVolumeOfDownloading.setBackground(Color.BLACK);
		
		
		
		layoutTime.putConstraint(SpringLayout.WEST, textOfTime, 50, SpringLayout.WEST, panelTime);
		textOfTime.setPreferredSize(new Dimension(300, 40));
		textOfTime.setFont(new Font("Arial", Font.ITALIC, 20));
		textOfTime.setForeground(Color.white);
		layoutTime.putConstraint(SpringLayout.WEST, this.time, 18, SpringLayout.EAST, textOfTime);
		layoutTime.putConstraint(SpringLayout.EAST, this.time, -10, SpringLayout.EAST, panelTime);
		this.time.setPreferredSize(new Dimension(700, 40));
		panelTime.setBackground(Color.BLACK);
		
		
		
		
		
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
		
		
		
		layoutFrame.putConstraint(SpringLayout.NORTH, panelPercentOfDownloadding, 0, SpringLayout.SOUTH, panelFile);
		layoutFrame.putConstraint(SpringLayout.EAST, panelPercentOfDownloadding, 0, SpringLayout.EAST, totalPanel);
		layoutFrame.putConstraint(SpringLayout.WEST, panelPercentOfDownloadding, 0, SpringLayout.WEST, totalPanel);
		panelPercentOfDownloadding.setPreferredSize(new Dimension(0, 50));
		

		layoutFrame.putConstraint(SpringLayout.NORTH, panelVolumeOfDownloading, 0, SpringLayout.SOUTH, panelPercentOfDownloadding);
		layoutFrame.putConstraint(SpringLayout.EAST, panelVolumeOfDownloading, 0, SpringLayout.EAST, totalPanel);
		layoutFrame.putConstraint(SpringLayout.WEST, panelVolumeOfDownloading, 0, SpringLayout.WEST, totalPanel);
		panelVolumeOfDownloading.setPreferredSize(new Dimension(0, 50));

		layoutFrame.putConstraint(SpringLayout.NORTH, panelVolumeOfFile, 0, SpringLayout.SOUTH, panelVolumeOfDownloading);
		layoutFrame.putConstraint(SpringLayout.EAST, panelVolumeOfFile, 0, SpringLayout.EAST, totalPanel);
		layoutFrame.putConstraint(SpringLayout.WEST, panelVolumeOfFile, 0, SpringLayout.WEST, totalPanel);
		panelVolumeOfFile.setPreferredSize(new Dimension(0, 50));
		
		layoutFrame.putConstraint(SpringLayout.NORTH, panelTime, 0, SpringLayout.SOUTH, panelVolumeOfFile);
		layoutFrame.putConstraint(SpringLayout.EAST, panelTime, 0, SpringLayout.EAST, totalPanel);
		layoutFrame.putConstraint(SpringLayout.WEST, panelTime, 0, SpringLayout.WEST, totalPanel);
		layoutFrame.putConstraint(SpringLayout.SOUTH, panelTime, -20, SpringLayout.SOUTH, totalPanel);
				

		panelAdress.setLayout(layoutAddress);
		panelFile.setLayout(layoutFile);
		opening.setLayout(layoutOpenning);
		panelPercentOfDownloadding.setLayout(layoutPercent);
		panelVolumeOfDownloading.setLayout(layoutvd);
		panelVolumeOfFile.setLayout(layoutvf);
		panelTime.setLayout(layoutTime);
		totalPanel.setLayout(layoutFrame);
				
		
		totalPanel.setBackground(Color.BLACK);
		frame1.add(totalPanel);
		//frame.setLayout(null);
		frame1.pack();
	}
	/**
	 * show the frame of information
	 */
	public void show()
	{
		frame1.setVisible(true);
	}
}
