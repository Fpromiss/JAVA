package Three;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//begin class GUI
public class GUI extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel quhao;
    private JLabel tel;
    
    private JButton sure;
    private JButton cancel;
    private JButton clear;
	
    private JLabel label;
    private JTextField input;
    
    //begin method
	GUI(){
		super("tel");//title
		init_button();//_inti button
		
		LoginListener loginfield=new LoginListener();//listen action
 		sure.addActionListener(loginfield);//listen sure button
 		cancel.addActionListener(loginfield);//listen cancel button
 		clear.addActionListener(loginfield);//listen clear button
	}
	
	//begin method 
	public void init_button(){
		this.setLayout(null);//layout style
		
		label=new JLabel("输入：");//create JLabel object label
		label.setBounds(40, 10, 40, 30);//set location and size
		add(label);//add
		input=new JTextField(15);//create JTextField input
		input.setBounds(80, 10, 100, 30);//set location and size
		add(input);//add
		
		quhao=new JLabel("区号： ");//create JLabel object _quhao
		quhao.setBounds(40, 40, 120, 30);//set location and size
		add(quhao);//add
		tel=new JLabel("号码：");//create JLabel object _tel
		tel.setBounds(40, 70, 120, 30);//set location and size
		add(tel);//add
		
		sure=new JButton("确定");//create JButton object sure
		sure.setBounds(10, 100, 65, 30);//set location and size
		add(sure);//add
		clear=new JButton("清空");//create JButton object cancel
		clear.setBounds(80, 100, 65, 30);//set location and size
		add(clear);//add
		cancel=new JButton("取消");//create JButton object clear
		cancel.setBounds(150, 100, 65, 30);//set location and size
		add(cancel);//add
	}//end method
	
	  //begin private class LoginListener and implements ActionListener
    private class LoginListener implements ActionListener{
   		public void actionPerformed(ActionEvent event){
   			String str="";//get input
   			String temp1="";//get _quhao
   			String temp2="";//get _tel
   			if(event.getSource()==sure){//if is the sure button
   				str=input.getText();//get input 
   				if(str.isEmpty()){//if input is empty
   					JOptionPane.showMessageDialog(null,"输入不能为空！");//out error
   				}
   				else{//if input is not empty
   					String[] parts = str.trim().split("\\s+");//划分字符串 根据空格+
   					if(parts.length>2||parts.length<1){//if parts length >2 or <1
   						JOptionPane.showMessageDialog(null,"输入格式错误！");//out error
   						input.setText(" ");//reset input
   					}
   					else if(parts.length==2){//if the parts length is 2
   						if(parts[0].startsWith("(")&&parts[0].endsWith(")")){//the _quhao
   							temp1=parts[0].substring(1,parts[0].length()-1);//get _quhao
   						}
   						else {//if not suit the _quhao
   							JOptionPane.showMessageDialog(null,"区号输入格式错误！");//out error
   							input.setText(" ");//reset input
   						}
   						String[] part1 = parts[1].trim().split("\\-");//the _tel divide by '-'
   						if(part1.length!=2){//if not divide into two part
   							JOptionPane.showMessageDialog(null,"电话输入格式错误！");//out error
   							input.setText(" ");//reset input
   						}
   						else{//if the part1 divide into two part
   							temp2=part1[0]+part1[1];//get _tel
   							quhao.setText("区号："+temp1);//set _quhao
   	   						tel.setText("电话："+temp2);//set _tel
   						}
   					}//end parts length equal to 2
   					else if(parts.length==1){//if input length is 1
   						int flag=1;//if flag =1 ,out error 
   						//if  the input parts contains '(' ,')' , and '-'
   						if(parts[0].contains("-")&&parts[0].contains("(")&&parts[0].contains(")")){
   							String[] part1 = parts[0].trim().split("\\-");//divide by '-'
   							if(part1.length==2){//if parts divide into two part
   								String[] part2 = part1[0].trim().split("\\)");//divide by ')'
   								if(part2.length==2){//if part1 divide into two part
   									temp2=part2[1]+part1[1];//get _tel
   									if(part2[0].startsWith("(")){//if part2[0] start with '('
   										temp1=part2[0].substring(1);//get _quhao
   										flag=0;//flag=0 ,should not out error
   									}
   								}
   							}
   						}
   						if(flag==1){//if flag==1
   							JOptionPane.showMessageDialog(null,"输入格式错误！");//out error
   	   						input.setText(" ");//reset input
   						}
   						else if(flag==0){//if flag==0
   							flag=1;//reset flag
   							quhao.setText("区号："+temp1);//out _quhao
   	   						tel.setText("电话："+temp2);//out _tel
   						}
   					}
   				}
   			}//end sure perform
   			else if(event.getSource()==cancel){//if is the cancel button
   				System.exit(0);//close
   			}//end cancel perform
   			else if(event.getSource()==clear){
   				input.setText(" ");
   				quhao.setText("区号：");
				tel.setText("电话：");
   			}//end clear perform
   			
   		}//end method actionPerformed
   	}//end class LoginField
}//end class GUI
