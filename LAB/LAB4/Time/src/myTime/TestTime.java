package myTime;

import java.util.Calendar;
import java.util.Scanner;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Increace inc=new Increace();
         Scanner scan=new Scanner(System.in);
         Calendar cal = Calendar.getInstance();
         System.out.print("请输入初始小时：");
         String temp=scan.nextLine();
         int hour=Integer.parseInt(temp);
         System.out.print("请输入初始分钟：");
         temp=scan.nextLine();
         int minute=Integer.parseInt(temp);
         System.out.print("请输入初始秒钟：");
         temp=scan.nextLine();
         int second=Integer.parseInt(temp);
         Time now_time=new Time(hour,minute,second);
         System.out.println("现在时间是："+now_time.toString());
         System.out.print("增加一秒钟后时间是：");
         Time now_time1=new Time(inc.incrementSecond(now_time));
         System.out.println(now_time1.toUniversalString());
         System.out.println(now_time1.toString());
         System.out.print("增加一分钟后时间是：");
         Time now_time2=new Time(inc.incrementMinute(now_time));
         System.out.println(now_time2.toUniversalString());
         System.out.println(now_time2.toString());
         System.out.print("增加一小时后时间是：");
         Time now_time3=new Time(inc.incrementHour(now_time));
         System.out.println(now_time3.toUniversalString());
         System.out.println(now_time3.toString());
	}

}
