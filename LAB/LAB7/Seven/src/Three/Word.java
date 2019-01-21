package Three;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//begin class Word
public class Word extends JPanel{
	private String word[]={
			"hello","word","world","mysql","php",
			"java","cola","Test","login","system",
			"public","private","game","lucky","miss"
	};//the strings for word 
	ArrayList<String> list=new ArrayList<String>();//the list for string
	private int key_word=0;//the sub for string array
	private int count_number=15;//the count number for string array
	
	private JLabel text=new JLabel();//the label for string output
	private JLabel your_input=new JLabel("你的输入：");//the label for "你的输出"
	
	private JTextField input=new JTextField(10);//the JTextField for input
	
	private JButton sureButton=new JButton("确定");//the sure button
    
	//begin method paintComponent
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setVisible(true);//可视化
		setLayout(null);//output 
	}//end method paintComponent
		
	//begin method input_deal
	public void input_deal(){
			myRandom rand=new myRandom();//create myRandom object
			key_word=rand.getRandomNum(count_number);//get random number for sub
			String out_text="随机单词："+word[key_word];//get random string
			text.setText(out_text);//set text for text label
			text.setBounds(90, 30, 150, 20);//set text label size and location
			add(text);//add
								
			your_input.setBounds(90, 50, 70, 40);//set your_input label size and location
			add(your_input);//add
			
			sureButton.setBounds(160, 100, 70, 20);//set sure button size and location
			add(sureButton);//add
			
			input.setBounds(160, 60, 70, 30);//set JTextFiled input size and location 
			add(input);//add
					
			SureField surefield=new SureField();//listen action
			sureButton.addActionListener(surefield);//listen sure button

	}
	
	//begin class LoginField
	private class SureField implements ActionListener{
		//begin method actionPerformed
		public void actionPerformed(ActionEvent event){
			String input_string=" ";
			
			if(event.getSource()==sureButton){//if is the sure button
		          input_string=input.getText();//get input string
		          String mylist=list.get(key_word);//get sub list string 
		          if(input_string.equals(mylist)){//if input_string is equal to mylist string
		  			list.remove(mylist);//remove _mylist string from list
		  			if(list.size()==0){//if the list is empty
		  				JOptionPane.showMessageDialog(null,"单词表已空！");//output
		  				System.exit(0);//end system
		  			}
		  			//display();
		  			--count_number;//count all number -1
		  			System.out.println(input_string);//print _mylist to console 
		  			JOptionPane.showMessageDialog(null,"输入匹配！");//out result
		  		}
		         else{//if the input_string is not equal to _mylist string
		  			JOptionPane.showMessageDialog(null,"输入不匹配！");//out result
		  		}
			}
			else {//if is the cancel button
				System.exit(0);//close
			}			
			myRandom rand=new myRandom();//create myRandom object
  			key_word=rand.getRandomNum(count_number);//get random number
			String out_text="随机单词："+list.get(key_word);//get random string
			text.setText(out_text);//set text label 's text
  			input.setText("");//set input JTextField's text

		}//end method actionPerformed
	}//end class LoginField

	//begin method setArrayList
	public void setArrayList(){
		for(int i=0;i<15;i++){
			list.add(word[i]);
		}
	}//end method
	
	/*public void display(){
		System.out.println("list:");
	    for(int i=0;i<list.size();++i){
	    	System.out.println(list.get(i));
	    }
	}*/
	
}//end class Word
