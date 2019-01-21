package Graph;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//begin class DrawShape extends JPanel
public class DrawShape extends JPanel{
    //begin method paintComponent
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setVisible(true);//可视化
		setLayout(null);//output 
	}//end method paintComponent
	
	//begin method drawSomething
    public void drawSomething(){
    	myRandom rand=new myRandom();//create myRandom object
        int number[]=new int[21];//for 20 times draw graph	
    	int para[]=new int[4];//for get parameter
		
    	//begin for circle 20 times
        for(int i=1;i<=20;++i){
    		int width=getWidth();//get windows width
    		int height=getHeight();//get windows height
        	number[i]=rand.myrand();//create random number
        	System.out.println("i:"+i+" "+number[i]);//print for verify
        	Graph graph = null;//to create the father object
        	String location=new String();//the string get the input parameter
        	if(number[i]==0){//if it will draw line
        		graph=new Line();//change to child object line
        	    location=JOptionPane.showInputDialog("请输入线段两端坐标参数(坐标范围 x:0~"+width+" y:0~"+height);//windows output
        	}
        	else if(number[i]==1){//if it will draw rectangle
                graph=new Rectangle();//change to child object rectangle 
        		location=JOptionPane.showInputDialog("请输入矩形坐标参数和大小参数(参数范围 x:0~"+width+" y:0~"+height);//windows output
        	}
        	else if(number[i]==2){//if it will draw _elipse
        		graph=new Elipse();//change to child object _Elipse
        		location=JOptionPane.showInputDialog("请输入椭圆坐标参数和大小参数(参数范围 x:0~"+width+" y:0~"+height);//windows output
        	}
 	        String[] parts = location.trim().split("\\s+");//divide the input string by "\\s+"
 	        if(parts.length==4){//if the parts length is 4
 	        	int flag=1;//the flag for input number 
 	        	for(int j=0;j<4;++j){
 	        		para[j]=Integer.parseInt(parts[j]);//string to integer
 	        		if(j==0||j==2){
 	        			if(para[j]<0||para[j]>width){//if not in the range
 	        				JOptionPane.showMessageDialog(null,"输入错误,请重新输入");//窗口错误输出
 	        				flag=0;//output the error and flag=0
 	        				break;//end circle
 	        			}
 	        		}
 	        		else if(j==1||j==3){
 	        			if(para[j]<0||para[j]>height){//if not in the range
 	        				JOptionPane.showMessageDialog(null,"输入错误,请重新输入");//窗口错误输出
 	        				flag=0;//output the error and flag=0
 	        				break;//end circle
 	        			}
 	        		}
 	        	}
 	        	if(flag==0){//if the flag=0 , the input is wrong ,continue to input
 	        		flag=1;
 	        		continue;
 	        	}
 	        	//else the input is right,set the parameter
 	        	graph.setX_location(para[0]);
 	        	graph.setY_location(para[1]);
 	        	graph.set_x(para[2]);
 	        	graph.set_y(para[3]);
 	            //draw the graph
 	        	Graphics g=getGraphics();
 	        	graph.draw(g);
 	        }
 	        else{//if the parts length is not 4
 	        	JOptionPane.showMessageDialog(null,"输入错误");//windows output
 	        }
        }//end for circle
    }//end method drawSomething
}//end class DrawShape
