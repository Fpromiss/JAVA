package One;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI gui=new GUI();//create GUI object
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.setLocation(100,100);//set location
		gui.setSize(320, 220);//set frame size
		gui.setVisible(true);//display frame
		
        GUI2 gui2=new GUI2();//create GUI2 object
        gui2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui2.setLocation(600,100);//set location
		gui2.setSize(260, 240);//set frame size
		gui2.setVisible(true);//display frame
		
		GUI3 gui3=new GUI3();//create GUI3 object
	    gui3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui3.setLocation(100,400);//set location
		gui3.setSize(240, 160);//set frame size
		gui3.setVisible(true);//display frame
	
		GUI4 gui4=new GUI4();//create GUI4 object
	    gui4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui4.setLocation(600,400);//set location
		gui4.setSize(410, 240);//set frame size
		gui4.setVisible(true);//display frame
		
	}//end method main
}//end class Test
