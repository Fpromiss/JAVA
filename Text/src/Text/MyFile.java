package Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MyFile {
    
	public void set_fileChooser(JFileChooser fileChooser,String title){
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle(title);//设置title
		final String[][] fileENames = {
    	          {".txt","(文本文档(*.txt))"}
		};//选择文件名
		//设置文件类型选择
  	    for (final String[] fileEName : fileENames) {
  	   //对JFileChooser设置过滤器 
  		fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() { 
  	   //设置可以接受的文件类型   
  	        public boolean accept(File file) {       
  		       //文件后缀以fileEName[0]结尾或者文件是一个目录
  	           if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
                 return true;//返回true
  	        }         	 
                 return false;//否则返回false
              }//结束方法:accept(file);
  	   
  	        //获取文件描述
  	        public String getDescription() {
  	           return fileEName[1];
  	        }
  	   });//结束设置
      }//end for
	}
	
	public void write_file(File saveFileName){
		try
		{	
		    FileWriter fw=new FileWriter(saveFileName);//创建一个FileWriter
			BufferedWriter bfw=new BufferedWriter(fw);//创建一个BufferedWriter
			 // 取得系统相依的换行字符
            String lineSeparator = System.getProperty("line.separator");
			//逐行写入文件
			for(int i=0;i<TextFrame.editArea.getLineCount();++i){
				try{
					//获取文档每一行
					String s = TextFrame.editArea.getText(TextFrame.editArea.getLineStartOffset(i), TextFrame.editArea
							.getLineEndOffset(i)
							- TextFrame.editArea.getLineStartOffset(i));
					bfw.write(s);//写入每一行、
					bfw.write(lineSeparator);
					//bfw.write("\r\n");//写入换行
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}//结束：for
			bfw.flush();//刷新流的缓冲
			fw.close();//fw关闭
		}
		catch(IOException ioException){					
		}	
	}
	
	public void change_frame_state(File saveFileName){
		TextFrame.isNewFile=false;//设置不是新文件
		TextFrame.currentFile=saveFileName;//设置当前文件名
		TextFrame.oldValue=TextFrame.editArea.getText();//原来文档值用保存后的文档值替换
		TextFrame.statusLabel.setText("　当前打开文件:"+saveFileName.getAbsoluteFile());//设置状态label
	}
}
