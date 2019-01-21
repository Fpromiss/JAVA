package Two;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//类：Desk 用于创建一个桌面 继承JFrame
public class Desk extends JFrame{
	   /**
	 * by author :fang_jun
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane theDesktop;//虚拟桌面
	
	//构造函数
	Desk(){
	   JMenuBar bar = new JMenuBar();//创建MenuBar
	   JMenu addMenu = new JMenu("Add");//创建菜单add
	   JMenuItem newFrame = new JMenuItem("Internal Frame");//创建菜单选项：Internal Frame
	   
	   addMenu.add(newFrame);//菜单选项：Internal Frame添加到菜单add中
	   bar.add(addMenu);//菜单add添加到MenuBar中
	   setJMenuBar(bar);//set MenuBar
	   
	   theDesktop = new JDesktopPane();//创建虚拟桌面
	   add(theDesktop);//虚拟桌面添加到JFrame中
	   
	   //对菜单选项：Internal Frame进行监听
	   newFrame.addActionListener(
	       new ActionListener(){
	    	   //对事件响应
			   public void actionPerformed(ActionEvent e){ 
				   //创建子窗口的JFramen
    	           JInternalFrame frame = new JInternalFrame("InternalFrame",true,true,true,true);
    	           Painter p = new Painter();//窗体内容
		           frame.add(p,BorderLayout.EAST);//窗体内容添加到JFrame中
		           frame.pack();//调整窗口的大小，使其适应组件的大小和布局
		       
		           theDesktop.add(frame);//把当前子窗口添加到虚拟桌面中
		           frame.setVisible(true);//设置visible 为true
       }});//结束对菜单选项：Internal Frame进行监听
	}//结束构造函数
}//结束类：Desk
