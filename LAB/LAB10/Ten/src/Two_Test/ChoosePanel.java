package Two_Test;

import Two.MyHashMap;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JPanel;
//begin class ChoosePanel 
public class ChoosePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> mycolor;//choose for color
	private JComboBox<String> shape;//choose for shape
	private MyHashMap mymap;//hash map
	
	private String keys[]=new String[]{
		    "blue","red","white","black","orange",
		   	"pink","yellow","green","cyan","magenta",
		   	"light_gray","dark_gray","gray"
		    };
		
		String myShape[]=new String[]{
			"line","Rectangle","Oval"	
		};
		
		//begin method
		ChoosePanel(){
			mymap=new MyHashMap();//create MyHashMap object
			shape=new JComboBox<String>(myShape);//create JComboBox object
			mycolor=new JComboBox<String>(keys);//create JComboBox object
			this.add(shape);//add to choosePanel
			this.add(mycolor);//add to choosePanel
			this.setLayout(new FlowLayout());//set  choosePanel layout
		}//end method
		
		//begin method
		public void get_info(Graphic temp){
			temp.shape=(String) shape.getSelectedItem();//get select shape
			temp.myColor=(String)mycolor.getSelectedItem();//get select color name
			temp.c1=mymap.map.get(temp.myColor);//get color
		}//end method
		
		//begin method
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
		}//end method 
}//end class
