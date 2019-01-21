package One;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//begin class GUI
public class GUI extends JFrame{
	private static final long serialVersionUID = 8106531172649338445L;
	private JPanel panel[]=new JPanel[5];//five panel
	private JLabel temp[]=new JLabel[4];//four _temp label to fill 
	
	private JCheckBox Snop_to_Crid;
	private JCheckBox Show_Crid;
	
	private JLabel x;
	private JLabel y;
	
	private JTextField x_input;
	private JTextField y_input;
	
	private JButton OK;
	private JButton Cancel;
	private JButton Help;
	
	/*
	 *_jfame 中加入三个_jpanel ：panel0 panel3 panel4
	 *panel0放置：Snop_to_Crid;Show_Crid;
	 *panel1放置：JLabel x;JLabel y;
	 *panel2放置：JTextField x_input;JTextField y_input;
	 *panel3放置：panel1 ,panel2
	 */
	//begin method
	public GUI(){
		super("Align");//title
		
		panel[0]=new JPanel();//panel 0 ,放置两个_checkbox
		panel[0].setLayout(new GridLayout(4,1,5,10));//grid 布局
		temp[0]=new JLabel();//fill label 
		panel[0].add(temp[0]);//add to panel 0
		Snop_to_Crid=new JCheckBox("Snop to Crid");//create JCheckBox 
		panel[0].add(Snop_to_Crid);//add 
		Show_Crid=new JCheckBox("Show Crid");//create JCheckBox 
		panel[0].add(Show_Crid);//add
		
		panel[1]=new JPanel();//panel 1 放置两个label x y
		panel[1].setLayout(new GridLayout(4,1,10,20));//grid 布局
		temp[1]=new JLabel();//fill label
		panel[1].add(temp[1]);//add
		x=new JLabel("         X:");//create JLabel
		panel[1].add(x);//add
		y=new JLabel("         Y:");//create JLabel
		panel[1].add(y);//add		
		
		panel[2]=new JPanel();//panel2 放置两个_textfiled
		panel[2].setLayout(new GridLayout(4,1,10,20));//grid 布局
		temp[2]=new JLabel();//fill label
		panel[2].add(temp[2]);	//add
		x_input=new JTextField(8);//create JTextField
		x_input.setText("8");//set _init text
		panel[2].add(x_input);//add
		y_input=new JTextField(8);//create JTextField
		y_input.setText("8");//set _init text
		panel[2].add(y_input);//add
		
		panel[4]=new JPanel();//panel 4  放置panel1 and panel2 
		panel[4].setLayout(new GridLayout(1,2,10,20));//grid 布局
		panel[4].add(panel[1]);//add
		panel[4].add(panel[2]);//add
		
		panel[3]=new JPanel();//panel 3 放置三个button
		panel[3].setLayout(new GridLayout(5,1,5,10));//grid 布局
		temp[3]=new JLabel();//fill label
		panel[3].add(temp[3]);//add
		OK=new JButton("OK");//create JButton
		panel[3].add(OK);//add
		Cancel=new JButton("Cancel");//create JButton
		panel[3].add(Cancel);//add
		Help=new JButton("Help");//create JButton
		panel[3].add(Help);//add
		
		this.setLayout(new GridLayout(1,4,10,20));//_jfame 布局
		add(panel[0]);//add 
		add(panel[4]);//add
		add(panel[3]);//add
		
	}//end method
	
}//end class GUI
