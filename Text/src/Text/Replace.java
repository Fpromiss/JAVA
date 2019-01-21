package Text;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
//类：Replace，替换
public class Replace extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//替换方法
	public void replace()
	{	
		final JDialog replaceDialog=new JDialog(this,"替换",false);//false时允许其他窗口同时处于激活状态(即无模式)
		Container con=replaceDialog.getContentPane();//返回此对话框的contentPane对象
		con.setLayout(new FlowLayout(FlowLayout.CENTER));//layout
		JLabel findContentLabel=new JLabel("查找内容(N)：");//创建label
		final JTextField findText=new JTextField(15);//创建文本框
		JButton findNextButton=new JButton("查找下一个(F):");//创建button
		JLabel replaceLabel=new JLabel("替换为(P)：");//创建label
		final JTextField replaceText=new JTextField(15);//创建文本框
		JButton replaceButton=new JButton("替换(R)");//创建button
		JButton replaceAllButton=new JButton("全部替换(A)");//创建button
		JButton cancel=new JButton("取消");//创建button
		cancel.addActionListener(new ActionListener()//监听取消按钮
		{	
			public void actionPerformed(ActionEvent e)
			{
				replaceDialog.dispose();
			}
		});
		final JCheckBox matchCheckBox=new JCheckBox("区分大小写(C)");//勾选框
		ButtonGroup bGroup=new ButtonGroup();//按钮组
		final JRadioButton upButton=new JRadioButton("向上(U)");//点选框
		final JRadioButton downButton=new JRadioButton("向下(U)");//点选框
		downButton.setSelected(true);//设置可选择
		bGroup.add(upButton);//upButton添加到按钮组
		bGroup.add(downButton);//downButton添加到按钮组
		//"查找下一个"按钮监听
		findNextButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{	//"区分大小写(C)"的JCheckBox是否被选中
				int k=0;//位置
				final String str1,str2,str3,str4,strA,strB;
				str1=TextFrame.editArea.getText();//获取当前文档内容
				str2=findText.getText();//获取查找内容
				str3=str1.toUpperCase();//转大写
				str4=str2.toUpperCase();//转大写
				if(matchCheckBox.isSelected())//区分大小写
				{	
					strA=str1;
					strB=str2;
				}
				else//不区分大小写,此时把所选内容全部化成大写(或小写)，以便于查找 
				{	strA=str3;
					strB=str4;
				}
				if(upButton.isSelected())//向上查找
				{	
					if(TextFrame.editArea.getSelectedText()==null)//如果选中为空
						k=strA.lastIndexOf(strB,TextFrame.editArea.getCaretPosition()-1);//获取位置
					else//如果非空
						k=strA.lastIndexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()-1);//获取位置	
					if(k>-1)//如果找到
					{	
						TextFrame.editArea.setCaretPosition(k);
						TextFrame.editArea.select(k,k+strB.length());//选中找到的
					}
					else//如果每找到
					{	
						JOptionPane.showMessageDialog(null,"找不到您查找的内容！","查找",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(downButton.isSelected())//如果向下查找
				{
					if(TextFrame.editArea.getSelectedText()==null)//如果选中为空
						k=strA.indexOf(strB,TextFrame.editArea.getCaretPosition()+1);//获取位置
					else//如果非空
						k=strA.indexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()+1);	//获取位置
					if(k>-1)//如果找到
					{	
						TextFrame.editArea.setCaretPosition(k);
						TextFrame.editArea.select(k,k+strB.length());//选中找到
					}
					else
					{	
						JOptionPane.showMessageDialog(null,"找不到您查找的内容！","查找",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});//"查找下一个"按钮监听结束
		
		//"替换"按钮监听
		replaceButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{	
				//如果替换为空，选中非空
				if(replaceText.getText().length()==0 && TextFrame.editArea.getSelectedText()!=null) 
				     TextFrame.editArea.replaceSelection(""); 
				//如果替换非空，选中非空
				if(replaceText.getText().length()>0 && TextFrame.editArea.getSelectedText()!=null) 
					TextFrame.editArea.replaceSelection(replaceText.getText());
			}
		});//"替换"按钮监听结束
		
		//"全部替换"按钮监听
		replaceAllButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
			    TextFrame.editArea.setCaretPosition(0);	//将光标放到编辑区开头	
				int k=0,replaceCount=0;
				if(findText.getText().length()==0)//如果查找内容为空
				{	
					JOptionPane.showMessageDialog(replaceDialog,"请填写查找内容!","提示",JOptionPane.WARNING_MESSAGE);
					findText.requestFocus(true);
					return;
				}
				//如果查找内容非空
				while(k>-1)//当文本中有内容被选中时(k>-1被选中)进行替换，否则不进行while循环
				{	//"区分大小写(C)"的JCheckBox是否被选中
					final String str1,str2,str3,str4,strA,strB;
					str1=TextFrame.editArea.getText();//获取当前文本内容
					str2=findText.getText();
					str3=str1.toUpperCase();//转大写
					str4=str2.toUpperCase();//转大写
					if(matchCheckBox.isSelected())//区分大小写
					{	
						strA=str1;
						strB=str2;
					}
					else//不区分大小写,此时把所选内容全部化成大写(或小写)，以便于查找 
					{	
						strA=str3;
						strB=str4;
					}
					if(upButton.isSelected())//如果向上
					{	
						if(TextFrame.editArea.getSelectedText()==null)//如果选中为空
							k=strA.lastIndexOf(strB,TextFrame.editArea.getCaretPosition()-1);//获取位置
						else//如果选中非空
							k=strA.lastIndexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()-1);	//获取位置
						if(k>-1)//如果找到
						{	
							TextFrame.editArea.setCaretPosition(k);
							TextFrame.editArea.select(k,k+strB.length());//选中
						}
						else
						{	
							if(replaceCount==0)
							{	
								JOptionPane.showMessageDialog(replaceDialog, "找不到您查找的内容!", "记事本",JOptionPane.INFORMATION_MESSAGE); 
							}
							else
							{	
								JOptionPane.showMessageDialog(replaceDialog,"成功替换"+replaceCount+"个匹配内容!","替换成功",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					else if(downButton.isSelected())//如果向下
					{	if(TextFrame.editArea.getSelectedText()==null)//如果选中为空
							k=strA.indexOf(strB,TextFrame.editArea.getCaretPosition()+1);//获取位置
						else//如果选中非空
							k=strA.indexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()+1);//获取位置
						if(k>-1)//如果找到 
						{	
							TextFrame.editArea.setCaretPosition(k);
							TextFrame.editArea.select(k,k+strB.length());//选中找到
						}
						else
						{	
							if(replaceCount==0)//如果找到0个
							{	//弹出
								JOptionPane.showMessageDialog(replaceDialog, "找不到您查找的内容!", "记事本",JOptionPane.INFORMATION_MESSAGE); 
							}
							else//如果找到了
							{	//弹出替换
								JOptionPane.showMessageDialog(replaceDialog,"成功替换"+replaceCount+"个匹配内容!","替换成功",JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					//如果替换的是一个空字符串并且文本中有选中，说明找到了
					if(replaceText.getText().length()==0 && TextFrame.editArea.getSelectedText()!= null)
					{	
						TextFrame.editArea.replaceSelection("");//替换
						replaceCount++;//替换个数+1
					} 
					//如果替换的字符串长度>0并且文本中有选中，说明找到了
					if(replaceText.getText().length()>0 && TextFrame.editArea.getSelectedText()!= null) 
					{	
						TextFrame.editArea.replaceSelection(replaceText.getText());//替换
						replaceCount++;//替换个数+1
					}
				}//while循环结束
			}
		});//"替换全部"方法结束
		
		//创建"替换"对话框的界面
		JPanel directionPanel=new JPanel();//创建一个panel
		directionPanel.setBorder(BorderFactory.createTitledBorder("方向"));
		directionPanel.add(upButton);//directionPanel添加upButton
		directionPanel.add(downButton);//directionPanel添加downButton
		JPanel panel1=new JPanel();//创建一个panel
		JPanel panel2=new JPanel();//创建一个panel
		JPanel panel3=new JPanel();//创建一个panel
		JPanel panel4=new JPanel();//创建一个panel
		panel4.setLayout(new GridLayout(2,1));//布局
		panel1.add(findContentLabel);//panel1添加findContentLabel
		panel1.add(findText);//panel1添加findText
		panel1.add(findNextButton);//panel1添加findNextButton
		panel4.add(replaceButton);//panel4添加replaceButton
		panel4.add(replaceAllButton);//panel4添加replaceAllButton
		panel2.add(replaceLabel);//panel2添加replaceLabel
		panel2.add(replaceText);//panel2添加replaceText
		panel2.add(panel4);//panel2添加panel4
		panel3.add(matchCheckBox);//panel3添加matchCheckBox
		panel3.add(directionPanel);//panel3添加directionPanel
		panel3.add(cancel);//panel3添加cancel
		con.add(panel1);//con添加panel1
		con.add(panel2);//con添加panel2
		con.add(panel3);//con添加panel3
		replaceDialog.setSize(420,220);//设置 大小
		replaceDialog.setResizable(false);//不可调整大小
		replaceDialog.setLocation(230,280);//设置位置
		replaceDialog.setVisible(true);
	}//"全部替换"按钮监听结束
}//结束类：Replace
