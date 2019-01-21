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
//类：find,查找、查找下一个
public class Find extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查找方法
	public void find()
	{	
		final JDialog findDialog=new JDialog(this,"查找",false);//false时允许其他窗口同时处于激活状态(即无模式)
		Container con=findDialog.getContentPane();//返回此对话框的contentPane对象	
		con.setLayout(new FlowLayout(FlowLayout.LEFT));//设置layout
		//设置弹出查找框中的内容
		JLabel findContentLabel=new JLabel("查找内容(N)：");//创建一个label
		final JTextField findText=new JTextField(15);//创建一个文本框
		JButton findNextButton=new JButton("查找下一个(F)：");//创建一个button
		final JCheckBox matchCheckBox=new JCheckBox("区分大小写(C)");//创建一个勾选框
		ButtonGroup bGroup=new ButtonGroup();//按钮组
		final JRadioButton upButton=new JRadioButton("向上(U)");//点选框向上
		final JRadioButton downButton=new JRadioButton("向下(U)");//点选框向下
		downButton.setSelected(true);//可选择
		bGroup.add(upButton);//向上
		bGroup.add(downButton);//向下
		JButton cancel=new JButton("取消");
		//取消按钮事件处理
		cancel.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{	
				findDialog.dispose();
			}
		});
		//"查找下一个"按钮监听
		findNextButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{	//"区分大小写(C)"的JCheckBox是否被选中
				int k=0;
				final String str1,str2,str3,str4,strA,strB;
				str1=TextFrame.editArea.getText();//获取文档文本
				str2=findText.getText();//获取查找文本
				str3=str1.toUpperCase();//转换大写
				str4=str2.toUpperCase();//转换大写
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
				if(upButton.isSelected())//如果向上查找
				{	
					if(TextFrame.editArea.getSelectedText()==null)//如果选中文本为空
						k=strA.lastIndexOf(strB,TextFrame.editArea.getCaretPosition()-1);//获取位置
					else//如果选中文本非空
						k=strA.lastIndexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()-1);//获取位置
					if(k>-1)//找到了
					{	
						TextFrame.editArea.setCaretPosition(k);
						TextFrame.editArea.select(k,k+strB.length());//选中查找到的文本
					}
					else//没找到
					{	
						JOptionPane.showMessageDialog(null,"找不到您查找的内容！","查找",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(downButton.isSelected())//如果向下查找
				{	
					if(TextFrame.editArea.getSelectedText()==null)//如果选中文本为空
						k=strA.indexOf(strB,TextFrame.editArea.getCaretPosition()+1);//获取位置
					else//如果选中文本非空
						k=strA.indexOf(strB, TextFrame.editArea.getCaretPosition()-findText.getText().length()+1);	//获取位置
					if(k>-1)//如果找到
					{	
						TextFrame.editArea.setCaretPosition(k);
						TextFrame.editArea.select(k,k+strB.length());//选中找到的
					}
					else//如果没找到
					{	
						JOptionPane.showMessageDialog(null,"找不到您查找的内容！","查找",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});//"查找下一个"按钮监听结束
		//创建"查找"对话框的界面
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel directionPanel=new JPanel();
		directionPanel.setBorder(BorderFactory.createTitledBorder("方向"));
		//设置directionPanel组件的边框;
		//BorderFactory.createTitledBorder(String title)创建一个新标题边框，使用默认边框（浮雕化）、默认文本位置（位于顶线上）、默认调整 (leading) 以及由当前外观确定的默认字体和文本颜色，并指定了标题文本。
		directionPanel.add(upButton);//upButton添加到directionPanel
		directionPanel.add(downButton);//downButton添加到directionPanel
		panel1.setLayout(new GridLayout(2,1));//布局方式
		panel1.add(findNextButton);//findNextButton添加到panel1
		panel1.add(cancel);//cancel添加到panel1
		panel2.add(findContentLabel);//findContentLabel添加到panel2
		panel2.add(findText);//findText添加到panel2
		panel2.add(panel1);//panel1添加到panel2
		panel3.add(matchCheckBox);//matchCheckBox添加到panel3
		panel3.add(directionPanel);//directionPanel添加到panel3
		con.add(panel2);//panel2添加到con
		con.add(panel3);//panel3添加到con
		findDialog.setSize(410,180);//设置大小
		findDialog.setResizable(false);//不可调整大小
		findDialog.setLocation(230,280);//设置位置
		findDialog.setVisible(true);
	}//查找方法结束
}//结束类：Find
