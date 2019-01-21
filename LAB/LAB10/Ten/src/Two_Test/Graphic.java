package Two_Test;

import java.awt.*;
import java.awt.Graphics;
//begin class Graphic
public class Graphic {
	//参数
	String shape="line";//图形形状 默认为直线
	String myColor="black";//颜色名默认为黑色
	Color c1;//颜色
	int[] posi=new int[4];//坐标参数
		
	//构造函数
	public Graphic()
	{
	}//end
	
	//begin draw 
	public void draw()
	{
		Graphics g=GUI.south.getGraphics();//get g
        g.setColor(c1);
			//如果画矩形
		if( shape.equals("Rectangle"))
			//进行数据比较，保证以左上顶点作为参数
		g.drawRect(posi[0]<posi[2]?posi[0]:posi[2],
				 posi[1]< posi[3]? posi[1]: posi[3],
				 posi[2]< posi[0]? posi[0]- posi[2]: posi[2]- posi[0],
				 posi[1]< posi[3]? posi[3]- posi[1]: posi[1]- posi[3]);
		else 
			//如果画圆
			if( shape.equals("Oval"))
				
				//进行数据比较，保证以左上顶点作为参数
			g.drawOval( posi[0]< posi[2]? posi[0]: posi[2],
					 posi[1]< posi[3]? posi[1]: posi[3],
					 posi[2]< posi[0]? posi[0]- posi[2]: posi[2]- posi[0],
					 posi[1]< posi[3]? posi[3]- posi[1]: posi[1]- posi[3]);
			//如果画直线
		else
			g.drawLine( posi[0], posi[1], posi[2], posi[3]);
	}//end method
	
	//设置参数函数
	public void set_posi(int x1,int y1,int x2,int y2)
	{
		//设置鼠标位置和画在画板上的位置一样
		 posi[0]=x1-5;
		 posi[1]=y1-100;
		 posi[2]=x2-5;
		 posi[3]=y2-100;
		 GUI.north.get_info(this);
	}//end method
}//end class
