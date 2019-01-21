package Three;

import javax.swing.JFrame;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word word=new Word();//create Word object
	    JFrame application=new JFrame();//create JFrame
	    application.setTitle("单词表");//set Title
	    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    application.add(word);	//add JPanel
	    application.setSize(300,200);//set_size
	    application.setResizable(false);//can not change size
	    application.setVisible(true);
	    word.setArrayList();//set array list
	    word.input_deal();//deal input
	}//end method main
}//end class 
