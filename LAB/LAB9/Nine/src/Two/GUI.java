package Two;

import java.awt.FlowLayout;
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
	private JLabel user;
     private JLabel password;
     private JLabel email;
     
     private JTextField user_input;
     private JTextField pass_input;
     private JTextField email_input;
     
     private JButton sureButton;
     private JButton cancalButton;
     
     //begin method
     GUI(){
    	 super("Login");//title
    	 init_Button();//create button and add to JFrame
    	 
    	 LoginListener loginfield=new LoginListener();//listen action
 		 sureButton.addActionListener(loginfield);//listen sure button
 		 cancalButton.addActionListener(loginfield);//listen cancel button
     }//end method
     
     //begin method
     private void init_Button(){
    	 
    	 user=new JLabel("User:");//create JLabel object user
    	 add(user);//add
    	 user_input=new JTextField(15);//create JTextField object user_input
    	 add(user_input);//add
    	 
    	 password=new JLabel("Pass:");//create JLabel object pass
    	 add(password);//add
    	 pass_input=new JTextField(15);//create JTextField object pass_input
    	 add(pass_input);//add
    	 
    	 email=new JLabel("Email:");//create JLabel object email
         add(email);//add
    	 email_input=new JTextField(15);//create JTextField object email_input
    	 add(email_input);//add
  
         this.setLayout(new FlowLayout());//set layout style
   
    	 sureButton=new JButton("确定");//create JButton object sureButton
    	 add(sureButton);//add
    	 cancalButton=new JButton("取消");//create JButton object cancalButoton
    	 add(cancalButton);//add
     }//end method
     
     //begin private class LoginListener and implements ActionListener
     private class LoginListener implements ActionListener{
    		public void actionPerformed(ActionEvent event){
    			String user="";//string to get user name
    			String pass="";//string to get password
    			String email="";//string to get email
    			String result="";//string to set result
    			
    			if(event.getSource()==sureButton){//if is the sure button
    				user=user_input.getText();//get input user name
    				pass=pass_input.getText();//get input password
                    email=email_input.getText();//get input email
                    Result ret=new Result();//create Result object
    				result=ret.get_Result(user, pass, email);//get result
    			}
    			else if(event.getSource()==cancalButton){//if is the cancel button
    				System.exit(0);//close
    			}			
    			JOptionPane.showMessageDialog(null,result);//out result
    			user_input.setText("");//reset user_input
    			pass_input.setText("");//reset pass_input
    			email_input.setText("");//reset email_input
    		}//end method actionPerformed
    	}//end class LoginField
}//end class GUI


