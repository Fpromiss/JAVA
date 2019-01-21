package Two;

import javax.swing.JFrame;
//测试类
public class StudentTest {
    //main方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         StudentFrame stu=new StudentFrame();//创建StudentFrame对象
         stu.setLocation(100, 100);//设置位置
         stu.setSize(480, 180);//设置大小
         stu.setVisible(true);
         stu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//结束main方法
}//结束测试类
