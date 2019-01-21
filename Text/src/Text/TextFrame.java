package Text;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

//类：TextFrame，用于记事本的窗体主题
public class TextFrame extends JFrame implements DocumentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    FileMenu fileMenu;//文件菜单
    static EditMenu editMenu;//编辑菜单
    FormatMenu formatMenu;//格式菜单
    ViewMenu viewMenu;//查看菜单
    HelpMenu helpMenu;//帮助菜单
    
    PopupMenu popupMenu;//右键菜单
    
    //“文本”编辑区域
  	public static JTextArea editArea;
  	//状态栏标签
  	public static JLabel statusLabel;
  	//系统剪贴板
  	public static Toolkit toolkit=Toolkit.getDefaultToolkit();
  	public static Clipboard clipBoard=toolkit.getSystemClipboard();
  	//创建撤销操作管理器(与撤销操作有关)
  	public static UndoManager undo=new UndoManager();
  	public UndoableEditListener undoHandler=new UndoHandler();
  	//其他变量
  	public static String oldValue;//存放编辑区原来的内容，用于比较文本是否有改动
  	public static boolean isNewFile=true;//是否新文件(未保存过的)
  	public static File currentFile;//当前文件名
	
  	//构造函数
	TextFrame(){
		JMenuBar menuBar=new JMenuBar();//创建一个MenuBar
		fileMenu=new FileMenu("文件(F)");//创建文件菜单
		fileMenu.setMnemonic('F');//设置快捷键ALT+F
		editMenu=new EditMenu("编辑(E)");//创建编辑菜单
		editMenu.setMnemonic('E');//设置快捷键ALT+E
		formatMenu=new FormatMenu("格式(O)");//创建格式菜单
		formatMenu.setMnemonic('O');//设置快捷键ALT+O
		viewMenu=new ViewMenu("查看(V)");//创建查看菜单
		viewMenu.setMnemonic('V');//设置快捷键ALT+V
		helpMenu = new HelpMenu("帮助(H)");//创建帮助菜单
     	helpMenu.setMnemonic('H');//设置快捷键ALT+H
     	
     	menuBar.add(fileMenu);//文件菜单添加到menuBar中
     	menuBar.add(editMenu);//编辑菜单添加到menuBar中
     	menuBar.add(formatMenu);//格式菜单添加到menuBar中
     	menuBar.add(viewMenu);//查看菜单添加到menuBar中
     	menuBar.add(helpMenu);//帮助菜单添加到menuBar中
     	
     	//向窗口添加菜单条				
        this.setJMenuBar(menuBar);
        
        //JScrollPane里放editArea
        editArea=new JTextArea(20,50);//创建文本编辑区
        //创建文本编辑区并添加滚动条
        JScrollPane scroller=new JScrollPane(editArea);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroller,BorderLayout.CENTER);//向窗口添加文本编辑区
        editArea.setWrapStyleWord(true);//设置单词在一行不足容纳时换行
        editArea.setLineWrap(true);//设置文本编辑区自动换行默认为true,即会"自动换行"
        oldValue=editArea.getText();//获取原文本编辑区的内容
       
        //编辑区注册事件监听(与撤销操作有关)
        editArea.getDocument().addUndoableEditListener(undoHandler);//获取当前文档对象.使得撤销操作能够进行
        editArea.getDocument().addDocumentListener(this);//获取当前文档对象.添加一个文档监听（文档改变触发）
       
        popupMenu=new PopupMenu();//创建一个右键菜单对象

        //创建和添加状态栏
        statusLabel=new JLabel("　状态栏查看~");//创建一个状态栏label
        this.add(statusLabel,BorderLayout.SOUTH);//向窗口添加状态栏标签
       
        //文本编辑区注册右键菜单事件
     	editArea.addMouseListener(new MouseAdapter()
     	{	
     		//鼠标点击
     		public void mousePressed(MouseEvent e)
     		{
     			if(e.isPopupTrigger())//返回此鼠标事件是否为该平台的弹出菜单触发事件
     			{	
     				//展示右键菜单
     			    popupMenu.show(e.getComponent(),e.getX(),e.getY());//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
     			}
       			checkMenuItemEnabled();//设置剪切，复制，粘帖，删除等功能的可用性
     			TextFrame.editArea.requestFocus();//编辑区获取焦点
     		}
     		//鼠标释放
     		public void mouseReleased(MouseEvent e)
     		{	
     			if(e.isPopupTrigger())//返回此鼠标事件是否为该平台的弹出菜单触发事件
     			{
     				 popupMenu.show(e.getComponent(),e.getX(),e.getY());//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单
     			}
     			checkMenuItemEnabled();//设置剪切，复制，粘帖，删除等功能的可用性
   				TextFrame.editArea.requestFocus();//编辑区获取焦点
   			}
    	});//文本编辑区注册右键菜单事件结束
       
       //添加窗口监听器
       addWindowListener(new WindowAdapter()
       {	
    	   //如果关闭窗口
    	   public void windowClosing(WindowEvent e)
     	   {
    		   //窗口关闭判断 
    		   CloseWindow wclose=new CloseWindow();//创建一个CloseWindow对象
    		   try {
				wclose.close_window();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};//判断是否保存等
     	   }
       });
       
       checkMenuItemEnabled();//设置菜单项的可用性：剪切，复制，粘帖，删除功能
	   editArea.requestFocus();//编辑区获取焦点
	}//结束构造函数
	
	//设置菜单项的可用性：剪切，复制，粘帖，删除功能
	public void checkMenuItemEnabled()
	{
		String selectText=editArea.getSelectedText();//获取编辑区的文本
		if(selectText==null)//如果文本是空的，那么此时不可以编辑，设置剪切、复制、删除为false
		{	
			editMenu.set_Enable(false, false, false);
			popupMenu.set_Enable(false, false, false);
		}
		else//否则设置剪切、复制、删除为true
		{	
			editMenu.set_Enable(true,true,true);
			popupMenu.set_Enable(true,true,true);
		}
		//粘帖功能可用性判断
		Transferable contents=clipBoard.getContents(this);//获取粘贴板的内容
		if(contents==null)//如果粘贴板内容为空，那么设置黏贴空能为false
		{	
			editMenu.set_paste_Enable(false);
			popupMenu.set_paste_Enable(false);
		}
		else//否则设置黏贴为true
		{	
			editMenu.set_paste_Enable(true);
			popupMenu.set_paste_Enable(true);
		}
	}//方法checkMenuItemEnabled()结束
		
	//实现接口UndoableEditListener的类UndoHandler(与撤销操作有关)
    public class UndoHandler implements UndoableEditListener
	{	
    	public void undoableEditHappened(UndoableEditEvent uee)
		{	
    		undo.addEdit(uee.getEdit());
		}
	}//结束方法


    //实现DocumentListener接口中的方法(与撤销操作有关)
	@Override
	//设置撤销操作可以进行
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		editMenu.set_undo_Enable(true);
		popupMenu.set_undo_Enable(true);
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		editMenu.set_undo_Enable(true);
		popupMenu.set_undo_Enable(true);
	}

	@Override
	//设置此时撤销操作不可以进行
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		editMenu.set_undo_Enable(true);
		popupMenu.set_undo_Enable(true);
	}//DocumentListener结束
}//结束类：TextFrame
