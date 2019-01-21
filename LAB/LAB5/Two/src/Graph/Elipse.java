package Graph;

import java.awt.Graphics;

//begin class _Elipse and the class extends Graph
public class Elipse extends Graph {
    private int a_length;//a_length for x direction
    private int b_length;//b_length for y direction
    
    //begin method _Elipse
    Elipse(){
    	super();
    	a_length=0;
    	b_length=0;
    }//end method _Elipse
    
    //begin method set_x
    public void set_x(int a){
    	a_length=a;
    }//end method set_x
    
    //begin method set_y
    public void set_y(int b){
    	b_length=b;
    }//end method set_y
    
    //begin method get_x
    public int get_x(){
        return a_length;	
    }//end method get_x
    
    //begin method get_y
    public int get_y(){
    	return b_length;
    }//end method get_y
    
    //draw _elipse
    public void draw(Graphics g){
    	g.drawOval(this.get_xlocation(),this.get_ylocation(), this.get_x(), this.get_y());
    }//end method draw_elipse

}//end class _elipse
