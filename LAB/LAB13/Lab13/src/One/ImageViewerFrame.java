package One;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//类：ImageViewerFrame，继承JFrame
class ImageViewerFrame extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label[]=new JLabel[3];//三个label用来放图片
    private JFileChooser chooser;//文件选择器

    public ImageViewerFrame(){
        setTitle("ImageViewer");//标题
        
        setLayout(new GridLayout(1,3,5,5));//布局方式 
        //创建三个label 并且加到 frame中
        label[0] = new JLabel();
        add(label[0]);       	
        label[1] = new JLabel();
        add(label[1]);     
        label[2] = new JLabel();
        add(label[2]);     
        
        chooser = new JFileChooser();//创建一个文件选择器
        chooser.setMultiSelectionEnabled(true);//启动多选
        chooser.setCurrentDirectory(new File("."));//选中目录为当前目录下
        JMenuBar menubar = new JMenuBar();//创建一个MenuBar
        setJMenuBar(menubar);//set MenuBar
        JMenu menu = new JMenu("File");//创建一个Menu
        menubar.add(menu);//Menu添加到MenuBar中
        //创建菜单选项 Open
        JMenuItem openItem = new JMenuItem("Open");
        //Open添加到菜刀file中
        menu.add(openItem);
        //创建菜单选项Close
        JMenuItem exitItem = new JMenuItem("Close");
        //Close添加到菜刀file中
        menu.add(exitItem);
        //监听openItem
        openItem.addActionListener(new ActionListener() {
        	//设置文件选中类型
        	final String[][] fileENames = {
        	          {".jpeg","(*.jpeg)"},
        	          {".png","(*.png)"},
        	          {".jpg","(*.jpg)"}
        	 };
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
            	//设置文件类型选择
            	  for (final String[] fileEName : fileENames) {
            	   //对JFileChooser设置过滤器 
            	   chooser.setFileFilter(new javax.swing.filechooser.FileFilter() { 
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
            	//弹出一个文件选择对话框
                int result = chooser.showOpenDialog(null);
                //JFileChooser.APPROVE_OPTION是个整形常数，代表0，当返回0 时候，进行以下操作
                if(result == JFileChooser.APPROVE_OPTION){
                	//获取选中的文件
                    File image_files[] = chooser.getSelectedFiles();
                    String name[]=new String[3];//用于存文件路径
                    int i=0;//下标
                    for(File file:image_files){
                    	name[i]=file.getPath();//获取路径
                    	label[i].setIcon(new ImageIcon(name[i]));//设置图片
                    	i++;
                    }
                   // label.setIcon(new ImageIcon(name));
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });
    }
}
