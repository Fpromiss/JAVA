package Text;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//类： SaveAs，另存为
public class SaveAs extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //方法：另存为
	public void save_as() throws IOException{
    	TextFrame.editArea.requestFocus();//获取文档焦点
		JFileChooser fileChooser=new JFileChooser();//创建一个文件选择器
		MyFile myfile=new MyFile();//创建一个MyFile对象
		myfile.set_fileChooser(fileChooser, "另存为");//设置fileChooser
		
		int result=fileChooser.showSaveDialog(this);
		if(result==JFileChooser.CANCEL_OPTION)//如果点击取消
		{	
			TextFrame.statusLabel.setText("　您没有选择任何文件");//设置label状态
			return;
		}				
		File saveFileName=fileChooser.getSelectedFile();//获取选中文件
		//如果文件为空或者文件名为空
		if(saveFileName==null||saveFileName.getName().equals(""))
		{	//报错
			JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);
		}	
		else 
		{	
			myfile.write_file(saveFileName);//写文件
			TextFrame.oldValue=TextFrame.editArea.getText();//替换旧的文本内容
			this.setTitle(saveFileName.getName()+"  - 记事本");//设置title
			TextFrame.statusLabel.setText("　当前打开文件:"+saveFileName.getAbsoluteFile());//设置状态label				
		}
	}//另存为结束
}//结束类： SaveAs
