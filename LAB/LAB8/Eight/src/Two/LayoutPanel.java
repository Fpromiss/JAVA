package Two;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//begin class LayoutPanel
public class LayoutPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button clear=new Button("Clear");//清屏
	private Button undo=new Button("Undo");//撤销一步
	private JLabel label1=new JLabel("Shape:");//label 图形
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//图形名称 直线 圆 矩形
	public JComboBox shape_choose=new JComboBox(
			new String[]{"Line","Oval","Rectangle"});
	//图形选择框
	private JCheckBox is_fill =new JCheckBox();
	private JLabel label2=new JLabel("Filled");//label 填充
	
	private JCheckBox is_gradient =new JCheckBox();//勾选框 渐变
	private JLabel label3=new JLabel("Use Gradient");//label 勾选
	
	private Button color1=new Button("1st Color...");//button 一种颜色
	private Button color2=new Button("2nd Color...");//button 两种颜色
	
	private JCheckBox is_dash=new JCheckBox();//勾选框 是否使用虚线
	private JLabel label6=new JLabel("Dashed");//label 虚线
	
	private JLabel label4=new JLabel("Line width:");//label 线条宽度
	private JLabel label5=new JLabel("Dash Length:");//label 虚线长度
	private JTextField text1 =new JTextField(3);//输入框
	private JTextField text2 =new JTextField(3);//输入框
	
	public static Color color_c1=Color.BLACK;//颜色1
	public static Color color_c2=Color.BLACK;//颜色2

	//begin method LayoutPanel()
	LayoutPanel()
	{
		super(new BorderLayout());
		JPanel line1=new JPanel();//第一行按钮
		add(line1);//把line1加入 l_panel
		line1.add(undo);//undo button 加入line1
		line1.add(clear);//clear button 加入line1
		line1.add(label1);//label1 图形加入line1
		shape_choose.setMaximumRowCount(3);//三种选择
		line1.add(shape_choose);//add line1
		line1.add(is_fill);//add line1
		line1.add(label2);//add line1
        
		//撤销功能
		undo.addActionListener(
				new ActionListener(){
                    //响应撤销
					public void actionPerformed(ActionEvent event) {
						MouseHandler.list.remove(MouseHandler.list.size()-1);//删除最新一步
						Graphics g=Shape.panel.getGraphics();//get g
						g.setColor(Color.white);//设置颜色 白色
						g.fillRect(0, 0, 2000, 2000);//清空画板
						for(Graphic t:MouseHandler.list)//画剩余的图形
						{
							t.draw();
						}//end circle
					}//end method	
				});//end listen undo
		
		//清空功能
		clear.addActionListener(
				new ActionListener(){
					//响应清空
					public void actionPerformed(ActionEvent event) {
						Graphics g=Shape.panel.getGraphics();//get g
						g.setColor(Color.white);//设置颜色 白色
						g.fillRect(0, 0, 2000, 2000);//清空画板
						MouseHandler.list.clear();//清空数据
				}//end method
			});//end listen
		
		//第一种颜色选择
		color1.addActionListener(
				new ActionListener(){
                    //响应颜色选择
					@SuppressWarnings("unused")
					public void actionPerformed(ActionEvent event) {
						JColorChooser jcc=new JColorChooser();
						//选择颜色 默认黑色
						color_c1=JColorChooser.showDialog(Shape.window, "选择", Color.BLACK);
					}//end method
				});//end listen
		
		//第二种颜色
		color2.addActionListener(
				new ActionListener(){
                    //响应颜色选择	
					public void actionPerformed(ActionEvent event) {					
						@SuppressWarnings("unused")
						JColorChooser jcc=new JColorChooser();
						//颜色选择 默认黑色
						color_c2=JColorChooser.showDialog(Shape.window, "选择", Color.BLACK);
					}//end method
				});//end listen
		
		//第二行的功能按钮
		JPanel line2=new JPanel();
		add(line2,BorderLayout.SOUTH);//布局 南 
		line2.add(is_gradient);//is_gradient 加入line2
		line2.add(label3);//label3 加入line2
		line2.add(color1);//color 加入line2
		line2.add(color2);//color2 加入line2
		line2.add(label4);//label4 加入line2
		line2.add(text1);//text1 加入line2
		line2.add(label5);//label5 加入line2
		line2.add(text2);//text2 加入line2
		line2.add(is_dash);//is_dash 加入line2
		line2.add(label6);//label6加入line2
	}//end method 
	
	//获取信息函数
	//begin method
	public void get_info(Graphic temp)
	{
		temp.shape=(String) shape_choose.getSelectedItem();//获取图形形状
		temp.is_filled=is_fill.isSelected();//获取是否填充
		temp.is_grad=is_gradient.isSelected();//获取是否渐变
		temp.this_c1=color_c1;//获取第一种颜色
		temp.this_c2=color_c2;//获取第二种颜色
		if(!text1.getText().isEmpty())//获取线宽度（如果有输入 获取）
		temp.line_w=Integer.parseInt(text1.getText());
		else temp.line_w=1;//如果没有输入线宽度 那么就是1
		if(!text2.getText().isEmpty()&&is_dash.isSelected())//如果输入了虚线长度 并且选择了虚线
		temp.dash_l=Integer.parseInt(text2.getText());//获取虚线长度
		else temp.dash_l=1;//否则  如果没有输入虚线长度 或者 没有选择虚线 虚线长度置为1
		temp.is_dash=is_dash.isSelected();////获取是否选择虚线
	}//end method get_info
	
	//begin method
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}//end method 
}//end class

