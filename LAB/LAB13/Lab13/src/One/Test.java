package One;

import java.awt.EventQueue;
import javax.swing.*;
//类：Test
public class Test {
    /**
     *选择图片的时候，需要按住shift键才能够选择多张图片
     */
	//main方法
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	//请求事件分发线程以运行代 码
        EventQueue.invokeLater(new Runnable() {           
            @Override
            public void run() {
                // TODO Auto-generated method stub
                JFrame frame = new ImageViewerFrame();
                frame.setSize(1200, 700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }//结束方法：run
        });
    }//结束main方法
}//结束类：Test

