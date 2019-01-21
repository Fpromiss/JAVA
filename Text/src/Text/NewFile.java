package Text;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//类：NewFile，新建文档
public class NewFile extends JFrame{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //方法：new_file()
	public void new_file() throws IOException{
    	    TextFrame.editArea.requestFocus();//获取文档焦点
			String currentValue=TextFrame.editArea.getText();//获取当前文档内容
			MyFile myfile = new MyFile();
			boolean isTextChange=(currentValue.equals(TextFrame.oldValue))?false:true;//获取文档是否更改
			if(isTextChange)//如果文档更改了
			{	
				//弹出提示
				int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
				if(saveChoose==JOptionPane.YES_OPTION)//如果选中保存
				{	
					JFileChooser fileChooser=new JFileChooser();//创建一个文件选中
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					myfile.set_fileChooser(fileChooser, "另存为");
					
					int result=fileChooser.showSaveDialog(this);
					if(result==JFileChooser.CANCEL_OPTION)//如果没有选择文件
					{	
						TextFrame.statusLabel.setText("您没有选择任何文件");
						return;
					}
					//如果选中了文件
					File saveFileName=fileChooser.getSelectedFile();//获取选中的文件
					//如果文件是空或者文件名是空的
					if(saveFileName==null || saveFileName.getName().equals(""))
					{	
						//弹出错误
						JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
					}
					else 
					{	
						myfile.write_file(saveFileName);
						myfile.change_frame_state(saveFileName);
						this.setTitle(saveFileName.getName()+" - 记事本");//设置title
					}
				}
				else if(saveChoose==JOptionPane.NO_OPTION)//如果选中不保存
				{	
					set_new();
				}
				else if(saveChoose==JOptionPane.CANCEL_OPTION)//如果点击取消
				{	
					return;
				}
			}
			else//如果文档没有更改
			{	
				set_new();
			}
		}//新建结束
	
	//方法：设置参数
	public void set_new(){
		TextFrame.editArea.replaceRange("",0,TextFrame.editArea.getText().length());//完全覆盖原来文档
		TextFrame.statusLabel.setText(" 新建文件");//设置text：新建文件
		this.setTitle("无标题 - 记事本");//设置title
		TextFrame.isNewFile=true;//设置是新文件
		TextFrame.undo.discardAllEdits();//撤消所有的"撤消"操作
		TextFrame.editMenu.set_undo_Enable(false);//设置不可撤销
		TextFrame.oldValue=TextFrame.editArea.getText();//设置旧的文档内容文新建后的文档内容
	}//结束方法
	
}//结束类：NewFile
