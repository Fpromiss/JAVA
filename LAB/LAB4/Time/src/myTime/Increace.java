package myTime;

public class Increace {
	public Time incrementSecond(Time now_time){
		int second=now_time.getSecond();
		int minute=now_time.getMinute();
		int hour=now_time.getHour();
		Time temp_time=new Time();
		second=second+1;
		if(second>59){
			minute=minute+1;
			if(minute>59){
				hour=hour+1;
				if(hour>23){
					temp_time.setTime(0, 0, 0);
				}
				else{
					temp_time.setTime(hour, 0, 0);
				}
			}
			else{
                 temp_time.setTime(hour, minute, 0);
			}
		}
		else{
			temp_time.setTime(hour, minute, second);
		}
		return temp_time;		
	}
	
    public Time incrementMinute(Time now_time){
    	int second=now_time.getSecond();
    	int minute=now_time.getMinute();
    	int hour=now_time.getHour();
    	Time temp_time=new Time();
    	minute=minute+1;
    	if(minute>=0&&minute<60){
    		temp_time.setTime(hour, minute, second);
    	}
    	else{
    		hour=hour+1;
    		if(hour>=0&&hour<24){
                  temp_time.setTime(hour, 0, second);
    		}
    		else{
                temp_time.setTime(0, 0, second);
    		}
    	}
    	return temp_time;
    }
    
    public Time incrementHour(Time now_time){
    	int hour=now_time.getHour();
    	Time temp_time=new Time(now_time);
    	hour=hour+1;
    	if(hour>=0&&hour<24){
    		temp_time.setHour(hour);
    	}
    	else{
    		temp_time.setHour(0);
    	}
    	return temp_time;
    }
    
   
}
