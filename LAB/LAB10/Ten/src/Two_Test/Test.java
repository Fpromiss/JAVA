package Two_Test;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GUI application=new GUI();//create GUI object
		application.setSize(500, 300);//set size
		application.setLocation(300, 200);//set location
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);//set visible
	}//end method main
}//end class Test
