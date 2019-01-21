package Two;

import javax.swing.JFrame;
//类：Test ，测试类
public class Test {
    //main方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Desk p = new Desk();//创建Desk对象
		   p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   p.setLocation(200, 50);//设置位置
		   p.setSize(1100,700);//设置大小
		   p.setVisible(true);//设置visible为true
	}//结束main方法
}//结束测试类：Test
