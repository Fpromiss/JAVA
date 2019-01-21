package Graph;

import java.awt.Graphics;
//begin class Rectangle and the class extends Graph
public class Rectangle extends Graph{
	private int width;//for rectangle width
	private int height;//for rectangle height
	
	//begin method Rectangle
	Rectangle(){
		super();
		width=0;
		height=0;
	}//end method Rectangle
	
	//begin method set_x
	public void set_x(int w){
		width=w;
	}//end method set_x
	
	//begin method set_y
	public void set_y(int h){
		height=h;
	}//end method set_y
	
	//begin method get_X
	public int get_x(){
		return width;
	}//end method get_X
	
	//begin method get_y
	public int get_y(){
		return height;
	}//end method get_y
	
	//draw rectangle
	public void draw(Graphics g){
	    g.drawRect(this.get_xlocation(),this.get_ylocation(), this.get_x(), this.get_y());
	}//end method draw
	
}//end class Rectangle
