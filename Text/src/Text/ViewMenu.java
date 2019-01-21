package Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

//类： ViewMenu，查看菜单
public class ViewMenu extends JMenu implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCheckBoxMenuItem viewMenu_Status;//勾选状态
	//构造函数
	ViewMenu(String name){
		this.setText(name);//设置title
		viewMenu_Status=new JCheckBoxMenuItem("状态栏(S)");//创建一个CheckBoxMenuItem
		viewMenu_Status.setMnemonic('S');//设置快捷键ALT+S
		viewMenu_Status.setState(true);//设置默认勾选
		viewMenu_Status.addActionListener(this);//监听
		
		add(viewMenu_Status);//viewMenu_Status添加到viewMenu
	}//结束方法

	@Override
	//响应
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewMenu_Status)
		{	if(viewMenu_Status.getState())
				TextFrame.statusLabel.setVisible(true);
			else 
				TextFrame.statusLabel.setVisible(false);
		}//设置状态栏可见性结束
	}//结束方法
}//结束类： ViewMenu
