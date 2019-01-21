package Text;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.undo.CannotUndoException;

//编辑菜单
public class EditMenu extends JMenu implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//编辑菜单选项：撤销、剪切、复制、黏贴、删除
	JMenuItem editMenu_Undo,editMenu_Cut,editMenu_Copy,editMenu_Paste,editMenu_Delete;
	//编辑菜单选项：查找、查找下一个、替换、转到、全选、时间/日期
	JMenuItem editMenu_Find,editMenu_FindNext,editMenu_Replace,editMenu_GoTo,editMenu_SelectAll,editMenu_TimeDate;
	//构造函数
	EditMenu(String name){
		this.setText(name);//设置EditMenu title
		editMenu_Undo=new JMenuItem("撤销(U)");//创建撤销MenuItem
		editMenu_Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		editMenu_Undo.addActionListener(this);//监听
		editMenu_Undo.setEnabled(false);//设置不可用

		editMenu_Cut=new JMenuItem("剪切(T)");//创建剪切MenuItem
		editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		editMenu_Cut.addActionListener(this);//监听

		editMenu_Copy=new JMenuItem("复制(C)");//创建复制MenuItem
		editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		editMenu_Copy.addActionListener(this);//监听

		editMenu_Paste=new JMenuItem("粘贴(P)");//创建黏贴MenuItem
		editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		editMenu_Paste.addActionListener(this);//监听

		editMenu_Delete=new JMenuItem("删除(D)");//创建删除MenuItem
		editMenu_Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		editMenu_Delete.addActionListener(this);//监听

		editMenu_Find=new JMenuItem("查找(F)...");//创建查找MenuItem
		editMenu_Find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		editMenu_Find.addActionListener(this);//监听

		editMenu_FindNext=new JMenuItem("查找下一个(N)");//创建查找下一个MenuItem
		editMenu_FindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		editMenu_FindNext.addActionListener(this);//监听

		editMenu_Replace = new JMenuItem("替换(R)...",'R'); //创建替换MenuItem
		editMenu_Replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK)); 
		editMenu_Replace.addActionListener(this);//监听

		editMenu_GoTo = new JMenuItem("转到(G)...",'G');//创建转到MenuItem 
		editMenu_GoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK)); 
		editMenu_GoTo.addActionListener(this);//监听

		editMenu_SelectAll = new JMenuItem("全选",'A');//创建全选MenuItem 
		editMenu_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); 
		editMenu_SelectAll.addActionListener(this);//监听

		editMenu_TimeDate = new JMenuItem("时间/日期(D)",'D');
		editMenu_TimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
		editMenu_TimeDate.addActionListener(this);
		
		add(editMenu_Undo);//editMenu_Undo添加到editMenu  
		addSeparator();	//分隔线 
		add(editMenu_Cut);//editMenu_Cut添加到editMenu
		add(editMenu_Copy); //editMenu_Copy添加到editMenu
		add(editMenu_Paste); //editMenu_Paste添加到editMenu
		add(editMenu_Delete); //editMenu_Delete添加到editMenu
		addSeparator(); //分隔线
		add(editMenu_Find);//editMenu_Find添加到editMenu 
		add(editMenu_FindNext); //editMenu_FindNext添加到editMenu
		add(editMenu_Replace);//editMenu_Replace添加到editMenu
		add(editMenu_GoTo); //editMenu_Goto添加到editMenu
		addSeparator(); //分隔线
	    add(editMenu_SelectAll);//editMenu_SelectAll添加到editMenu 
		add(editMenu_TimeDate);//editMenu_TimeDate添加到editMenu
		
		//当选择编辑菜单时，设置剪切、复制、粘贴、删除等功能的可用性
		this.addMenuListener(new MenuListener()
		{	
			public void menuCanceled(MenuEvent e)//取消菜单时调用
			{
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
			}
			
			public void menuDeselected(MenuEvent e)//取消选择某个菜单时调用
			{	
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
			}
			
			public void menuSelected(MenuEvent e)//选择某个菜单时调用
			{	
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
			}
		});//结束
	}//结束构造函数
	
	//方法：设置剪切、复制、删除可用性
	public void set_Enable(boolean cut,boolean copy,boolean delete){
		editMenu_Cut.setEnabled(cut);
		editMenu_Copy.setEnabled(copy);
		editMenu_Delete.setEnabled(delete);
	}//结束方法
	
	//方法:设置黏贴可用性
	public void set_paste_Enable(boolean paste){
		editMenu_Paste.setEnabled(paste);;
	}//结束方法
	
	//方法：设置撤销可用性
	public void set_undo_Enable(boolean undo){
		editMenu_Undo.setEnabled(undo);
	}//结束方法
	
    //响应监听
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==editMenu_Undo)//如果撤销
			{	
			    TextFrame.editArea.requestFocus();//获取文档焦点
				if(TextFrame.undo.canUndo())//如果此时能够撤销
				{	
					try
					{	
						TextFrame.undo.undo();//那就撤销
					}
					catch (CannotUndoException ex)
					{	
						System.out.println("Unable to undo:" + ex);
					}
				}
				if(! TextFrame.undo.canUndo())//如果此时不能够撤销
				{	
					editMenu_Undo.setEnabled(false);//设置不能撤销
				}
			}//撤销结束
			//如果剪切
			else if(e.getSource()==editMenu_Cut)
			{	 
				TextFrame.editArea.requestFocus();//获取文档焦点
				String text= TextFrame.editArea.getSelectedText();//获取选中的文档
				StringSelection selection=new StringSelection(text);
				TextFrame.clipBoard.setContents(selection,null);//放入剪切板
				//替换当前文档
				TextFrame.editArea.replaceRange("", TextFrame.editArea.getSelectionStart(), TextFrame.editArea.getSelectionEnd());
				checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性
			}//剪切结束
			//如果复制
			else if(e.getSource()==editMenu_Copy)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				String text= TextFrame.editArea.getSelectedText();//获取选中文档
				StringSelection selection=new StringSelection(text);//选中文档
				TextFrame.clipBoard.setContents(selection,null);//放入剪切板
				checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性
			}//复制结束
			//如果粘帖
			else if(e.getSource()==editMenu_Paste)
			{	 
				TextFrame.editArea.requestFocus();//获取文档焦点
				Transferable contents=TextFrame.clipBoard.getContents(this);//获取剪切板内容
				if(contents==null)//如果剪切板内容为空
					return;
				String text="";
				try
				{	
					text=(String)contents.getTransferData(DataFlavor.stringFlavor);//获取黏贴字符串
				}
				catch (Exception exception)
				{
				}
				//替换当前文档内容
				TextFrame.editArea.replaceRange(text, TextFrame.editArea.getSelectionStart(), TextFrame.editArea.getSelectionEnd());
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性	
			}//粘帖结束
			//如果删除
			else if(e.getSource()==editMenu_Delete)
			{	 
				TextFrame.editArea.requestFocus();//获取文档焦点
				//替换当前文档内容
			    TextFrame.editArea.replaceRange("", TextFrame.editArea.getSelectionStart(), TextFrame.editArea.getSelectionEnd());
				checkMenuItemEnabled();	//设置剪切、复制、粘贴、删除等功能的可用性	
			}//删除结束
			//如果查找
			else if(e.getSource()==editMenu_Find)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				Find myfind=new Find();//创建一个find对象
				myfind.find();//调用find函数
			}//查找结束
			//如果查找下一个
			else if(e.getSource()==editMenu_FindNext)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				Find myfind=new Find();//创建一个find对象
				myfind.find();//调用find函数
			}//查找下一个结束
			//如果替换
			else if(e.getSource()==editMenu_Replace)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				Replace myreplace =new Replace();//创建一个replace对象
				myreplace.replace();//调用replace函数
			}//替换结束
			//如果转到
			else if(e.getSource()==editMenu_GoTo)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				//弹出对话框
				JOptionPane.showMessageDialog(this,"山重水复疑无路，柳暗花明又一村","提示",JOptionPane.WARNING_MESSAGE);
			}//转到结束
			//如果时间日期
			else if(e.getSource()==editMenu_TimeDate)
			{	
				TextFrame.editArea.requestFocus();//获取文档焦点
				Calendar rightNow=Calendar.getInstance();
				Date date=rightNow.getTime();//获取时间
				//插入时间
				TextFrame.editArea.insert(date.toString(), TextFrame.editArea.getCaretPosition());
			}//时间日期结束
			//如果全选
			else if(e.getSource()==editMenu_SelectAll)
			{	
			    TextFrame.editArea.selectAll();//全选
			}//全选结束
	}//结束方法
			
	//判断编辑菜单的剪切、复制、删除可用性
	//设置菜单项的可用性：剪切，复制，粘帖，删除功能
	public void checkMenuItemEnabled()
	{	
		String selectText=TextFrame.editArea.getSelectedText();//获取选中文档内容
		if(selectText==null)//如果没有选择的内容
		{	
			set_Enable(false,false,false);//设置剪切、复制、删除可用性false
		}
		else//如果有选中内容
		{	
			set_Enable(true,true,true);//设置剪切、复制、删除可用性true
		}
		//粘帖功能可用性判断
		Transferable contents=TextFrame.clipBoard.getContents(this);//获取剪切板内容
		if(contents==null)//如果剪切板没有内容
		{	
			editMenu_Paste.setEnabled(false);//设置黏贴可用性false
		}
		else//如果剪切板有内容
		{	
			editMenu_Paste.setEnabled(true);//设置黏贴可用性true
		}
	}//方法checkMenuItemEnabled()结束
}//结束类：EditMenu
