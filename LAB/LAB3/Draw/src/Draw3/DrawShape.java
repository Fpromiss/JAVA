package Draw3;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class DrawShape extends JPanel{

   public void paintComponent(Graphics g){
	   MyRandom mrand=new MyRandom();//创建random对象
	
	   super.paintComponent(g);
	   
	   int weight=getWidth();//获取窗口的宽度
	   int height=getHeight();//获取窗口的高度
	   //进入十次循环 画是个图形
	   for(int i=0;i<10;i++){
		   int r_number=mrand.Draw_Rec_Or_Oval();//r_number存随机数返回值 用于判断是画矩形还是椭圆
		   //通过i的顺序不同  设置不同的颜色去填充图形
		   if(i%5==0)
			   g.setColor(Color.CYAN);
		   else if(i%4==0)
			   g.setColor(Color.magenta);
		   else if(i%3==0)
			   g.setColor(Color.PINK);
		   else if(i%2==0)
			   g.setColor(Color.red);
		   else 
			   g.setColor(Color.YELLOW);
		   //num_数组 用于获取图形的坐标x、 y和大小参数 
		   int num[]=new int[4];
		   num[0]=mrand.My_Location_Random(weight);
	       num[1]=mrand.My_Location_Random(height);
	       num[2]=mrand.My_Size_Random(weight/2);
	       num[3]=mrand.My_Size_Random(height/2);
	       if(num[0]+num[2]>weight){//如果图形画出来会超过窗口
	    	   --i;//次数减一 
	    	   continue;//重新进入循环
	       }
	       if(num[1]+num[3]>height){//如果图形画出来会超过窗口
	    	   --i;//次数减一 
	    	   continue;//重新进入循环
	       }
	    	   
		   if(r_number==1){//如果r_number==1 画矩形
		       g.fillRect(num[0], num[1], num[2], num[3]);
		   }
		   else{//如果r_number==0 画椭圆
			   g.fillOval(num[0], num[1], num[2], num[3]);
		   }	   
	   }
   }
   
   
   
	
}
