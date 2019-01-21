package Three;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui=new GUI();//create GUI object
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.setLocation(500,100);//set location
		gui.setSize(240, 180);//set frame size
		gui.setVisible(true);//display frame
	}//end method
}//end class
