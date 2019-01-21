package One;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//begin class MyPanel
public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text;//输入文本
	private JLabel value;//标签
	private int jvalue=10;//slider 值
	private String svalue="";//slider 值 to String
	private JButton sure;//确定
	
	//begin method
	MyPanel(){
		text=new JTextField(8);//create text
		text.setText("20");//set text value :"20"
		value=new JLabel("Slider-value");//create slider
		sure=new JButton("确定");//create sure button
		add(value);//add
		add(text);//add
		add(sure);//add
		
		sureListener surelister=new sureListener();//create sureListener
		sure.addActionListener(surelister);//listen to sure button
	}//end method
	
	//begin method 
	//通过修改slider ，text的值变
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		jvalue=MySlider.slider.getValue();//获取slider值
		svalue=Integer.toString(jvalue);//to string
		text.setText(svalue);//设置文本框值	
	}//end method
	
	//监听 button ,通过text 中 input 值 ，改变slider
	private class sureListener implements ActionListener{
	    private String input_s;
	    private int input_value;
   		public void actionPerformed(ActionEvent event){
   			if(event.getSource()==sure){//如果点击确定按钮
   				input_s=text.getText();//获取输入文本
   				input_value=Integer.parseInt(input_s);//to _int
   				if(input_value>=0 && input_value<=50){//范围判断 在0-50
   					MySlider.slider.setValue(input_value);//改变slider
   				}
   				else{//不在范围之内，报错
   					JOptionPane.showMessageDialog(null,"输入的值应该处于0-50之间","输入错误",JOptionPane.ERROR_MESSAGE);
   				}
   			}
   		}//end method actionPerformed
	}//end class sureListener
}//end class MyPanel
