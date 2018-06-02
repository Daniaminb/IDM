import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
/**
 * Heading panel
 * @author dannydani
 *
 */
public class Heading extends JPanel{
	JLabel name;
	JButton all;
	JButton incomplete;
	JButton complete;
	/**
	 * constructor of heading
	 */
	public Heading()
	{
		if (AddNewDownload.persian==false)
		{name=new JLabel("JVM2018");
		all=new JButton("All");
		incomplete=new JButton("Incomplete");
		complete=new JButton("Complete");}
		else
		{
			name=new JLabel("دانلود منیجر");
			all=new JButton("همه");
			incomplete=new JButton("بایان نیافته");
			complete=new JButton("بایان یافته");
		}
		
		name.setPreferredSize(new Dimension(160,30 ));
		name.setFont(new Font("Arial", Font.PLAIN, 30));
		name.setForeground(Color.cyan);
		name.setBackground(Color.GRAY);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		
		all.setPreferredSize(new Dimension(100,40 ));
		all.setForeground(Color.white);
		all.setBackground(Color.GRAY);
		all.setFont(new Font("Arial", Font.ITALIC, 17));
		all	.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		complete.setPreferredSize(new Dimension(130,40 ));
		complete.setForeground(Color.white);
		complete.setBackground(Color.GRAY);
		complete.setFont(new Font("Arial", Font.ITALIC, 17));
		complete.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		incomplete.setPreferredSize(new Dimension(130,40 ));
		incomplete.setForeground(Color.white);
		incomplete.setBackground(Color.GRAY);
		incomplete.setFont(new Font("Arial", Font.ITALIC, 17));
		incomplete.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		all.setBorder(emptyBorder);
		incomplete.setBorder(emptyBorder);
		complete.setBorder(emptyBorder);
		name.setBorder(emptyBorder);
		
		this.add(all);
		this.add(complete);
		this.add(incomplete);
		this.add(name);
		
		
		
		SpringLayout layout=new SpringLayout();
		
		layout.putConstraint(SpringLayout.WEST, name, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, name, 20, SpringLayout.NORTH, this);
		
		
		layout.putConstraint(SpringLayout.EAST, complete, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, complete, 0, SpringLayout.SOUTH, name);
		
		layout.putConstraint(SpringLayout.EAST, incomplete, -5, SpringLayout.WEST, complete);
		layout.putConstraint(SpringLayout.NORTH, incomplete, 0, SpringLayout.SOUTH, name);
		
		layout.putConstraint(SpringLayout.EAST, all, -5, SpringLayout.WEST, incomplete);
		layout.putConstraint(SpringLayout.NORTH, all, 0, SpringLayout.SOUTH, name);
		
		
		this.setLayout(layout);
		this.setBackground(Color.GRAY);
		
	}
	
	

}
