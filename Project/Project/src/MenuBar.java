import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
/**
 * menu bar of download
 * @author dannydani
 *
 */
public class MenuBar extends JPanel {
	JMenu downloads;
	JMenu help;
	JMenuBar menuDownloads;
	JMenuBar menuHelp;
	JMenuItem resume,pause,cancel,setting,remove,about;
	public MenuBar()
	{
		downloads=new JMenu("Downloads");
		help=new JMenu("Help");
		
		
		resume=new JMenuItem("Resume");
		pause=new JMenuItem("Pause");
		cancel=new JMenuItem("Cancel");
		setting=new JMenuItem("Setting");
		remove=new JMenuItem("Remove");
		about=new JMenuItem("About");
		
		downloads.add(resume);
		downloads.add(cancel);
		downloads.add(pause);
		downloads.add(setting);
		downloads.add(remove);
		
		help.add(about);
		
		
		menuDownloads=new JMenuBar();
		menuDownloads.add(downloads);
		
		
		
		menuHelp=new JMenuBar();
		menuHelp.add(help);
		
        downloads.setMnemonic(KeyEvent.VK_D);
        help.setMnemonic(KeyEvent.VK_H);
		
        about.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("go");
				JFrame frame=new JFrame("About Writer");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setPreferredSize(new Dimension(900, 300));
				JPanel panelWriter=new JPanel();
				JPanel panelStart=new JPanel();
				JPanel panelFinish=new JPanel();
				JPanel panelUse=new JPanel();
				JPanel panelNumber=new JPanel();
				JPanel totalPanel=new JPanel();
				
				
				totalPanel.add(panelWriter);
				totalPanel.add(panelStart);
				totalPanel.add(panelFinish);
				totalPanel.add(panelUse);
				totalPanel.add(panelNumber);
				
				
				JLabel textOfWriter=new JLabel("Writer:");
				textOfWriter.setEnabled(false);
				JLabel textOfStart=new JLabel("Time of Start:");
				textOfStart.setEnabled(false);
				JLabel textOfFinish=new JLabel("Time Of Finish:");
				textOfFinish.setEnabled(false);
				JLabel textOfUse=new JLabel("Use:");
				textOfUse.setEnabled(false);
				JLabel textOfNumber=new JLabel("ID NUMBER");
				textOfNumber.setEnabled(false);
				
				JLabel writer=new JLabel();
				writer.setText("Dannydani");
				writer.setFont(new Font("Arial", Font.PLAIN, 20));
				writer.setEnabled(false);
				panelWriter.add(writer);
				panelWriter.add(textOfWriter);
				JLabel start=new JLabel();
				start.setText("0");
				start.setFont(new Font("Arial", Font.PLAIN, 20));
				start.setEnabled(false);
				panelStart.add(start);
				panelStart.add(textOfStart);
				
				
				JLabel finish=new JLabel();
				finish.setForeground(Color.WHITE);
				finish.setText("0");
				finish.setEnabled(false);
				finish.setFont(new Font("Arial", Font.ITALIC, 20));
				panelFinish.add(finish);
				panelFinish.add(textOfFinish);
				
				
				JLabel USE=new JLabel();
				USE.setForeground(Color.WHITE);
				USE.setText("Easy");
				USE.setEnabled(false);
				USE.setFont(new Font("Arial", Font.ITALIC, 20));
				panelUse.add(USE);
				panelUse.add(textOfUse);


				JLabel number=new JLabel();
				number.setForeground(Color.WHITE);
				number.setText("9631803");
				number.setEnabled(false);
				number.setFont(new Font("Arial", Font.ITALIC, 20));
				panelNumber.add(number);
				panelNumber.add(textOfNumber);
				
				
				SpringLayout layoutFrame=new SpringLayout();
				SpringLayout layoutFile=new SpringLayout();
				SpringLayout layoutOpenning=new SpringLayout();
				SpringLayout layoutAddress=new SpringLayout();
				SpringLayout layoutTime=new SpringLayout();
				SpringLayout layoutPercent=new SpringLayout();
				SpringLayout layoutvf=new SpringLayout();
				SpringLayout layoutvd=new SpringLayout();
				
				
				
				layoutAddress.putConstraint(SpringLayout.WEST, textOfWriter, 50, SpringLayout.WEST, panelWriter);
				textOfWriter.setPreferredSize(new Dimension(300, 40));
				textOfWriter.setFont(new Font("Arial", Font.ITALIC, 20));
				textOfWriter.setForeground(Color.white);
				layoutAddress.putConstraint(SpringLayout.WEST, writer, 18, SpringLayout.EAST, textOfWriter);
				layoutAddress.putConstraint(SpringLayout.EAST, writer, -10, SpringLayout.EAST, panelWriter);
				writer.setPreferredSize(new Dimension(0, 40));
				panelWriter.setBackground(Color.BLACK);
				
				
				
				layoutFile.putConstraint(SpringLayout.WEST, textOfStart, 50, SpringLayout.WEST, panelStart);
				textOfStart.setPreferredSize(new Dimension(300, 40));
				textOfStart.setFont(new Font("Arial", Font.ITALIC, 20));
				textOfStart.setForeground(Color.white);
				layoutFile.putConstraint(SpringLayout.WEST, start, 18, SpringLayout.EAST, textOfStart);
				layoutFile.putConstraint(SpringLayout.EAST, start, -10, SpringLayout.EAST, panelStart);
				start.setPreferredSize(new Dimension(700, 40));
				panelStart.setBackground(Color.BLACK);
				

				layoutPercent.putConstraint(SpringLayout.WEST, textOfFinish, 50, SpringLayout.WEST, panelFinish);
				textOfFinish.setPreferredSize(new Dimension(300, 40));
				textOfFinish.setFont(new Font("Arial", Font.ITALIC, 20));
				textOfFinish.setForeground(Color.white);
				layoutPercent.putConstraint(SpringLayout.WEST, finish, 18, SpringLayout.EAST, textOfFinish);
				layoutPercent.putConstraint(SpringLayout.EAST, finish, -10, SpringLayout.EAST, panelFinish);
				finish.setPreferredSize(new Dimension(700, 40));
				panelFinish.setBackground(Color.BLACK);
				
				
				
				layoutvf.putConstraint(SpringLayout.WEST, textOfUse, 50, SpringLayout.WEST, panelUse);
				textOfUse.setPreferredSize(new Dimension(300, 40));
				textOfUse.setFont(new Font("Arial", Font.ITALIC, 20));
				textOfUse.setForeground(Color.white);
				layoutvf.putConstraint(SpringLayout.WEST, USE, 18, SpringLayout.EAST, textOfUse);
				layoutvf.putConstraint(SpringLayout.EAST, USE, -10, SpringLayout.EAST, panelUse);
				USE.setPreferredSize(new Dimension(700, 40));
				panelUse.setBackground(Color.BLACK);
				
				
				
				layoutvd.putConstraint(SpringLayout.WEST, textOfNumber, 50, SpringLayout.WEST, panelNumber);
				textOfNumber.setPreferredSize(new Dimension(300, 40));
				textOfNumber.setFont(new Font("Arial", Font.ITALIC, 20));
				textOfNumber.setForeground(Color.white);
				layoutvd.putConstraint(SpringLayout.WEST, number, 18, SpringLayout.EAST, textOfNumber);
				layoutvd.putConstraint(SpringLayout.EAST, number, -10, SpringLayout.EAST, panelNumber);
				number.setPreferredSize(new Dimension(700, 40));
				panelNumber.setBackground(Color.BLACK);
				
				
				
				
				
				layoutFrame.putConstraint(SpringLayout.NORTH, panelWriter, 0, SpringLayout.NORTH, totalPanel);
				layoutFrame.putConstraint(SpringLayout.EAST, panelWriter, 0, SpringLayout.EAST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.WEST, panelWriter, 0, SpringLayout.WEST, totalPanel);
				panelWriter.setPreferredSize(new Dimension(0, 50));
				panelWriter.setBackground(Color.BLACK);
				
				
				
				
				
				layoutFrame.putConstraint(SpringLayout.NORTH, panelStart, 0, SpringLayout.SOUTH, panelWriter);
				layoutFrame.putConstraint(SpringLayout.EAST, panelStart, 0, SpringLayout.EAST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.WEST, panelStart, 0, SpringLayout.WEST, totalPanel);
				panelStart.setPreferredSize(new Dimension(0, 50));
				
				
				
				
				
				layoutFrame.putConstraint(SpringLayout.NORTH, panelFinish, 0, SpringLayout.SOUTH, panelStart);
				layoutFrame.putConstraint(SpringLayout.EAST, panelFinish, 0, SpringLayout.EAST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.WEST, panelFinish, 0, SpringLayout.WEST, totalPanel);
				panelFinish.setPreferredSize(new Dimension(0, 50));
				
				
				
				layoutFrame.putConstraint(SpringLayout.NORTH, panelUse, 0, SpringLayout.SOUTH, panelFinish);
				layoutFrame.putConstraint(SpringLayout.EAST, panelUse, 0, SpringLayout.EAST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.WEST, panelUse, 0, SpringLayout.WEST, totalPanel);
				panelUse.setPreferredSize(new Dimension(0, 50));
				
				
				layoutFrame.putConstraint(SpringLayout.NORTH, panelNumber, 0, SpringLayout.SOUTH, panelUse);
				layoutFrame.putConstraint(SpringLayout.EAST, panelNumber, 0, SpringLayout.EAST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.WEST, panelNumber, 0, SpringLayout.WEST, totalPanel);
				layoutFrame.putConstraint(SpringLayout.SOUTH, panelNumber, -20, SpringLayout.SOUTH, totalPanel);
						

				panelWriter.setLayout(layoutAddress);
				panelStart.setLayout(layoutFile);
				panelFinish.setLayout(layoutPercent);
				panelNumber.setLayout(layoutvd);
				panelUse.setLayout(layoutvf);
				totalPanel.setLayout(layoutFrame);
						
				
				totalPanel.setBackground(Color.BLACK);
				
				frame.add(totalPanel);
				frame.pack();
				frame.setVisible(true);	
			}
		});
        
        this.add(menuDownloads);
		this.add(menuHelp);
		}
}
