package Text;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//类：MyFont，格式字体设置
public class MyFont extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//方法："字体"设置
		public void font()
		{	
			final JDialog fontDialog=new JDialog(this,"字体设置",false);//false时允许其他窗口同时处于激活状态(即无模式)
			Container con=fontDialog.getContentPane();//返回此对话框的contentPane对象	
			con.setLayout(new FlowLayout(FlowLayout.LEFT));//设置layout
			JLabel fontLabel=new JLabel("字体(F)：");//label：字体
			fontLabel.setPreferredSize(new Dimension(100,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			JLabel styleLabel=new JLabel("字形(Y)：");//label：字形
			styleLabel.setPreferredSize(new Dimension(100,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			JLabel sizeLabel=new JLabel("大小(S)：");//label：大小
			sizeLabel.setPreferredSize(new Dimension(100,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			final JLabel sample=new JLabel("我的记事本！！！");//label：我的记事本
			final JTextField fontText=new JTextField(9);//文本框
			fontText.setPreferredSize(new Dimension(200,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			final JTextField styleText=new JTextField(8);//文本框
			styleText.setPreferredSize(new Dimension(200,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			final int style[]={Font.PLAIN,Font.BOLD,Font.ITALIC,Font.BOLD+Font.ITALIC};//格式
			final JTextField sizeText=new JTextField(5);//文本框
			sizeText.setPreferredSize(new Dimension(200,20));//构造一个Dimension，并将其初始化为指定宽度和高度
			JButton okButton=new JButton("确定");//确定按钮
			JButton cancel=new JButton("取消");//取消按钮
			cancel.addActionListener(new ActionListener()//取消按钮监听
			{	
				public void actionPerformed(ActionEvent e)
				{	
					fontDialog.dispose();	
				}
			});//结束监听
			Font currentFont=TextFrame.editArea.getFont();//获取当前格式
			fontText.setText(currentFont.getFontName());//设置fontText当前文本为当前格式名称
			fontText.selectAll();//选中
			//四种格式
			if(currentFont.getStyle()==Font.PLAIN)
				styleText.setText("常规");
			else if(currentFont.getStyle()==Font.BOLD)
				styleText.setText("粗体");
			else if(currentFont.getStyle()==Font.ITALIC)
				styleText.setText("斜体");
			else if(currentFont.getStyle()==(Font.BOLD+Font.ITALIC))
				styleText.setText("粗斜体");
			styleText.selectAll();//全选
			String str=String.valueOf(currentFont.getSize());//大小
			sizeText.setText(str);//设置sizeText当前文本为大小
			sizeText.selectAll();//选中
			final JList<String> fontList,styleList,sizeList;//三个list
			GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
			final String fontName[]=ge.getAvailableFontFamilyNames();
			fontList=new JList<String>(fontName);//字体列表
			fontList.setFixedCellWidth(86);//宽度
			fontList.setFixedCellHeight(20);//高度
			fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//mode
			final String fontStyle[]={"常规","粗体","斜体","粗斜体"};//字体类型名称
			styleList=new JList<String>(fontStyle);//字体类型列表
			styleList.setFixedCellWidth(86);//宽度
			styleList.setFixedCellHeight(20);//高度
			styleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//mode
			if(currentFont.getStyle()==Font.PLAIN)
				styleList.setSelectedIndex(0);
			else if(currentFont.getStyle()==Font.BOLD)
				styleList.setSelectedIndex(1);
			else if(currentFont.getStyle()==Font.ITALIC)
				styleList.setSelectedIndex(2);
			else if(currentFont.getStyle()==(Font.BOLD+Font.ITALIC))
				styleList.setSelectedIndex(3);
			//字体大小
			final String fontSize[]={"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
			sizeList=new JList<String>(fontSize);//字体大小列表
			sizeList.setFixedCellWidth(43);//宽度
			sizeList.setFixedCellHeight(20);//高度
			sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//mode
			fontList.addListSelectionListener(new ListSelectionListener()//监听列表fontList
			{	
				//值改变时候
				public void valueChanged(ListSelectionEvent event)
				{	
					fontText.setText(fontName[fontList.getSelectedIndex()]);//改变显示值
					fontText.selectAll();//全选
					Font sampleFont1=new Font(fontText.getText(),style[styleList.getSelectedIndex()],Integer.parseInt(sizeText.getText()));
					sample.setFont(sampleFont1);
				}
			});//结束监听
			styleList.addListSelectionListener(new ListSelectionListener()//监听styleList
			{
				//值改变
				public void valueChanged(ListSelectionEvent event)
				{	
					int s=style[styleList.getSelectedIndex()];//改变显示值
					styleText.setText(fontStyle[s]);//设置text
					styleText.selectAll();//全选
					Font sampleFont2=new Font(fontText.getText(),style[styleList.getSelectedIndex()],Integer.parseInt(sizeText.getText()));
					sample.setFont(sampleFont2);
				}
			});//结束监听
			sizeList.addListSelectionListener(new ListSelectionListener()//监听sizeList
			{	
				//值改变时候
				public void valueChanged(ListSelectionEvent event)
				{
					sizeText.setText(fontSize[sizeList.getSelectedIndex()]);//改变显示值
					sizeText.selectAll();	//全选
					Font sampleFont3=new Font(fontText.getText(),style[styleList.getSelectedIndex()],Integer.parseInt(sizeText.getText()));
					sample.setFont(sampleFont3);
				}
			});//结束监听
			okButton.addActionListener(new ActionListener()//监听okButton
			{	
				public void actionPerformed(ActionEvent e)
				{	
					//改变格式
					Font okFont=new Font(fontText.getText(),style[styleList.getSelectedIndex()],Integer.parseInt(sizeText.getText()));
				    TextFrame.editArea.setFont(okFont);
					fontDialog.dispose();
				}
			});//结束监听
			JPanel samplePanel=new JPanel();//创建一个JPanel
			samplePanel.setBorder(BorderFactory.createTitledBorder("示例"));
			samplePanel.add(sample);//sample 添加到  samplePanel
			JPanel panel1=new JPanel();//创建一个JPanel
			JPanel panel2=new JPanel();//创建一个JPanel
			JPanel panel3=new JPanel();//创建一个JPanel
			panel2.add(fontText);//fontText添加到panel2
			panel2.add(styleText);//styleText添加到panel2
			panel2.add(sizeText);//sizeText添加到panel2
			panel2.add(okButton);//OK Button添加panel2
			panel3.add(new JScrollPane(fontList));//JList不支持直接滚动，所以要让JList作为JScrollPane的视口视图
			panel3.add(new JScrollPane(styleList));//JList不支持直接滚动，所以要让JList作为JScrollPane的视口视图
			panel3.add(new JScrollPane(sizeList));//JList不支持直接滚动，所以要让JList作为JScrollPane的视口视图
			panel3.add(cancel);//cancel添加到panel3
			con.add(panel1);//panel1添加到con
			con.add(panel2);//panel2添加到con
			con.add(panel3);//panel3添加到con
			con.add(samplePanel);//smaplePanel添加到con
			fontDialog.setSize(350,340);//设置大小
			fontDialog.setLocation(200,200);//设置位置
			fontDialog.setResizable(false);//设置窗体不可改变大小
			fontDialog.setVisible(true);
		}//结束方法
}//结束类：MyFont
