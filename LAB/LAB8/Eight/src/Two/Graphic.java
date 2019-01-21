package Two;

import java.awt.*;
import java.awt.Graphics;
//begin class Graphic
public class Graphic {
	//参数
	String shape="line";//图形形状 默认为直线
	int[] posi=new int[4];//坐标参数
	Color this_c1;//颜色1
	Color this_c2;//颜色2
	boolean is_grad;//是否渐变
	boolean is_filled;//是否填充
	boolean is_dash;//是否虚线
	int line_w;//线条宽度
	int dash_l;//虚线长度
		
	//构造函数
	public Graphic()
	{
	}//end
	
	//begin draw 
	public void draw()
	{
		Graphics g=Shape.panel.getGraphics();//get g
		Graphics2D g2d=(Graphics2D)g;//change to java 2D	
		if(is_grad){//如果设置了渐变
			g2d.setPaint(new GradientPaint(0,0,this_c1,100,80,this_c2,true));//画渐变
		}
		else //如果没有设置渐变
		{
			g2d.setPaint(this_c1);//画图形
		}
		float[] dashes={10,dash_l};//虚线默认值 10 ，输入的虚线长度值
		g2d.setStroke(new BasicStroke(line_w,
				BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,
				10,dashes,0));//设置虚线
		if(is_filled)//是否填充
		{
			//如果画矩形
			if( shape.equals("Rectangle"))
				//进行数据比较，保证以左上顶点作为参数
			g.fillRect(posi[0]<posi[2]?posi[0]:posi[2],
					 posi[1]< posi[3]? posi[1]: posi[3],
					 posi[2]< posi[0]? posi[0]- posi[2]: posi[2]- posi[0],
					 posi[1]< posi[3]? posi[3]- posi[1]: posi[1]- posi[3]);
			else 
				if( shape.equals("Oval"))//如果画圆	
					//进行数据比较，保证以左上顶点作为参数
				g.fillOval( posi[0]< posi[2]? posi[0]: posi[2],
						 posi[1]< posi[3]? posi[1]: posi[3],
						 posi[2]< posi[0]? posi[0]- posi[2]: posi[2]- posi[0],
						 posi[1]< posi[3]? posi[3]- posi[1]: posi[1]- posi[3]);
				
			else//如果画直线
				g.drawLine( posi[0], posi[1], posi[2], posi[3]);
		}
		else//如果没有填充
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
		 Shape.l_panel.get_info(this);
	}//end method
}//end class