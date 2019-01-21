package One;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login login=new Login();//create Login object
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setSize(260, 150);//set frame size
		login.setVisible(true);//display frame
	}//end main
}//end Test
