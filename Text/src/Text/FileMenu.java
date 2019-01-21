package Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

//类：FileMenu,文件菜单
public class FileMenu extends JMenu implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//文件菜单选项：新建、打开、保存、另存为、退出
	JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Exit;
	//文件菜单选项：页面设置、打印
	JMenuItem fileMenu_PageSetUp,fileMenu_Print;  
	//构造函数
	FileMenu(String name){
		this.setText(name);//设置文件菜单title
		fileMenu_New=new JMenuItem("新建(N)");//创建新建MenuItem
		fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		fileMenu_New.addActionListener(this);//监听

		fileMenu_Open=new JMenuItem("打开(O)...");//创建打开MenuItem
		fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		fileMenu_Open.addActionListener(this);//监听

		fileMenu_Save=new JMenuItem("保存(S)");//创建保存MenuItem
		fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		fileMenu_Save.addActionListener(this);//监听

		fileMenu_SaveAs=new JMenuItem("另存为(A)...");//创建另存为MenuItem
		fileMenu_SaveAs.addActionListener(this);//监听

		fileMenu_PageSetUp=new JMenuItem("页面设置(U)...");//创建页面设置MenuItem
		fileMenu_PageSetUp.addActionListener(this);//监听

		fileMenu_Print=new JMenuItem("打印(P)...");//创建打印MenuItem
		fileMenu_Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK)); 
		fileMenu_Print.addActionListener(this);//监听

		fileMenu_Exit=new JMenuItem("退出(X)");//创建退出MenuItem
		fileMenu_Exit.addActionListener(this);//监听
		
		add(fileMenu_New); //fileMenu添加fileMenu_New
		add(fileMenu_Open); //fileMenu添加fileMenu_Open
		add(fileMenu_Save); //fileMenu添加fileMenu_Save
		add(fileMenu_SaveAs); //fileMenu添加fileMenu_SaveAs
		addSeparator();		//分隔线
		add(fileMenu_PageSetUp); //fileMenu添加fileMenu_PageSetup
		add(fileMenu_Print); //fileMenu添加fileMenu_Print
		addSeparator();		//分隔线 
		add(fileMenu_Exit); //fileMenu添加fileMenu_Exit
	}//结束构造函数

	@Override
	//响应
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fileMenu_New){//如果是新建
			NewFile newfile=new NewFile();
			try {
				newfile.new_file();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//新建一个文档
		}
		else if(e.getSource()==fileMenu_Open){//如果打开
			OpenFile openfile=new OpenFile();
			try {
				openfile.open_file();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//打开一个文档
		}
		else if(e.getSource()==fileMenu_Save){//如果保存
			SaveFile savefile=new SaveFile();
			try {
				savefile.save_file();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//保存当前文档
		}
		else if(e.getSource()==fileMenu_SaveAs){//如果另存为
			SaveAs save_as=new SaveAs();
			try {
				save_as.save_as();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//另存为当前文档
		}
		else if(e.getSource()==fileMenu_PageSetUp)//如果页面设置
		{	
			TextFrame.editArea.requestFocus();
			JOptionPane.showMessageDialog(this,"页面设置界面~~~~","提示",JOptionPane.WARNING_MESSAGE);
		}//页面设置结束
		//打印
		else if(e.getSource()==fileMenu_Print)//如果打印
		{	
			TextFrame.editArea.requestFocus();
			JOptionPane.showMessageDialog(this,"打印打印打印~~~","提示",JOptionPane.WARNING_MESSAGE);
		}//打印结束
		//退出
		else if(e.getSource()==fileMenu_Exit)//如果退出
		{	
			//弹出退出框
			int exitChoose=JOptionPane.showConfirmDialog(this,"确定要退出吗?","退出提示",JOptionPane.OK_CANCEL_OPTION);
			if(exitChoose==JOptionPane.OK_OPTION)//如果退出
			{	
				System.exit(0);//退出
			}
			else
			{	return;
			}
		}//退出结束
	}//结束方法
}//结束类：FileMenu
