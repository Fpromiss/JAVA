package Draw3;

import javax.swing.JFrame;

public class Draw3 {
    //begin main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DrawShape drawshape=new DrawShape();
        //window
        JFrame application=new JFrame();
        //set title
        application.setTitle("生成十个随机的图形！！！");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(drawshape);	//add JPanel
        application.setSize(800,600);//set_size
        application.setVisible(true);
	}

}
