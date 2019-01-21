package Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

//类：HelpMenu，帮助菜单
public class HelpMenu extends JMenu implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem helpMenu_HelpTopics,helpMenu_AboutNotepad;//帮助主题、关于记事本
	//构造函数
	HelpMenu(String name){
		this.setText(name);
		helpMenu_HelpTopics = new JMenuItem("帮助主题(H)"); //创建帮助主题MenuItem
		helpMenu_HelpTopics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpMenu_HelpTopics.addActionListener(this);//监听

		helpMenu_AboutNotepad = new JMenuItem("关于记事本(A)"); //创建关于记事本MenuItem
		helpMenu_AboutNotepad.addActionListener(this);//监听
		
		add(helpMenu_HelpTopics);//添加到HelpMenu
		addSeparator();//添加分割线
		add(helpMenu_AboutNotepad);//添加到HelpMenu
	}//结束构造函数

	@Override
	//响应
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==helpMenu_HelpTopics)//如果帮助主题
		{	
			TextFrame.editArea.requestFocus();//获取文档见到
			//弹出
			JOptionPane.showMessageDialog(null,"走过最远的路不是套路，是debug","帮助主题",JOptionPane.INFORMATION_MESSAGE);
		}//帮助主题结束
		//如果关于记事本
		else if(e.getSource()==helpMenu_AboutNotepad)
		{	
			TextFrame.editArea.requestFocus();//获取文档焦点
			//弹出
			JOptionPane.showMessageDialog(this,
				"**********************************************\n"+
				" 编  写  者: 方 俊 \n"+
				" 编写时间：2018-05-26                          \n"+
				" Thank u very much！  \n"+
				"**********************************************\n",
				"记事本",JOptionPane.INFORMATION_MESSAGE);
		}//关于结束
	}//结束方法
}//结束类：HelpMenu
