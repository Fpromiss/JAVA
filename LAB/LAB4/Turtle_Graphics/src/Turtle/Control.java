package Turtle;
//begin class Control
public class Control {
    //create Array object
    public Array array=new Array();
    //begin method move
    //use four number 1 to 4 for the direction 
    //1 is for up , 2 is for right , 3 is for down, 4 is for left
    public void move(int distance){
    	//System.out.printf("distance %d  ",distance);
    	int now_direction=array.getDirection();//get now direction
    	int x_location=array.getXlocation();//get now x_location
    	int y_location=array.getYlocation();//get now y_location
    	//System.out.printf("%d %d %d\n",now_direction,x_location,y_location);
    	if(now_direction==1){//if now direction is up
    		for(int i=1;i<=distance;++i){//move distance
    			--x_location;
    			//System.out.printf("%d  ",x_location);
    			array.set(x_location, y_location);//set array number 1
    		}
    	}
    	else if(now_direction==2){//if now direction is right
    		for(int i=1;i<=distance;++i){//move distance
    			++y_location;
    			//System.out.printf("%d  ",y_location);
    			array.set(x_location,y_location);//set array number 1
    		}
    	}
    	else if(now_direction==3){//if now direction is down
    		for(int i=1;i<=distance;++i){//move distance
    			++x_location;
    			//System.out.printf("%d  ",x_location);
    			array.set(x_location,y_location);//set array number 1
    		}
    	}
    	else if(now_direction==4){//if now direction is left
    		for(int i=1;i<=distance;i++){//move distance
    			--y_location;
    			//System.out.printf("%d  ",y_location);
    			array.set(x_location,y_location);//set array number 1
    		}
    	}
    }//end method move
    
    //begin method moveOpposite
    //first get opposite direction 
    //and change the array by direction and distance
    public void moveOpposite(int distance){
    	int now_opposite_direction=array.getOppDirection();//get now direction
    	int x_location=array.getXlocation();//get now x_location
    	int y_location=array.getYlocation();//get now y_location
    	if(now_opposite_direction==11){//if direction is between 1 and 2
    		for(int i=1;i<=distance;++i){
    			--x_location;
    			++y_location;
    			array.set(x_location, y_location);
    		}
    	}
    	else if(now_opposite_direction==12){//if direction is between 2 and 3
    		for(int i=1;i<=distance;++i){
    			++x_location;
    			++y_location;
    			array.set(x_location, y_location);
    		}
    	}
    	else if(now_opposite_direction==13){//if direction is between 3 and 4
    		for(int i=1;i<=distance;++i){
    			++x_location;
    			--y_location;
    			array.set(x_location, y_location);
    		}
    	}
    	else if(now_opposite_direction==14){//if direction is between 4 and 1
    		for(int i=1;i<=distance;++i){
    			--x_location;
    			--y_location;
    			array.set(x_location, y_location);
    		}
    	}
    }
    
    
    //begin method changeDirection
    //the method is used to change the format direction
    public void changeDirection(int dir){
    	int now_direction=array.getDirection();
    	if(dir==3){//if turn right
    		now_direction=(now_direction+1)%4;
    		if(now_direction==0)
    			now_direction=4;
    		array.setDirection(now_direction);//set now direction
    	}
    	else if(dir==4){//if turn left
    		now_direction=now_direction-1;
    		if(now_direction==0)
    			now_direction=4;
    		array.setDirection(now_direction);//set now direction
    	}
    }//end method changDirection
    
    //begin method changeOppDirection
    //change the opposite direction
    //11 is between 1 and 2 ,12 is between 2 and 3, 13 is between 3 and 4,14 is between 4 and 1;
    //if dir_=7 turn right opposite;
    //if dir_=8 turn left opposite;
    public void changeOppDirection(int dir){
    	int opp_direciton=array.getOppDirection();
    	if(dir==7){//right opposite direction
    		opp_direciton=(opp_direciton+1)%15;//turn right opp_direciton+1
    		if(opp_direciton==0)
    			opp_direciton=11;
    		array.setOppDirection(opp_direciton);//set now opposite direction
    	}
    	else if(dir==8){
    		opp_direciton=opp_direciton-1;//turn left opposite ,opp_direciton-1
    		if(opp_direciton==10){
    			opp_direciton=14;
    		}
    		array.setOppDirection(opp_direciton);//set now opposite direction
    	}	
    }//end method changeOppDirection
    
    //begin method pen_down
    //pen down is mean set x position and y position 0
    public void pen_down(){
    	array.set(0,0);
    }//end method pen_down;
    //display the array
    
    public void display(){
    	array.displayArray();
    }//end method display;
    
	
}
