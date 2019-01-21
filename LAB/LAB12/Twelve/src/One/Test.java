package One;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          MySlider myslider =new MySlider();//create object _myslider
          myslider.setTitle("MySlider");//set title
          myslider.setBounds(100, 100, 500, 300);//set size and location
          myslider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          myslider.setVisible(true);
	}//end main method
}//end class
