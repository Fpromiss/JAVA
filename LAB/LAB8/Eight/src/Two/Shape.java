package Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

//begin class Shape
public class Shape {
	public static ShapePanel panel;//画布panel
	public static LayoutPanel l_panel ;//功能按钮panel
	public static JFrame window;//主体
	//begin method main
	public static void main(String[] args)
	{
		window=new JFrame("Java 2D Drawings");//title
		window.setLocation(300,200);//set location
		window.setSize(800,400);//set size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		panel = new ShapePanel();//create ShapePanel
		panel.setPreferredSize(new Dimension(0,300));//设置动态大小
		window.add(panel,BorderLayout.CENTER);//布局 局中
		
		l_panel = new LayoutPanel();//create LayoutPanel
		window.add(l_panel,BorderLayout.NORTH);//设置布局 北
			
		MouseHandler handler=new MouseHandler();//listen mouse
		window.addMouseListener(handler);
		window.addMouseMotionListener(handler);//add listen and react	
		window.setVisible(true);//set visible
	}//end method 
}//end class
