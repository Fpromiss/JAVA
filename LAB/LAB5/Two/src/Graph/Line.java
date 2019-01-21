package Graph;

import java.awt.Graphics;
//begin class Line and the class extends Graph
public class Line extends Graph{
    private int x_end_location;//for end point x location
    private int y_end_location;//for end point y location
    
    //begin method Line
    Line(){
    	super();
    	x_end_location=0;
    	y_end_location=0;
    }//end method Line
    
    //begin method set_X
    public void set_x(int x){
    	x_end_location=x;
    }//end method set_x
    
    //begin method set_y
    public void set_y(int y){
    	y_end_location=y;
    }//end method set_y
    
    //begin method get_x
    public int get_x(){
    	return x_end_location;
    }//end method get_x
    
    //begin method get_y
    public int get_y(){
    	return y_end_location;
    }//end method get_y
    
    //draw line
    public void draw(Graphics g){
    	g.drawLine(this.get_xlocation(),this.get_ylocation(), this.get_x(), this.get_y());
    }//end method draw line
}//end class Line
