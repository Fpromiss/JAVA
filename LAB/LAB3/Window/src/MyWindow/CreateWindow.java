package MyWindow;

import javax.swing.*;

import java.awt.event.*;

public class CreateWindow extends JFrame{
	private JButton sureButton;//温馨提示button
	private JButton remaindButton;//标题条文字串button
	private JButton chooseButton;//选项对话框标题button
	private JButton inputButton;//输入button
	private JButton enumButton;//input button
    public CreateWindow(){
    	 this.setTitle("创建button！！！");//JFrame 窗体的title
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setBounds(100, 100, 400,300);//设置位置参数、大小参数
		  this.setLayout(null);
		  setVisible(true);//可视化
    	  
		  sureButton =new JButton("1.温馨提示");
		  sureButton.setBounds(120, 20, 150, 25);//设置参数
		  this.add(sureButton);//加入容器
		  
		  remaindButton =new JButton("2.标题条文字串");
		  remaindButton.setBounds(120, 60, 150, 25);//设置参数
		  this.add(remaindButton);//加入容器
		  
		  chooseButton =new JButton("3.选项对话框标题");
		  chooseButton.setBounds(120, 100, 150, 25);//设置参数
		  this.add(chooseButton);//加入容器
		  
		  inputButton =new JButton("4.输入");
		  inputButton.setBounds(120, 140, 150, 25);//设置参数
		  this.add(inputButton);//加入容器
		  
		  enumButton =new JButton("5.input");
		  enumButton.setBounds(120, 180, 150, 25);//设置参数
		  this.add(enumButton);//加入容器
		  //监听温馨提示button
		  sureButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  JOptionPane.showConfirmDialog(null,"确定保存吗？","温馨提示",JOptionPane.OK_CANCEL_OPTION);
			  }
		  });
		  //监听标题条文字串button
		  remaindButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  ImageIcon icon = new ImageIcon("1.png");//覆盖原有的图标的图片
				  JOptionPane.showMessageDialog(null,"在对话框内显示的描述性的文字","标题条文字串",JOptionPane.ERROR_MESSAGE,icon); 
			  }
		  });
		  //监听选项对话框标题button
		  chooseButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  JOptionPane.showConfirmDialog(null, "这是个选项对话框，用户可以选择自己的按钮的个数", "选项对话框标题",JOptionPane.YES_NO_CANCEL_OPTION); 
			  }
		  });
		  //监听输入button
		  inputButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  JOptionPane.showInputDialog(null,"Please input a value!"); 
			  }
		  });
		  //监听input button
		  enumButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  ImageIcon icon2=new ImageIcon("2.png");//覆盖图标图片加载
				  Object[] number= {"first","second","third","forth","fifth"}; //选项
				  JOptionPane.showInputDialog(null,"Choose one","Input",JOptionPane.QUESTION_MESSAGE,icon2,number,number[0]); 
			  }
		  });	
    }//end method CreateWindow
}//end class CreateWindow
