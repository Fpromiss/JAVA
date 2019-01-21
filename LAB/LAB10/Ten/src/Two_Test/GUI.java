package Two_Test;

import java.awt.BorderLayout;
import javax.swing.JFrame;

//begin class GUI
public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ChoosePanel north;//the choose panel for shape and color
	public static ShapePanel south;//the draw place
	
	//begin method
	GUI(){
           
		north=new ChoosePanel();//create ChoosePanel object
		south=new ShapePanel();//create ShapePanel object
		
		this.setLayout(new BorderLayout());//set JFrame layout
		this.add(north,BorderLayout.NORTH);//add to JFrame
		this.add(south,BorderLayout.CENTER);//add to JFrame
		
		MouseHandler handler=new MouseHandler();//listen mouse
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);//add listen and react	
	}//end method
}//end class
