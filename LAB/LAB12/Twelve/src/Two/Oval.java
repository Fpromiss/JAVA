package Two;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

//类：Oval,继承父类：Shape
public class Oval extends Shape{
   	  
	//无参构造函数
	Oval(){
		this(new Point(0,0),new Point(0,0));
	}//结束方法
	
	//构造函数：设置线条宽度、是否填充、是否渐变、颜色1、颜色2
	Oval(int lineW,boolean fill,boolean grd,Color c1,Color c2){
	   this(new Point(0,0),new Point(0,0));//新椭圆
	   setLineW(lineW);//设置线条宽度
	   setFill(fill);//设置填充
       setGrd(grd);//设置渐变
	   this.c1 =c1;//设置颜色1
	   this.c2 = c2;//设置颜色2
	}//结束方法
	
	//构造函数：设置p1、p2
	Oval(Point p1,Point p2){
		setPoint1(p1);//设置p1
		setPoint2(p2);//设置p2
	}//结束方法
	
	//方法:drawShape(Graphics g)，画椭圆
	public void drawShape(Graphics g){
		 g = (Graphics2D)g;	
         ((Graphics2D) g).setStroke(new BasicStroke(lineW));//设置线条宽度
		 
         //如果渐变
		 if(grd){
		 GradientPaint paint = new GradientPaint(p1,c1,p2,c2);
		 ((Graphics2D)g).setPaint(paint);//设置渐变
		 }
		 else g.setColor(c1);//如果没有渐变，就使用颜色1
		 
		 //如果没有填充
		 if(!fill){ 
			 if(p2.x!=0&&p2.y!=0){
				  if(p1.x<p2.x && p1.y<p2.y)
					   g.drawOval(p1.x,p1.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
		          else if(p2.x<p1.x && p2.y<p1.y)
		         	 g.drawOval(p2.x,p2.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
		          else if(p1.x<p2.x && p2.y<p1.y)
		         	 g.drawOval(p1.x,p2.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
		          else if(p2.x<p1.x && p1.y<p2.y)
		         	 g.drawOval(p2.x,p1.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y)); 	 
			 }
		}
		 //如果填充了
		 else {
			 if(p2.x!=0&&p2.y!=0){
				  if(p1.x<p2.x && p1.y<p2.y)
			    		 g.fillOval(p1.x,p1.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
			          else if(p2.x<p1.x && p2.y<p1.y)
				     	 g.fillOval(p2.x,p2.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
			          else if(p1.x<p2.x && p2.y<p1.y)
			         	 g.fillOval(p1.x,p2.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));
			          else if(p2.x<p1.x && p1.y<p2.y)
				    	 g.fillOval(p2.x,p1.y,Math.abs(p1.x-p2.x),Math.abs(p1.y-p2.y));				 
			 }	   
		  }
	  }//结束方法
}//结束类：Oval

