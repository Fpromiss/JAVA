package Two;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

//类：Shape ,图形父类
public abstract class Shape {
     String name;//图形名称
   
     Point p1;//点p1
     Point p2;//点p2
	 
	 int lineW = 1;//线条宽度默认值为1
	 boolean fill = false;//是否填充 ，默认不填充
	 boolean grd = false;//是否渐变 ，默认不渐变
	 Color c1 = Color.BLACK;//颜色1 ，默认颜色为黑色
	 Color c2 = Color.GRAY;//颜色2，默认颜色为灰色
	 
	 //方法：getLineW(),获取线条宽度
	public int getLineW() {
		return lineW;
	}//结束方法
		
	//方法：setLineW(lineW),设置线条宽度
	public void setLineW(int lineW) {
		this.lineW = lineW;
	}//结束方法
	
	//方法：isFill(),获取是否填充
	public boolean isFill() {
		return fill;
	}//结束方法

	//方法：setFill(boolean fill),设置fill值
	public void setFill(boolean fill) {
		this.fill = fill;
	}//结束方法

	//方法：isGrd(),获取渐变
	public boolean isGrd() {
		return grd;
	}//结束方法

	//方法：setGrd(boolean grd),设置grd的值
	public void setGrd(boolean grd) {
		this.grd = grd;
	}//结束方法

	//方法：getName(),获取图形名称
	public String getName() {
		return name;
	}//结束方法

	//方法：setName(String name),设置图形名称
	public void setName(String name) {
		this.name = name;
	}//结束方法
	
	//方法：getPoint1(),获取点p1
	public Point getPoint1() {
		return p1;
	}//结束方法
	
	//方法：setPoint1(Point point1),设置点p1的值
	public void setPoint1(Point point1) {
		this.p1 = point1;
	}//结束方法

	//方法：getPoint2(),获取点p2
	public Point getPoint2() {
		return p2;
	}//结束方法
		
	//方法：setPoint2(Point point2),设置点p2的值
	public void setPoint2(Point point2) {
		this.p2 = point2;
	}//结束方法
	
	//抽象方法：drawShape(Graphics g),画图形
    public abstract void drawShape(Graphics g);
}//结束类：Shape图形类
   

