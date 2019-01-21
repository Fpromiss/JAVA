package Turtle;

public class Array {
	private int format_X=0;//format x location 
	private int format_Y=0;//format y location
	private int direction=2;//format direction
	private int opp_direction=12;
    int array[][]=new int[20][20];//map array 
    Array(){
    	//set begin array value 0
    	for(int i=0;i<20;++i){
    		for(int j=0;j<20;++j){
    			array[i][j]=0;
    		}
    	}
    }//end method Array
    
    //set one array[x][y] value and change format location
    public void set(int x,int y){
    	array[x][y]=1;
    	format_X=x;//change format x location
    	format_Y=y;//change format y location
    }//end method set
    
    //set format direction
    public void setDirection(int dir){
    	direction=dir;
    }//end method setDirection
    
    //begin method setOppDirection
    public void setOppDirection(int dir){
    	opp_direction=dir;
    }//end method setOppDirection
    
    //get format direction
    public int getDirection(){
    	return direction;
    }//end method getDirection
    
    //get x location
    public int getXlocation(){
    	return format_X;
    }//end method getXlocation
    
    //get y location
    public int getYlocation(){
    	return format_Y;
    }//end method getYlocation
    
    //begin method getOppDirection
    public int getOppDirection(){
    	return opp_direction;
    }//end method getOppDirection
    
    //display the array ,if value =1 out ‘*’ else out ' '
    public void displayArray(){
    	for(int i=0;i<20;++i){
    		for(int j=0;j<20;++j){
    			if(array[i][j]==1)
    				System.out.print("* ");
    			else if(array[i][j]==0)
    				System.out.print("  ");
    		}
    		System.out.print("\n");//one line by 20
    	}
    }//end method displayArray;
}
