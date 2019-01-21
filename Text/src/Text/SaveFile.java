package Text;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//类：SaveFile，保存
public class SaveFile extends JFrame{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //方法：保存
	public void save_file() throws IOException{
    	TextFrame.editArea.requestFocus();//获取文档焦点
		MyFile myfile=new MyFile();
		if(TextFrame.isNewFile){//如果当前文件是新的文件	
			JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
			myfile.set_fileChooser(fileChooser,"保存");
			
		    int result=fileChooser.showSaveDialog(this);//获取选择结果
			if(result==JFileChooser.CANCEL_OPTION){	//如果取消
				TextFrame.statusLabel.setText("您没有选择任何文件");//设置状态label
				return;
			}
			File saveFileName=fileChooser.getSelectedFile();//获取选择文件
			//如果文件为空或者文件名为空
			if(saveFileName==null || saveFileName.getName().equals("")){	
				JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);//报错
			}
			else {
				myfile.write_file(saveFileName);//写文件	
				myfile.change_frame_state(saveFileName);//改变TextFrame中isNewFile、currentFile、oldValue、statusLabel
				this.setTitle(saveFileName.getName()+" - 记事本");//设置title			
			}
		}
		else{//如果当前文件不是新文件	
			myfile.write_file(TextFrame.currentFile);//写文件
		}
	}//保存结束
}//结束类：SaveFile
