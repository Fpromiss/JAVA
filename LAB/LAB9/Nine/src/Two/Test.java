package Two;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String args []){
		GUI gui=new GUI();//create GUI object
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.setLocation(500,100);//set location
		gui.setSize(240, 180);//set frame size
		gui.setVisible(true);//display frame
	}//end method main
}//end class Test
