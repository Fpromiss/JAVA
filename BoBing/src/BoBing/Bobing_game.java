package BoBing;

import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Bobing_game extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4991942409510781872L;
	public JLabel temp=new JLabel();//一个用于初始化的temp_label
	public JLabel temp_label[][]={
			{temp,temp,temp,temp,temp,temp},
			{temp,temp,temp,temp,temp,temp},
			{temp,temp,temp,temp,temp,temp},
			{temp,temp,temp,temp,temp,temp},
			{temp,temp,temp,temp,temp,temp},
			{temp,temp,temp,temp,temp,temp},
	};//每一个骰子图片对应的label 一共6*6 36个
	public String jiangli[]={
			" "," "," "," "," "," ",
	};//存放奖励信息的数组 长度为6
	public JLabel jiang[]={new JLabel("来啊！博饼啊，反正有大把时光~"),
			new JLabel("来啊！博饼啊，反正有大把时光~"),
			new JLabel("来啊！博饼啊，反正有大把时光~"),
			new JLabel("来啊！博饼啊，反正有大把时光~"),
			new JLabel("来啊！博饼啊，反正有大把时光~"),
			new JLabel("来啊！博饼啊，反正有大把时光~")
	  };//奖励信息的label 长度为6
	int flag=0;//计算reward时候 标记只需要Add 进入容器中6次 否则会出现错误
	int flag2=0;//测试数据时候 用于标记是否输入的六个数字满足1~6 满足则调用reward函数 不满足就不调用
	private JButton sureButton;//开始游戏的button
	private JButton closeButton;//关闭游戏的button
	private JButton testButton;//测试数据的button
	//构造函数
	public Bobing_game() {
		  this.setTitle("欢迎来到博饼游戏！！！");//JFrame 窗体的title
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setBounds(0, 0, 1000,700);//设置位置参数、大小参数
          
		  ImageIcon img = new ImageIcon("3.gif");//加载3.gif_图片
		  JLabel bgLabel = new JLabel(img);//把image加入到label中得到加载
		  this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));//add 到容器中
		  bgLabel.setBounds(0,0,400,300);//设置gif_图片位置、大小参数
		  this.setLayout(null);
		  ((JPanel)getContentPane()).setOpaque(false);
		  setVisible(true);//可视化
		  
		  //创建开始游戏button
	      sureButton = new JButton("开始游戏！！");//创建
	      sureButton.setBounds(30, 350, 100, 25);//设置开始游戏按钮的位置、大小参数
	      this.add(sureButton);//把button添加到容器
	      
	      //创建关闭游戏button
	      closeButton = new JButton("关闭游戏！！");//创建
	      closeButton.setBounds(30,400,100,25);//设置关闭游戏按钮的位置、大小参数
	      this.add(closeButton);//把button添加到容器
	      
	      //创建测试数据button
	      testButton = new JButton("测试数据！！");//创建
	      testButton.setBounds(30,450,100,25);//设置关闭游戏按钮的位置、大小参数
	      this.add(testButton);//把button添加到容器
	      
	      this.load_touzi();//加载6*6 36个骰子
	      
	      sureButton.addActionListener(new ActionListener()//添加对开始游戏button的监视
			{
				public void actionPerformed(ActionEvent e){//点击button后
					 int num[][]=new int[6][6];//六组随机数
				      Random rand=new Random();//生产随机数对象
				      for(int i=0;i<6;++i)
				      {
				    	  for(int j=0;j<6;j++)
				    	  {
				    		  num[i][j]=rand.nextInt(6)+1;//生成1~6的随机数
				    	  }
				      }
					re_load_touzi(num);//重新加载6*6 36个骰子
					answer(num);//给出中奖的label
				}
			});
	      
	      closeButton.addActionListener(new ActionListener()//添加对结束游戏button的监视
			{
				public void actionPerformed(ActionEvent e){//点击button后
					System.exit(0);//关闭窗口
				}
			});
         
	      testButton.addActionListener(new ActionListener()//添加对测试数据button的监视
			{
				public void actionPerformed(ActionEvent e){//点击button后
					test_code();//进行测试
				}
			});
     }
    
	//加载图片函数 用于第一次加载界面中的6*6 36个骰子
	public void load_touzi()
	{
		ImageIcon icon[]=new ImageIcon[6];//加载图片
		int sx=100;//横距离
		int sy=50;//纵距离
		for(int i=0;i<6;++i)
		{
	        for(int j=0;j<6;++j)
		    {
			   icon[j]=new ImageIcon((j+1)+".png");//加载对应初始骰子图片
			   temp_label[i][j]=new JLabel(icon[j]);//创建图片对应label
			   this.getLayeredPane().add(temp_label[i][j], new Integer(Integer.MIN_VALUE));//添加到容器
			   temp_label[i][j].setBounds(sx,sy,600,65);//设置label位置、大小参数
			   sx=sx+100;//迭代横距离
			   this.setLayout(null);//设置输出
			   ((JPanel)getContentPane()).setOpaque(false);		  
		    }
	        sy=sy+100;//重置纵距离
	        sx=100;//重置横距离
		}
		setVisible(true);//可视化
	}
    
	//每次开始游戏后 重新加载对应的骰子图片
	public void re_load_touzi(int num[][])
	{
		ImageIcon icon;//图片对象
		for(int i=0;i<6;++i)//循环遍历外层
		{
			for(int j=0;j<6;++j)//循环遍历内层
			{
				icon=new ImageIcon(num[i][j]+".png");//加载图片
				temp_label[i][j].setIcon(icon);  //更改对应的label
			}
		}   
	}
	
	//计算每次游戏对应的奖励
	public void answer(int num[][])
	{
		int counter_one=0;//the counter number for one
		int counter_two=0;//the counter number for two 
	    int counter_three=0;//the counter number for three
        int counter_four=0;//the counter number for four
        int counter_fifth=0;//the counter number for fifth
        int counter_six=0;//the counter number for six
        int sx=150;//设置奖励输出初始x距离
        int sy=300;//设置奖励输出初始y距离
        //计算一组中1~6的个数
		for(int i=0;i<6;i++)//外层遍历
		{
			for(int j=0;j<6;j++)//内层遍历
			{
				 if(num[i][j]==1)
	        	      ++counter_one;
	        	   else if(num[i][j]==2)
	        		  ++counter_two;
	        	   else if(num[i][j]==3)
	        		  ++counter_three;
	        	   else if(num[i][j]==4)
	        		  ++counter_four;
	        	   else if(num[i][j]==5)
	        		  ++counter_fifth;
	        	   else if(num[i][j]==6)
	        		  ++counter_six;
			}
			//判断结果 
            jiangli[i]=(i+1)+"号玩家：";//奖励信息
            if(counter_one==6)
        	   jiangli[i]=jiangli[i]+"恭喜 您中了遍地锦！";
            else if(counter_two==6||counter_three==6||counter_fifth==6||counter_six==6)
            	jiangli[i]=jiangli[i]+"恭喜 您中了六勃黑！";
            else if(counter_four==6)
            	jiangli[i]=jiangli[i]+"恭喜 您中了六勃红！";
            else if(counter_four==4 && counter_one==2)
            	jiangli[i]=jiangli[i]+"恭喜 您中了状元插金花！";
            else if(counter_four==5)
            	jiangli[i]=jiangli[i]+"恭喜 您中了五王！";
            else if(counter_two==5||counter_three==5||counter_fifth==5||counter_six==5){
            	if(counter_four==1)
            		jiangli[i]=jiangli[i]+"恭喜 您中了五子带一秀！";
            	else
            	    jiangli[i]=jiangli[i]+"恭喜 您中了五子！";
            }
            else if(counter_four==4)
            	jiangli[i]=jiangli[i]+"恭喜 您中了四红！";
            else if(counter_one==1&&counter_two==1&&counter_three==1&&counter_four==1&&counter_fifth==1&&counter_six==1)
            	jiangli[i]=jiangli[i]+"恭喜 您中了对堂！";
            else if(counter_four==3)
            	jiangli[i]=jiangli[i]+"恭喜 您中了三红！";
            else if(counter_one==4||counter_two==4||counter_three==4||counter_fifth==4||counter_six==4){
        	    if(counter_four==2)
        	    	jiangli[i]=jiangli[i]+"恭喜 您中了四进带二举！";
        	    else
        	    	jiangli[i]=jiangli[i]+"恭喜 您中了四进！";
            }
            else if(counter_four==2)
            	jiangli[i]=jiangli[i]+"恭喜 您中了二举！";
            else if(counter_four==1)
            	jiangli[i]=jiangli[i]+"恭喜 您中了一秀！";
            else
            	jiangli[i]=jiangli[i]+"很遗憾 您没中~";	
            
            jiang[i].setText(jiangli[i]);
            if(flag<6){//防止多次add容器 造成奇怪的错误
			    this.getLayeredPane().add(jiang[i], new Integer(Integer.MIN_VALUE));
			    flag++;
            }
			jiang[i].setBounds(sx,sy,600,65);//设置奖励信息的位置
			sy+=50;//迭代纵距离
            //重置计数
            counter_one=0;
    		counter_two=0;
    		counter_three=0;
    		counter_four=0;
    		counter_fifth=0;
    		counter_six=0;
		}
	}
	
	//用于测试数据的reward函数
	public void reward(int num[])
	{
		int counter_one=0;//the counter number for one
		int counter_two=0;//the counter number for two 
	    int counter_three=0;//the counter number for three
        int counter_four=0;//the counter number for four
        int counter_fifth=0;//the counter number for fifth
        int counter_six=0;//the counter number for six
        //遍历计算num_数组中1~6的个数
        for(int i=0;i<6;i++)
        {
        	 if(num[i]==1)
       	      ++counter_one;
       	   else if(num[i]==2)
       		  ++counter_two;
       	   else if(num[i]==3)
       		  ++counter_three;
       	   else if(num[i]==4)
       		  ++counter_four;
       	   else if(num[i]==5)
       		  ++counter_fifth;
       	   else if(num[i]==6)
       		  ++counter_six;
        }
        //根据个数判断获奖情况
        if(counter_one==6)
        	JOptionPane.showMessageDialog(null,"遍地锦！");
         else if(counter_two==6||counter_three==6||counter_fifth==6||counter_six==6)
        	 JOptionPane.showMessageDialog(null,"六勃黑！");
         else if(counter_four==6)
        	 JOptionPane.showMessageDialog(null,"六勃红！");
         else if(counter_four==4 && counter_one==2)
        	 JOptionPane.showMessageDialog(null,"状元插金花！");
         else if(counter_four==5)
        	 JOptionPane.showMessageDialog(null,"五王！");
         else if(counter_two==5||counter_three==5||counter_fifth==5||counter_six==5)
        	 JOptionPane.showMessageDialog(null,"五子！");
         else if(counter_four==4)
        	 JOptionPane.showMessageDialog(null,"四红！");
         else if(counter_one==1&&counter_two==1&&counter_three==1&&counter_four==1&&counter_fifth==1&&counter_six==1)
        	 JOptionPane.showMessageDialog(null,"对堂！");
         else if(counter_four==3)
        	 JOptionPane.showMessageDialog(null,"三红！");
         else if(counter_one==4||counter_two==4||counter_three==4||counter_fifth==4||counter_six==4){
     	    if(counter_four==2)
     	    	JOptionPane.showMessageDialog(null,"四进带二举！");
     	    else
     	    	JOptionPane.showMessageDialog(null,"四进！");
         }
         else if(counter_four==2)
        	 JOptionPane.showMessageDialog(null,"二举！");
         else if(counter_four==1)
        	 JOptionPane.showMessageDialog(null,"一秀！");
         else
        	 JOptionPane.showMessageDialog(null,"很遗憾 没中~");
	}
	
	//测试数据函数
	public void test_code()
	{
		int number[]=new int[6];//测试数据包含6个int_类型的整数
		while(true){//不停输入 直到关闭窗口为止
		   String num=JOptionPane.showInputDialog("请输入测试值：");//窗口输出信息
	       String[] parts = num.trim().split("\\s+");//划分字符串 根据空格+
		   if(parts.length!=6){//如果划分的不是六个
			   JOptionPane.showMessageDialog(null,"输入错误");//窗口输出错误
			   continue;//继续输入
		    }
		    try{
		    	for(int i=0;i<6;++i)//判断得到的六个数字
		    	{
		    		number[i]=Integer.parseInt(parts[i]);//字符转换为数字
		    		if(number[i]==1||number[i]==2||number[i]==3||number[i]==4||number[i]==5||number[i]==6)//如果是1~6的数字
		    			continue;//则可以进入获奖判断
		    		else{//如果不是1~6的数字
		    			JOptionPane.showMessageDialog(null,"输入错误");//窗口错误输出
		    			flag2=1;//并且设置flag2=1
		    			break;//跳出判断
		    		}
		    	}
		    }
		    catch(Exception e){//获得信息
		    	JOptionPane.showMessageDialog(null,"输入错误");//窗口错误输出
				continue;//继续输入
		    }
		    if(flag2==0)//如果flag2==0 说明六个数字符合1~6
		    reward(number);//进行获奖判断
		    else //如果flag2！=0 
		    	flag2=1;//那么不需要进行获奖判断 
		}
	}
	
	//main method
    public static void main(String[] args) {
		 Bobing_game f = new Bobing_game();
	}
}//end class hello
