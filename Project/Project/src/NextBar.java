import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
/**
 * next bar
 * @author dannydani
 *
 */
public class NextBar extends JPanel {
	JButton language;
	JButton documents;
	JButton comperesed;
	JButton music;
	JButton video;
	JButton program;
	public NextBar()
	{
		language=new JButton("Language");
		documents=new JButton("Documents");
		comperesed=new JButton("Comperesed");
		music=new JButton("Music");
		video=new JButton("Video");
		program=new JButton("Program");
		
		
		program.setPreferredSize(new Dimension(150, 30));
		music.setPreferredSize(new Dimension(150, 30));
		video.setPreferredSize(new Dimension(150, 30));
		comperesed.setPreferredSize(new Dimension(150, 30));
		documents.setPreferredSize(new Dimension(150, 30));
		language.setPreferredSize(new Dimension(150, 30));
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		program.setBorder(emptyBorder);
		music.setBorder(emptyBorder);
		video.setBorder(emptyBorder);
		documents.setBorder(emptyBorder);
		language.setBorder(emptyBorder);
		comperesed.setBorder(emptyBorder);
		
		
		
		
		music.setBackground(Color.BLACK);
		language.setBackground(Color.BLACK);
		comperesed.setBackground(Color.BLACK);
		documents.setBackground(Color.BLACK);
		video.setBackground(Color.BLACK);
		program.setBackground(Color.BLACK);
		
		
		
		
		music.setForeground(Color.WHITE);
		video.setForeground(Color.WHITE);
		program.setForeground(Color.WHITE);
		documents.setForeground(Color.WHITE);
		comperesed.setForeground(Color.WHITE);
		language.setForeground(Color.WHITE);
		
		
		program.setFont(new Font("Arial", Font.PLAIN, 20));
		music.setFont(new Font("Arial", Font.PLAIN, 20));
		video.setFont(new Font("Arial", Font.PLAIN, 20));
		documents.setFont(new Font("Arial", Font.PLAIN, 20));
		comperesed.setFont(new Font("Arial", Font.PLAIN, 20));
		language.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		this.add(language);
		this.add(comperesed);
		this.add(documents);
		this.add(music);
		this.add(program);
		this.add(video);
		
		
		this.setBorder(emptyBorder);
		
		SpringLayout layout=new SpringLayout();
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, language, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, language, 1, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, comperesed, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, comperesed, 1, SpringLayout.SOUTH, language);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, documents, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, documents, 1, SpringLayout.SOUTH,comperesed );
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, music, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, music, 1, SpringLayout.SOUTH, documents);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, program, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, program, 1, SpringLayout.SOUTH, music);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, video, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, video, 1, SpringLayout.SOUTH, program);	
		
		language.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (AddNewDownload.persian==true)
				{
					AddNewDownload.persian=false;
					language.setText("language");
					comperesed.setText("comperesed");
					music.setText("music");
					video.setText("vidoe");
					program.setText("program");
					documents.setText("document");
				}
				else
				{
					AddNewDownload.persian=true;
					language.setText("زبان");
					comperesed.setText("فشرده");
					documents.setText("اسناد");
					music.setText("اهنگ");
					video.setText("فیلم");
					program.setText("برنامه");
				}
				SwingUtilities.updateComponentTreeUI(Frame.frame);
				
			}
		});
		this.setBackground(Color.BLACK);
		this.setLayout(layout);
	}
}
