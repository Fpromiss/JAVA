package Graph;

import java.awt.Graphics;

//begin class Graph
public abstract class Graph {
   public int x_location;//x location 
   public int y_location;//y location
   
   //begin method Graph
   Graph(){
	   x_location=0;
	   y_location=0;
   }//end method Graph
   
   //begin method setX_location
   public void setX_location(int x){
	   x_location=x;
   }//end method setX_location
   
   //begin method setY_location
   public void setY_location(int y){
	   y_location=y;
   }//end method setY_location
   
   //begin method get_xlocation
   public int get_xlocation(){
	   return x_location;
   }//begin method get_xlocation
   
   //begin method get_ylocation
   public int get_ylocation(){
	   return y_location;
   }//end method get_ylocation
   
   //abstract method 
   public abstract void set_x(int x);
   public abstract void set_y(int y);
   public abstract int get_x();
   public abstract int get_y();
   public abstract void draw(Graphics g);
}//end class Graph
