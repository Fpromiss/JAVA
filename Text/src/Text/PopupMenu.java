package Text;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.undo.CannotUndoException;

//类：PopupMenu，右键弹出菜单
public class PopupMenu extends JPopupMenu implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//右键菜单选项：撤销、剪切、复制、黏贴
	JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste;
	//右键菜单选项：删除、全选
	JMenuItem popupMenu_Delete,popupMenu_SelectAll;
	//构造函数
	PopupMenu(){
		popupMenu_Undo=new JMenuItem("撤销(U)");//创建撤销MenuItem
		popupMenu_Cut=new JMenuItem("剪切(T)");//创建剪切MenuItem
		popupMenu_Copy=new JMenuItem("复制(C)");//创建复制MenuItem
		popupMenu_Paste=new JMenuItem("粘帖(P)");//创建黏贴MenuItem
		popupMenu_Delete=new JMenuItem("删除(D)");//创建删除MenuItem
		popupMenu_SelectAll=new JMenuItem("全选(A)");//创建全选MenuItem
		
		popupMenu_Undo.setEnabled(false);//设置撤销不可用

		//向右键菜单添加菜单项和分隔符
		add(popupMenu_Undo);//向popupMenu添加popupMenu_Undo
		addSeparator();//添加分隔符
		add(popupMenu_Cut);//向popupMenu添加popupMenu_Cut
		add(popupMenu_Copy);//向popupMenu添加popupMenu_Copy
		add(popupMenu_Paste);//向popupMenu添加popupMenu_Paste
		add(popupMenu_Delete);//向popupMenu添加popupMenu_Delete
		addSeparator();//添加分隔符
		add(popupMenu_SelectAll);//向popupMenu添加popupMenu_SelectAll
		
		//文本编辑区注册右键菜单事件
		popupMenu_Undo.addActionListener(this);//监听
		popupMenu_Cut.addActionListener(this);//监听
		popupMenu_Copy.addActionListener(this);//监听
		popupMenu_Paste.addActionListener(this);//监听
		popupMenu_Delete.addActionListener(this);//监听
		popupMenu_SelectAll.addActionListener(this);//监听
		
		//当选择编辑菜单时，设置剪切、复制、粘贴、删除等功能的可用性
		this.addPopupMenuListener(new PopupMenuListener()
		{	
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性	
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
			}
		});//结束	
	}//结束构造函数
	
	//方法：设置剪切、复制、删除可用性
	public void set_Enable(boolean cut,boolean copy,boolean delete){
		popupMenu_Cut.setEnabled(cut);
		popupMenu_Copy.setEnabled(copy);
		popupMenu_Delete.setEnabled(delete);
	}//结束方法
	
	//设置黏贴可用性
	public void set_paste_Enable(boolean paste){
		popupMenu_Paste.setEnabled(paste);
	}//结束方法
	
	//设置撤销可用性
	public void set_undo_Enable(boolean undo){
		popupMenu_Undo.setEnabled(undo);
	}//结束方法
	
	//设置菜单项的可用性：剪切，复制，粘帖，删除功能
	public void checkMenuItemEnabled()
	{	
		String selectText=TextFrame.editArea.getSelectedText();//获取选中内容
		if(selectText==null)//如果选中内容为空
		{	
			set_Enable(false,false,false);//设置剪切、复制、删除不可用
		}
		else//如果选中内容非空
		{
			set_Enable(true,true,true);//设置剪切、复制、删除可用
		}
		//粘帖功能可用性判断
		Transferable contents=TextFrame.clipBoard.getContents(this);
		if(contents==null)//如果为空
		{	
			popupMenu_Paste.setEnabled(false);//黏贴不可用
		}
		else//非空
		{	
			popupMenu_Paste.setEnabled(true);//黏贴可用
		}
	}//方法checkMenuItemEnabled()结束

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//如果撤销
			if(e.getSource()==popupMenu_Undo)
		    {	
			TextFrame.editArea.requestFocus();//获取焦点
			if(TextFrame.undo.canUndo())//如果能撤销
			{	
				try
				{
					TextFrame.undo.undo();//撤销
				}
				catch (CannotUndoException ex)
				{	
					System.out.println("Unable to undo:" + ex);
				}
			}
			else{//如果不能撤销
				popupMenu_Undo.setEnabled(false);//设置撤销不可用
			}
		}//撤销结束
		//剪切
		else if(e.getSource()==popupMenu_Cut)
		{	TextFrame.editArea.requestFocus();//获取文档焦点
			String text=TextFrame.editArea.getSelectedText();//获取选中内容
			StringSelection selection=new StringSelection(text);//选择内容
			TextFrame.clipBoard.setContents(selection,null);//放入剪切板
			//替换剪切后的文档
			TextFrame.editArea.replaceRange("",TextFrame.editArea.getSelectionStart(),TextFrame.editArea.getSelectionEnd());
			checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性
		}//剪切结束
		//复制
		else if(e.getSource()==popupMenu_Copy)
		{	
			TextFrame.editArea.requestFocus();//获取文档焦点
			String text=TextFrame.editArea.getSelectedText();//获取选中内容
			StringSelection selection=new StringSelection(text);//选择内容
			TextFrame.clipBoard.setContents(selection,null);//放入剪切板
			checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性
		}//复制结束
		//粘帖
		else if(e.getSource()==popupMenu_Paste)
		{	TextFrame.editArea.requestFocus();//获取文档焦点
			Transferable contents=TextFrame.clipBoard.getContents(this);//获取剪切板内容
			if(contents==null)//如果是空的
				return;
			String text="";
			try//如果非空剪切板
			{	
				text=(String)contents.getTransferData(DataFlavor.stringFlavor);//获取内容
			}
			catch (Exception exception)	{
			}
			//替换黏贴后的文档
			TextFrame.editArea.replaceRange(text,TextFrame.editArea.getSelectionStart(),TextFrame.editArea.getSelectionEnd());
			checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性
		}//粘帖结束
		//删除
		else if(e.getSource()==popupMenu_Delete)
		{	
			TextFrame.editArea.requestFocus();//获取文档焦点
			//替换删除后的文档
		    TextFrame.editArea.replaceRange("",TextFrame.editArea.getSelectionStart(),TextFrame.editArea.getSelectionEnd());
			checkMenuItemEnabled();	//设置剪切、复制、粘贴、删除等功能的可用性	
		}//删除结束
		//全选
		else if(e.getSource()==popupMenu_SelectAll)
		{	
			TextFrame.editArea.selectAll();//全选
		}//全选结束
	}//结束方法
}//结束类：PopupMenu
