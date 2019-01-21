package Text;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//类：CloseWindow，当关闭窗体的时候，进行判断调用
public class CloseWindow extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //方法：close_window()
	public void close_window() throws IOException{
    	TextFrame.editArea.requestFocus();//获取编辑区焦点
		String currentValue=TextFrame.editArea.getText();//获取当前文档内容
		if(currentValue.equals(TextFrame.oldValue)==true)//如果当前文档内容和之前文档内容相等，说明没有修改过
		{	
			System.exit(0);//此时直接关闭窗口
		}
		else//如果不等，说明修改过
		{	
			//弹出窗口，让用户选择是否保存
			int exitChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","退出提示",JOptionPane.YES_NO_CANCEL_OPTION);
			MyFile myfile=new MyFile();
			if(exitChoose==JOptionPane.YES_OPTION)//如果用户选择了保存
			{	
				if(TextFrame.isNewFile)//如果当前文档是一个新文档
				{	
					JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setApproveButtonText("确定");
					myfile.set_fileChooser(fileChooser, "另存为");
					
					int result=fileChooser.showSaveDialog(this);//获取文件选择结果
					//如果没有选择保存的文件
					if(result==JFileChooser.CANCEL_OPTION)
					{	
						TextFrame.statusLabel.setText("　您没有保存文件");//当前文档状态label改变
						return;
					}					
	                //此时为选择了一个文件保存
					File saveFileName=fileChooser.getSelectedFile();//获取选中保存的文件
				    //如果选中了一个空文件或者文件名为空
					if(saveFileName==null||saveFileName.getName().equals(""))
					{	
						//报错：文件名不合法
						JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
					}
					else 
					{	
						myfile.write_file(saveFileName);//写文件					
					    myfile.change_frame_state(saveFileName);//改变TextFrame中isNewFile、currentFile、oldValue、statusLabel				
					    this.setTitle(saveFileName.getName()+"  - 记事本");//设置title				
					}
				}
				else//如果当前文档不是一个新文档，而是打开的一个文档
				{
					myfile.write_file(TextFrame.currentFile);
				}
				System.exit(0);
			}
			else if(exitChoose==JOptionPane.NO_OPTION)//如果用户选中了不保存
			{	
				System.exit(0);//直接关闭窗口
			}
			else 
			{	
				return;
			}
		}//结束else（文档修改过）
    }//结束方法：close_window()
}//结束类：CloseWindow
