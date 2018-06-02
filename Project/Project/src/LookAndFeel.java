import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import java.util.ArrayList;
/**
 * setting of look and feel
 * @author dannydani
 *
 */
public class LookAndFeel {
	JFrame frame;
	JPanel panelText;
	JPanel panelButton;
	JPanel totalPanel;
	JLabel textOfLookAndFeel;
	JRadioButton[] button;
	ArrayList<String> lookandfeelclass;
	ArrayList<String> lookandfeelname;
	ButtonGroup group;
	/**
	 * consturcotr for lookandfeel
	 */
	public LookAndFeel()
	{
		frame=new JFrame("Look And Feel");
		lookandfeelclass=new ArrayList<>();
		lookandfeelname=new ArrayList<>();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 700));
		textOfLookAndFeel=new JLabel("Please choose one of Feel and Look");
			
		totalPanel=new JPanel();
		panelText=new JPanel();
		panelButton=new JPanel();

		panelText.add(textOfLookAndFeel);
		
		
		
		
		
		try
		{
			for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
			{
				System.out.println(info.getClassName());
				lookandfeelclass.add(info.getClassName());
				lookandfeelname.add(info.getName());
			}
		}
		catch(Exception e)
		{
			
		}
		button=new JRadioButton[lookandfeelname.size()];
		button[0]=new JRadioButton(lookandfeelname.get(0),true);
		for(int i=1 ; i<lookandfeelname.size() ; i++)
		{
			button[i]=new JRadioButton(lookandfeelname.get(i),false);
		}
		group=new ButtonGroup();
		for(int i=0 ; i<lookandfeelname.size() ; i++)
		{
			panelButton.add(button[i]);
		}
		for(int i=0 ; i<lookandfeelname.size() ; i++)
		{
			group.add(button[i]);
		}
		for(int i=0 ; i<lookandfeelname.size() ; i++)
		{
			button[i].addItemListener(new HandlerClass(lookandfeelclass.get(i)));
		}
		
		
		
		
		
		
		SpringLayout layout=new SpringLayout();
		SpringLayout layout2=new SpringLayout();
		
		panelText.setLayout(layout2);
		panelButton.setLayout(new FlowLayout());
		totalPanel.setLayout(layout);
		
		layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, textOfLookAndFeel, 0, SpringLayout.HORIZONTAL_CENTER, panelText);
		layout2.putConstraint(SpringLayout.NORTH, textOfLookAndFeel, 5, SpringLayout.NORTH, panelText);
		
		totalPanel.add(panelText);
		totalPanel.add(panelButton);
		
		layout.putConstraint(SpringLayout.WEST, panelText, 5, SpringLayout.WEST, totalPanel);
		layout.putConstraint(SpringLayout.NORTH, panelText, 5, SpringLayout.NORTH, totalPanel);
		layout.putConstraint(SpringLayout.EAST, panelText, -5, SpringLayout.EAST, totalPanel);
		
	
		layout.putConstraint(SpringLayout.NORTH, panelButton, 5, SpringLayout.SOUTH, panelText);
		panelText.setPreferredSize(new Dimension(0, 50));
		
		
		layout.putConstraint(SpringLayout.WEST, panelButton, 5, SpringLayout.WEST, totalPanel);
		layout.putConstraint(SpringLayout.EAST, panelButton, -5, SpringLayout.EAST, totalPanel);
		layout.putConstraint(SpringLayout.SOUTH, panelButton, -5, SpringLayout.SOUTH, totalPanel);
		

		
		frame.add(totalPanel);
		frame.pack();
		
	}
	/**
	 * show the frame of look and feel
	 */
	public void show()
	{
		frame.setVisible(true);
	}
	/**
	 * item listener for look and feel
	 * @author dannydani
	 *
	 */
	private class  HandlerClass implements ItemListener
	{
		private String name;
		public HandlerClass(String name)
		{
			this.name=name;
		}
		public  void 	itemStateChanged(ItemEvent event) {
				try {
					System.out.println("nnnnnnnnnnnnnnnnnnnnnn="+name);
					UIManager.setLookAndFeel(name);
					SwingUtilities.updateComponentTreeUI(Frame.frame);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
		
		}
	}
	
	
}
