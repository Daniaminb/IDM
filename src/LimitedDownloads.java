import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
/**
 * form of limited download
 * @author paml
 *
 */

public class LimitedDownloads {
	static int limitedDownload=-1;
	JFrame frame;
	JPanel panel;
	JLabel textOfLimitedDownloads;
	TextField text;
	public LimitedDownloads()
	{
		frame=new JFrame("Limited Downloads");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 700));
		textOfLimitedDownloads=new JLabel("Please enter the number of Downloads");
		text=new TextField();
		panel=new JPanel();
		frame.add(panel);
		
		panel.add(textOfLimitedDownloads);
		panel.add(text);

		SpringLayout layout=new SpringLayout();
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textOfLimitedDownloads, 0, SpringLayout.HORIZONTAL_CENTER, panel);
		layout.putConstraint(SpringLayout.NORTH, textOfLimitedDownloads, 5, SpringLayout.NORTH, panel);
		
		layout.putConstraint(SpringLayout.EAST, text, -10, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.WEST, text, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.SOUTH, textOfLimitedDownloads);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (text.getText().isEmpty()!=true)
				{
					limitedDownload=Integer.parseInt(text.getText());
					text.setText(null);
				}
				else
				{
					limitedDownload=-1;
				}
				
			}
		});
		
		panel.setLayout(layout);
		frame.pack();
		
	}
	public void show()
	{
		frame.setVisible(true);
	}
	
	
}
