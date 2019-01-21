package One;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//begin class GUI3
public class GUI3 extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1752031830269271837L;
	private JPanel panel;
	@SuppressWarnings("rawtypes")
	private JComboBox myColors;
	String colors[]={
		"RED","BLUE","PINK","ORANGE"	
	};//colors for choose
	
	private JCheckBox BackGround;
	private JCheckBox ForeGround;
	
	private JButton OK;
	private JButton Cancel;
	
	
	/*
	 * 整体flow布局
	 * 依次加入_combobox ，CheckBox，Button
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//begin method GUI3
	public GUI3(){
		super("ColorSelect");//title
		setLayout(new FlowLayout());//set layout type
		
		myColors=new JComboBox(colors);//create JComboBox object 
		myColors.setMaximumRowCount(4);//set row : 4
		myColors.setMaximumSize(new Dimension(200,20));
		myColors.setMinimumSize(new Dimension(200,20));
		myColors.setPreferredSize(new Dimension(200,20));//set size
		panel = new JPanel();//create JPanel
		panel.add(myColors);//JComboBox add to JPanel
		add(panel);//JPanel add to JFrame
		
		BackGround=new 	JCheckBox("BackGround");//create JCheckBox object 
		add(BackGround);//add
		ForeGround=new JCheckBox("ForeGround");//create JCheckBox object 
		add(ForeGround);//add
		
		OK=new JButton("OK");//create JButton object
		add(OK);//add
		Cancel=new JButton("Cancel");//create JButton object
		add(Cancel);//add
	}//end method
}//end class
