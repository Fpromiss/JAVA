package One;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//begin class Login
public class Login extends JFrame{
    private JLabel username;//label for user name
	private JLabel password;//label for password
	
	private JTextField input_username;//text field for input user name
	private JTextField input_password;//text field for input password
	
	private JButton sureButton;//sure button
	private JButton cancelButton;//cancel button
	
	//begin Login
	public Login(){
		super("登陆");//title 
		setResizable(false);//can not change size
		setLayout(new FlowLayout());//the style Layout
		//setLayout(null);
		
		username=new JLabel("用户名:");//create user name label
		add(username);//add user name 
		
		input_username=new JTextField(15);//create input user name filed
		add(input_username);//add
		 
		password=new JLabel("密    码:");//create password label
		add(password);//add
		 
		input_password=new JTextField(15);//create input password filed
		add(input_password);//add
		
		sureButton=new JButton("确定");//create sure button
		add(sureButton);//add
		
		cancelButton=new JButton("取消");//create cancel button
		add(cancelButton);//add
		
		LoginField loginfield=new LoginField();//listen action
		sureButton.addActionListener(loginfield);//listen sure button
		cancelButton.addActionListener(loginfield);//listen cancel button
	}//end method
    
	//begin class LoginField
	private class LoginField implements ActionListener{
		//begin method actionPerformed
		public void actionPerformed(ActionEvent event){
			String user="";//string to get user name
			String pass="";//string to get password
			String result="";//string to set result
			
			if(event.getSource()==sureButton){//if is the sure button
				user=input_username.getText();//get input user name
				pass=input_password.getText();//get input password
				Verify verify=new Verify();//create verify object
				result=verify.VerifyLogin(user, pass);//get result
			}
			else if(event.getSource()==cancelButton){//if is the cancel button
				System.exit(0);//close
			}			
			JOptionPane.showMessageDialog(null,result);//out result
			input_username.setText("");
			input_password.setText("");
		}//end method actionPerformed
	}//end class LoginField

}//end class Login
