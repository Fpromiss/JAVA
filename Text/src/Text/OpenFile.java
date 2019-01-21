package Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//类：OpenFile，打开文件
public class OpenFile extends JFrame{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //方法：打开文件
	public void open_file() throws IOException{
    	TextFrame.editArea.requestFocus();//获取文档焦点
		String currentValue=TextFrame.editArea.getText();//获取文档内容
		boolean isTextChange=(currentValue.equals(TextFrame.oldValue))?false:true;//判断文档是否改变
		MyFile myfile=new MyFile();//创建一个MyFile对象
		if(isTextChange)//如果文档更改了
		{	
			//弹出是否保存
			int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);
			if(saveChoose==JOptionPane.YES_OPTION)//如果保存
			{	
				JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				myfile.set_fileChooser(fileChooser, "另存为");//设置fileChooser

				int result=fileChooser.showSaveDialog(this);
				if(result==JFileChooser.CANCEL_OPTION)//如果此时点击取消
				{
					TextFrame.statusLabel.setText("您没有选择任何文件");//设置状态
					return;
				}
				File saveFileName=fileChooser.getSelectedFile();//获取选中文件
				//如果选中文件为空或者文件名为空
				if(saveFileName==null || saveFileName.getName().equals(""))
				{	
					//弹出错误
					JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{	
					myfile.write_file(saveFileName);//写文件
					myfile.change_frame_state(saveFileName);//改变TextFrame中isNewFile、currentFile、oldValue、statusLabel
					this.setTitle(saveFileName.getName()+" - 记事本");//设置title
				}
			}
			else if(saveChoose==JOptionPane.NO_OPTION)//如果不保存
			{	
				String str=null;
				JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				myfile.set_fileChooser(fileChooser, "打开");//设置fileChooser
				
				int result=fileChooser.showOpenDialog(this);
				if(result==JFileChooser.CANCEL_OPTION)//如果此时取消
				{	
					TextFrame.statusLabel.setText("您没有选择任何文件");//设置状态
					return;
				}
				File fileName=fileChooser.getSelectedFile();//获取选中文件
				//如果选中文件为空或者文件名为空
				if(fileName==null || fileName.getName().equals(""))
				{	
					//弹出错误
					JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					try
					{
						FileReader fr=new FileReader(fileName);//创建一个FileReader
						BufferedReader bfr=new BufferedReader(fr);//创建一个BufferedReader
						TextFrame.editArea.setText(""); //设置文档内容空
						 // 取得系统相依的换行字符
		                String lineSeparator = System.getProperty("line.separator");
						while((str=bfr.readLine())!=null)
						{	
							TextFrame.editArea.append(str);//添加内容
							TextFrame.editArea.append(lineSeparator);//添加换行
						}
						this.setTitle(fileName.getName()+" - 记事本");//设置title
		                myfile.change_frame_state(fileName);//改变TextFrame中isNewFile、currentFile、oldValue、statusLabel			
						fr.close();//关闭
					}
					catch (IOException ioException){
					}
				}
			}
			else
			{	
				return;
			}
		}
		else//如果文档没有更改
		{	
			String str=null;
			JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			myfile.set_fileChooser(fileChooser, "打开文件");//设置fileChooser
			
			int result=fileChooser.showOpenDialog(this);
			if(result==JFileChooser.CANCEL_OPTION)//如果没有选择文件
			{	
				TextFrame.statusLabel.setText(" 您没有选择任何文件 ");
				return;
			}
			File fileName=fileChooser.getSelectedFile();//获取选择的文件
			//如果选中文件为空或者文件名为空
			if(fileName==null || fileName.getName().equals(""))
			{	
				//弹出错误
				JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
			}
			else
			{	
				try
				{	
					FileReader fr=new FileReader(fileName);//创建一个FileReader
					BufferedReader bfr=new BufferedReader(fr);//创建一个BufferedReader
					TextFrame.editArea.setText("");//设置文档内容空
					  // 取得系统相依的换行字符
	                String lineSeparator = System.getProperty("line.separator");
					while((str=bfr.readLine())!=null)
					{	
						TextFrame.editArea.append(str);//添加内容
						TextFrame.editArea.append(lineSeparator);//添加换行
					}
					this.setTitle(fileName.getName()+" - 记事本");//设置title
					myfile.change_frame_state(fileName);//改变TextFrame中isNewFile、currentFile、oldValue、statusLabel
					fr.close();//关闭
					bfr.close();//关闭
				}
				catch (IOException ioException)
				{
					   JOptionPane.showMessageDialog(null, ioException.toString(),
			                    "开启文件失败", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}//打开结束
}
