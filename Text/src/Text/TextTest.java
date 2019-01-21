package Text;

import javax.swing.JFrame;
//类：Test ,测试类
public class TextTest {
    //main方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TextFrame text=new TextFrame();//创建一个TextFrame对象
        text.setTitle("记事本");//设置title
        text.setLocation(100,100);//设置窗体出现位置
        text.setSize(700, 500);//设置窗体大小
        text.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setVisible(true);
	}//结束方法：main
}//结束类：Test
