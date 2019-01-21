package One;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

//begin class GUI4
public class GUI4 extends JFrame{  
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 3432230301650449523L;
	 private JPanel []panel=new JPanel[9];
	 private JLabel []label=new JLabel[2];
	 
	 private JLabel myprinter;
	 private JLabel quailty;
	 
	 private JCheckBox image;
	 private JCheckBox text;
	 private JCheckBox code;
	 private JCheckBox print_to_file;
	 
	 private JRadioButton Selection;
	 private JRadioButton All;
	 private JRadioButton Applet;
	 
	 @SuppressWarnings("rawtypes")
	 private JComboBox level;
	 String levels[]={
		"HIGH","MIDDLE","LOW"	 
	 };//level choose for level
	 
	 private JButton ok;
	 private JButton cancel;
	 private JButton setup;
	 private JButton help;
	 
	 private JTextArea textarea1;
	 private JTextArea textarea2;
	 private JTextArea textarea3;
	
	 /*
	  * 一共使用了9个panel
	  * JFrame 加入三个panel ：panel[3], panel[7], panel[8],采用Border布局
	  * 
	  * panel[3] 加入：JLabel：myprinter ，panel[2]， JLabel : _quailty，采用grid布局
	  * panel[2] 加入：text filed：textarea1 ， panel[1]，采用grid布局
	  * panel[1] 加入：JCheckBox：Image,JCheckBox:text,JCheckBox:code ,采用grid布局
	  * 
	  * panel[7] 加入：JLabel : label[0],JPanel:panel[5],JPanel:panel[6],采用grid布局
	  * panel[5] 加入：JTextField:textarea2,JPanel:panel[4],JTextField:textarea3,采用Border布局
	  * panel[6] 加入：ComboBox：level ,JCheckBox :print_to_file,采用flow布局
	  * panel[4] 加入： JRadioButton：Selection, JRadioButton：ALL, JRadioButton：Applet,采用Grid布局
	  * 
	  * panel[8] 加入：JButton:OK,JButton:Cancel,JButton:help,JButton:setup,采用Grid布局
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 //begin method GUI4
	public GUI4(){
		 super("Printer");//title:Printer
		 
		 panel[1]=new JPanel();//panel[1]
		 panel[1].setLayout(new GridLayout(3,1,5,5));//panel[1] grid布局
		 image=new JCheckBox("Image");//create JCheckBox object
		 panel[1].add(image);//add
		 text=new JCheckBox("text");//create JCheckBox object
		 panel[1].add(text);//add
		 code=new JCheckBox("Code");//create JCheckBox object
		 panel[1].add(code);//add
		 
		 panel[2]=new JPanel();//panel[2]
		 panel[2].setLayout(new GridLayout(1,2,5,5));//panel[2] grid布局
		 textarea1=new JTextArea(15,5);//create JTextArea object
		 panel[2].add(textarea1);//add
		 panel[2].add(panel[1]);//add
		 
		 
		 panel[3]=new JPanel();//panel[3]
		 panel[3].setLayout(new GridLayout(3,1,5,5));//grid布局
		 myprinter=new JLabel ("   Printer.MyPrinter");//create JLabel object
		 panel[3].add(myprinter);//add
		 panel[3].add(panel[2]);//add
		 quailty=new JLabel("   Print Quality");//create JLabel object
		 panel[3].add(quailty);//add
		 
		 panel[4]=new JPanel();//panel[4]
		 panel[4].setLayout(new GridLayout(3,1,5,15));//grid布局
		 Selection=new JRadioButton("Selection");//create JRadioButton object
		 panel[4].add(Selection);//add
	     All=new JRadioButton("All",true);//create JRadioButton object
		 panel[4].add(All);//add
		 Applet=new JRadioButton("Applet");//create JRadioButton object
		 panel[4].add(Applet);//add
		 
		 panel[5]=new JPanel();//panel[5]
		 panel[5].setLayout(new BorderLayout());//border布局
		 textarea2=new JTextArea(5,5);//create JTextArea object
		 textarea3=new JTextArea(5,5);//create JTextArea object
		 panel[5].add(textarea2,BorderLayout.WEST);//add
		 panel[5].add(panel[4],BorderLayout.CENTER);//add
		 panel[5].add(textarea3,BorderLayout.EAST);//add
		 
		 panel[6]=new JPanel();//panel[6]
		 panel[6].setLayout(new FlowLayout());//flow 布局
		 level=new JComboBox(levels);//create JComboBox object
		 level.setMaximumRowCount(3);//row 
		 print_to_file=new JCheckBox("Print to File");//create JCheckBox object
		 panel[6].add(level);//add
		 panel[6].add(print_to_file);//add

		 
		 panel[7]=new JPanel();//panel[7]
		 panel[7].setLayout(new GridLayout(3,1,5,5));//grid布局
		 label[0]=new JLabel();//label[0]
		 panel[7].add(label[0]);//add
		 panel[7].add(panel[5]);//add
		 panel[7].add(panel[6]);//add
		
		 	
		 panel[8]=new JPanel();//panel[8]
		 panel[8].setLayout(new GridLayout(6,1,10,10));//panel[8] grid布局
		 label[1]=new JLabel();//label[1]
		 panel[8].add(label[1]);//add
		 ok=new JButton("OK");//create JButton object
		 panel[8].add(ok);//add
		 cancel=new JButton("Cancel");//create JButton object
		 panel[8].add(cancel);//add
		 setup=new JButton("Setup...");//create JButton object
		 panel[8].add(setup);//add
		 help=new JButton("Help");//create JButton object
		 panel[8].add(help);//add
		 	 
		 
		 setLayout(new BorderLayout());//JFrame ,border 布局
		 add(panel[3],BorderLayout.WEST);//add
		 add(panel[7],BorderLayout.CENTER);//add
		 add(panel[8],BorderLayout.EAST);//add
		 	 
	 }//end method
}//end class 
