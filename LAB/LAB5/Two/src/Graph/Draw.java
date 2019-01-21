package Graph;

import javax.swing.JFrame;
//begin class Draw
public class Draw {
    //begin class main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DrawShape drawshape=new DrawShape();
        JFrame application=new JFrame();
        application.setTitle("简单画图");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(drawshape);	//add JPanel
        application.setSize(1000,700);//set_size
        application.setVisible(true);
        drawshape.drawSomething();//draw
	}

}
