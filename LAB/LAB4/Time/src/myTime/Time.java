package myTime;

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    public Time(){
    	this(0,0,0);
    }
    
    public Time(int h){
    	this(h,0,0);
    }
    
    public Time(int h,int m){
    	this(h,m,0);
    }
    
    public Time(int h,int m,int s){
    	this.setTime(h,m,s);  	
    }
    
    public Time(Time time){
    	this(time.getHour(),time.getMinute(),time.getSecond());
    }
    
    public void setTime(int h,int m,int s){
        this.setHour(h);
    	this.setMinute(m);
    	this.setSecond(s);
    }
    
    public void setHour(int h){
    	if(h<24&&h>=0)
        	hour=h;
    	else 
    		 throw new IllegalArgumentException( "hour must be 0-23" ); 
    }
    
    public void setMinute(int m){
    	if(m>=0&&m<60)
    	     minute=m;
    	else 
    		 throw new IllegalArgumentException( "minute must be 0-59" ); 
    }
    
    public void setSecond(int s){
    	if(s>=0&&s<60)
    		 second = ( ( s >= 0 && s <60 )?s:0 );
    	else
    		 throw new IllegalArgumentException( "second must be 0-59" ); 
    }
    
    public int getHour(){
    	return hour; 
    } 
    
    public int getMinute(){
    	return minute;
    }
    
    public int getSecond(){
    	return second;
    }
    
    public String toUniversalString(){
    	 return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond() ); 
    }
    
    public String toString(){
         return String.format( "%d:%02d:%02d %s", ( (getHour() == 0 || getHour() == 12)?12 : getHour() % 12 ),getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
    }
}
