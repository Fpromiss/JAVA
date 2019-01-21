package Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

//类：FormatMenu,格式菜单
public class FormatMenu extends JMenu implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//“格式”的菜单项
    JCheckBoxMenuItem formatMenu_LineWrap;//自动换行
	JMenuItem formatMenu_Font;//字体
	
	FormatMenu(String name){
		this.setText(name);
		formatMenu_LineWrap=new JCheckBoxMenuItem("自动换行(W)");//创建勾选框自动换行
		formatMenu_LineWrap.setMnemonic('W');//设置快捷键ALT+W
		formatMenu_LineWrap.setState(true);//设置初始自动换行
		formatMenu_LineWrap.addActionListener(this);//监听

		formatMenu_Font=new JMenuItem("字体(F)...");//创建字体MenuItem
		formatMenu_Font.addActionListener(this);//监听
		
		add(formatMenu_LineWrap); //加入到FormatMenu
		add(formatMenu_Font);//加入到FormatMenu
	}

	@Override
	//响应
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//自动换行(已在前面设置)
		if(e.getSource()==formatMenu_LineWrap)
		{	
			if(formatMenu_LineWrap.getState())//如果选中了自动换行
				TextFrame.editArea.setLineWrap(true);//自动换行
			else 
				TextFrame.editArea.setLineWrap(false);//不自动换行

		}//自动换行结束
		//字体设置
		else if(e.getSource()==formatMenu_Font)
		{	
			TextFrame.editArea.requestFocus();//获取文档焦点
			MyFont myfont=new MyFont();
			myfont.font();//字体设置
		}//字体设置结束
	}//结束方法
}//结束类：FormatMenu
