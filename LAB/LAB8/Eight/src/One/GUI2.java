package One;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//begin class GUI2
public class GUI2 extends JFrame{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField input;
     
     private JPanel panel;
     
     private JButton temp=new JButton();
     
     private JButton button[]={
    		 temp,temp,temp,temp,
    		 temp,temp,temp,temp,
    		 temp,temp,temp,temp,
    		 temp,temp,temp,temp
     };
     
     private String label[]={
    	"7","8","9","/",
    	"4","5","6","*",
    	"1","2","3","-",
    	"0",".","=","+"
     };
     
     /*
      * JFrame 放置一个text field 和 一个panel
      * panel里按 grid布局放置16个button
      */
     //begin method
     GUI2(){
    	super("Calculator");//title:Calculator
    	//setResizable(false);//can not change size
    	
 		panel=new JPanel(new GridLayout(4,4,10,10));//create JPanel and set _layoout
 		
 	    setLayout(new BorderLayout());  //set JFrame layout
 		
 		//count 16, create JButton and add to JPanel
 		for(int i=0;i<16;++i){
 			button[i]=new JButton(label[i]);
 			panel.add(button[i]);
 		}
   
 		input=new JTextField(20);//create JTextField and _inti text length 20
 		add(input,BorderLayout.NORTH);//set layout and add to JFrame
 		
 		add(panel);//add panel to JFrame 		
     }//end method
}//end class
