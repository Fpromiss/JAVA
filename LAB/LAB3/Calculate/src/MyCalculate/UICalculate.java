package MyCalculate;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UICalculate extends JFrame{
	//运算数字button 0-9
	private JButton calculateButton[]={
			new JButton("0"),new JButton("1"),new JButton("2"),
			new JButton("3"),new JButton("4"),new JButton("5"),
			new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")
	};
	//运算符button 删除一个输入AC + - *  . / % = 清空按钮
	private JButton symbolButton[]={
		new JButton("AC"),new JButton("+"),new JButton("-"),new JButton("*"),
		new JButton("."),new JButton("/"),new JButton("%"),new JButton("="),
		new JButton("清空")
	};
	//输入框字符串
	private String inputString=new String("");
	//输出框字符串
	private String outputString=new String("");
	//输入框和输出框
	private JTextField inputjtext=new JTextField();
	private JTextField outputjtext=new JTextField();
	//构造函数
   public UICalculate(){
	   this.setTitle("我的计算器！！！");//设置标题
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setSize(400,300);//设置大小
	   this.setLayout(null);
	   this.setVisible(true);//设置输出
	   
	   setCalculateButton();//设置数字按钮
	   setSymbolButton();//设置运算符按钮
	   
	   setInputText();//设置输入框
	   setResultText();//设置输出框
	   
	   listenNumButton();//监听数字按钮
	   listenSymbolButton();//监听运算符按钮
   }
   //创建数字按钮
   void setCalculateButton(){
	   int sx=100;//设置数字按钮大的初始x坐标
	   int sy=60;//设置数字按钮大的初始y坐标
	   for(int i=1;i<10;++i){//依次设置0-9 10个按钮
		   calculateButton[i].setBounds(sx, sy, 50, 25);//设置数字按钮的坐标和大小
		   sx=sx+60;//每次横坐标水平移动60
		   if(i%3==0){//每三个一行
			   sx=100;
			   sy=sy+40;
		   }
		   this.add(calculateButton[i]);//添加进入容器
	   }
	   calculateButton[0].setBounds(100, 180, 110, 25);
	   this.add(calculateButton[0]);//单独设置0按钮
   }
   //创建操作符和等号按钮
   void setSymbolButton(){
	   int sx=280;//设置运算符按钮大的初始x坐标
	   int sy=60;//设置运算符按钮大的初始y坐标
	   for(int i=0;i<6;++i){
		   symbolButton[i].setBounds(sx, sy, 50, 25);//设置运算符按钮的位置和大小
		   this.add(symbolButton[i]);//添加进入容器
		   if(i==3||i==5){//为了设置 .和* %和/ 处于同一行
			   sx=220;
			   symbolButton[i+1].setBounds(sx,sy,50,25);
			   this.add(symbolButton[i+1]);
			   ++i;
			   sx=280;
		   }
		   sy=sy+40;
	   }
	   //等号按钮
	   symbolButton[7].setBounds(100,220,110,25);
	   this.add(symbolButton[7]);
	   //清空按钮
	   symbolButton[8].setBounds(10,10,80,40);
	   this.add(symbolButton[8]);
   }
   //创建输入框
   void setInputText(){
	   inputjtext.setBounds(100,10,170,40);//设置输入框的位置和大小
	   this.add(inputjtext);//加入容器
	   inputjtext.setText("0");//设置输入框的text
   }
   //创建结果框
   void setResultText(){
	   outputjtext.setBounds(280,10,50,40);//设置输出框的位置和大小
	   this.add(outputjtext);//加入容器
	   outputjtext.setText("0");//设置输出框的text
   }
   //监听数字按钮 如果按下按钮 输入框内增加对应数字
   void listenNumButton(){
	   //监听0按钮
	   calculateButton[0].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[0].getLabel();//输入字符加入0
		          inputjtext.setText(inputString);//输入框内输出
			  }
		  });
	   //监听1按钮
	   calculateButton[1].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[1].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听2按钮
	   calculateButton[2].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[2].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听3按钮
	   calculateButton[3].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[3].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听4按钮
	   calculateButton[4].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[4].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听5按钮
	   calculateButton[5].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[5].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	  //监听6按钮
	   calculateButton[6].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[6].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听7按钮
	   calculateButton[7].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[7].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听8按钮
	   calculateButton[8].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[8].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	   //监听9按钮
	   calculateButton[9].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+calculateButton[9].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
   }
   //监听操作符按钮
   void listenSymbolButton(){
	   //监听AC按钮 如果输入框有字符 则可以删除一个 否则点击无效
	   symbolButton[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int len=inputString.length()-1;//获取输入框的字串  字符个数少1
				if(len>=0){//如果子串有字符
					 inputString=inputString.substring(0, len);//替换输入框内的字符串
			         inputjtext.setText(inputString);//更新
				}
			  }
		  });
	   //监听+按钮 如果按下 输入框内加入+
	   symbolButton[1].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[1].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听-按钮 如果按下 输入框内加入-
	   symbolButton[2].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[2].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听*按钮 如果按下 输入框内加入*
	   symbolButton[3].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[3].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听.按钮 如果按下 输入框内加入.
	   symbolButton[4].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[4].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听/按钮 如果按下 输入框内加入/
	   symbolButton[5].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[5].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听%按钮 如果按下 输入框内加入%
	   symbolButton[6].addActionListener(new ActionListener(){
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				  inputString=inputString+symbolButton[6].getLabel();
		          inputjtext.setText(inputString);
			  }
		  });
	 //监听=按钮 如果按下按钮 把输入框内的字符串进行运算 得到结果 替换原来输出框内的字符串
	   symbolButton[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				  CalculateNumber cal=new CalculateNumber();
				  double answer=cal.myCalculateNumber(inputString);
				  if(answer==-123456789.0){//错误判断
					  outputString="wrong";					  
				  }

				  else{//替换字符串
					  outputString=String.valueOf(answer);
				  }
		          outputjtext.setText(outputString);//更新输出框
			  }
		  });
	   //监听清空按钮 如果按下 把输入框和输出框内的内容清空
	   symbolButton[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                  inputString="";
                  inputjtext.setText(inputString);
                  outputString="0";
                  outputjtext.setText(outputString);
			  }
		  });
	   
   }
}
