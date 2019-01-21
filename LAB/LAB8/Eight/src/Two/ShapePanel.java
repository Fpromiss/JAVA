package Two;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
//begin class ShapePanel
public class ShapePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//begin method 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.white);//设置背景颜色
	}//end method
}//end class
