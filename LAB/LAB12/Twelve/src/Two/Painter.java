package Two;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

//类：Painter 继承JPanel，用于子窗口
public class Painter extends JPanel {
	   /**
	 * 
	 */
	   private static final long serialVersionUID = 1L;
	   private  ArrayList<Shape> allGraphics =new ArrayList<Shape>();//存所有图形
	   private  ArrayList<Shape> allGraphics_backups =new ArrayList<Shape>();
	   
	   private JRadioButton filled;//填充
	   private JRadioButton gradient;//渐变
	   
	   private JButton undo;//撤销
	   private JButton clear;//清空
	   private JButton color1;//颜色1
	   private JButton color2;//颜色2
	   
	   private JLabel shape;//形状
	   private JLabel lineWidth;//线条宽度
	   
	   private JComboBox<String> shapeChoice;//形状选择
	   private JTextField widthField;//线条宽度输入框
	   
	   private JPanel drawArea;//画布
	   private String[] shapeType={"Line","Oval","Rectangle"};//图形形状
	   
	    private Shape temp =new Line(); //当前临时图形
	    int lineW = 1;//线条宽度默认1
	    boolean fill = false;//默认不填充
	    boolean grd = false;//默认不渐变
	    Color c1=Color.BLACK;//默认颜色黑色
	    Color c2=Color.GRAY;//默认颜色灰色
	   
	    //构造函数
	   Painter(){		   		           
           //设置layout方式
		   setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		   	   
		   ButtonHandler bHandler = new ButtonHandler();//创建ButtonHandler
		   JPanel temp1 = new JPanel();//创建JPanel temp1 ,用于第一行放置按钮
		   temp1.setMaximumSize(new Dimension(640,50));//设置窗体大小 动态
		   undo = new JButton("Undo");//创建撤销按钮
		   clear = new JButton("Clear");//创建清空按钮
	       shape = new JLabel("Shape: ");//创建”shape“label
		   filled = new JRadioButton("Filled");//创建“filled”勾选框
		     
		   shapeChoice = new JComboBox<String>();//创建图形选择框
		     for(int i=0;i<shapeType.length;i++){
		    	 shapeChoice.addItem(shapeType[i]);
		     }//图形勾选框选项
		   undo.addActionListener(bHandler);//监听撤销按钮
		   clear.addActionListener(bHandler);//监听清空按钮
		   shapeChoice.addActionListener(bHandler);//监听图形选择框
		   filled.addActionListener(bHandler);//监听填充勾选框
		   temp1.add(undo);//undo 添加到 temp1
		   temp1.add(clear);//clear 添加到 temp1
           temp1.add(shape);//shape 添加到 temp1
	       temp1.add(shapeChoice);//shapeChoice 添加到 temp1
		   temp1.add(filled);//filled 添加到 temp1
		     
		   JPanel temp2 = new JPanel();//创建JPanel temp2，用于放置第二行按钮
		   temp2.setMaximumSize(new Dimension(640,50));//设置大小
		   gradient = new JRadioButton("Use Gradient");//创建是否渐变	     
		   color1 = new JButton("1st Color..");//创建颜色1
		   color2 = new JButton("2st Color..");//创建颜塞2
		   
           lineWidth = new JLabel("Line Width: ");//创建“Line Width:”label
		   widthField = new JTextField();//创建线条宽度输入框	  
		   widthField.setPreferredSize(new Dimension(25,20));//设置线条宽度输入框大小
	       widthField.addActionListener(new TextFieldHandler());//监听输入
		  
		   color1.addActionListener(bHandler);//监听颜色1
		   color2.addActionListener(bHandler);//监听颜色2
		   gradient.addActionListener(bHandler);//监听是否渐变
		   
		   temp2.add(gradient);//gradient 添加到temp2
		   temp2.add(color1);//color1 添加到temp2
		   temp2.add(color2);//color2 添加到temp2
	       temp2.add(lineWidth);//lineWidth 添加到temp2
	       temp2.add(widthField);//widthField 添加到temp2
		   		   
		   drawArea = new mousePanel();//创建画布
		   drawArea.setBackground(Color.WHITE);//设置画布背景颜色白色
		   drawArea.setPreferredSize(new Dimension(600,400));//设置画布大小
		   	    
		   add(Box.createVerticalStrut (5));//添加空格
		   add(temp1); //添加第一行
		   add(Box.createVerticalStrut (5));//添加空格
		   add(temp2);//添加第二行
           add(drawArea);//添加画布
	   }//结束方法
	   
	   //重写方法：paintComponent(Graphics g)
	  protected void paintComponent(Graphics g){
            for(Shape i:allGraphics)//画出之前存的图形
              i.drawShape(g); 	             
            temp.drawShape(g);//画当前图形
      }//结束方法
		
       //内部类： mousePanel ，继承：JPanel
	   private class mousePanel extends JPanel{    
	        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//构造函数
		public mousePanel(){
			   //监听鼠标事件
	           addMouseListener( new MouseAdapter(){
	        	        //鼠标点击时候
	                    public void mousePressed(MouseEvent e){
	                          temp.setPoint1(new Point(e.getX(),e.getY()));//设置当前图形的p1                         
	                    }//结束方法
	                            
	                    //鼠标释放的时候
	                    public void mouseReleased(MouseEvent e){
	                    	temp.setPoint2(new Point(e.getX(),e.getY()));//设置当前图形的p2
	                    	//allGraphics_backups复制allGraphics的值，即存除了当前图形之外的图形
	                    	allGraphics_backups = (ArrayList<Shape>) allGraphics.clone();
	                    	allGraphics.add(temp);//把当前图形加入list
	                    	
	                    	//如果选择了line 
                            if(((String)shapeChoice.getSelectedItem()).equals("Line"))
                            	temp = new Line(lineW,fill,grd,c1,c2);
                            //如果选择了椭圆
                            else if(((String)shapeChoice.getSelectedItem()).equals("Oval"))
                            	temp = new Oval(lineW,fill,grd,c1,c2);
                            //如果选择了矩形
                            else if(((String)shapeChoice.getSelectedItem()).equals("Rectangle"))
                            	temp = new Rectangle(lineW,fill,grd,c1,c2);
                            //重画
	                    	repaint();
	                    }
	          });
	              
	           addMouseMotionListener( new MouseAdapter(){
	        	 //当鼠标拖动的时候
	        	   public void mouseDragged(MouseEvent e){
	        		  temp.setPoint2(new Point(e.getX(),e.getY()));//设置当前图形p2
	                  repaint();//重画
	               }
	         });
	       }
	          
		    //重写函数：paintComponent(Graphics g)
			protected void paintComponent(Graphics g){
	             super.paintComponent(g);//父类方法
	             for(Shape i:allGraphics)//画之前的所有图形
	               i.drawShape(g); 	             
	             temp.drawShape(g);//画当前拖动临时图形
	       }		
		}//结束类：mousePanel

	  //内部类：ButtonHandler，继承ActionListener
	  private  class ButtonHandler implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
	    		//如果清空
	            if(e.getSource()==clear){
	            	allGraphics_backups = (ArrayList<Shape>) allGraphics.clone();//allGraphics_backups存所有图形
	            	allGraphics.clear();//清空
	            	repaint();//重画
	            }
	            //如果撤销
	            else if (e.getSource()==undo){
	            	//如果画布上是空的，没有图形
	            	if(allGraphics.isEmpty())
	            		allGraphics=(ArrayList<Shape>) allGraphics_backups.clone();//保留上一步的值（空）
	            	else if (allGraphics.size()==1){//如果画布上只有一个图形，这时候撤销，就是回到空画布
	            		allGraphics.clear();//清空
	            		allGraphics_backups.clear();//清空
	            	}
	            	else//如果画布上不止一个图形，撤销就减去一个图形  
	            		allGraphics.remove(allGraphics.size()-1);
	                repaint();//重画
	            }  
	            //如果是filled
	            else if(e.getSource()==filled){
	            	if(filled.isSelected()) {
	            		fill = true;//如果选择，那么设置fill 为true
	            	}
	            	else fill =false;//否则设置为false
	            	temp.fill=fill;//设置fill的值
	            }
	            //如果是gradient
	            else if(e.getSource()==gradient){
                 if(gradient.isSelected()){//如果gradient被选中
                	 grd =true; 	 //_grd设置为true
                 }
                 else grd = false;//否则设置为false
                 temp.grd = grd; //设置当前_grd的值
	            }	
	            //如果是选中形状
	            else if (e.getSource()==shapeChoice){
	            	//如果选了line
                    if(((String)shapeChoice.getSelectedItem()).equals("Line"))
                    	temp = new Line(lineW,fill,grd,c1,c2);
                    //如果选了Oval
                    else if(((String)shapeChoice.getSelectedItem()).equals("Oval"))
                    	temp = new Oval(lineW,fill,grd,c1,c2);
                    //如果选了Rectangle
                    else if(((String)shapeChoice.getSelectedItem()).equals("Rectangle"))
                    	temp = new Rectangle(lineW,fill,grd,c1,c2);
	            }  
	            //如果选了颜色1
	            else if(e.getSource()==color1){
	            	JColorChooser chooser=new JColorChooser();
	                c1=chooser.showDialog(chooser,"选取颜色",Color.LIGHT_GRAY);
	                temp.c1 =c1;//设置颜色1
	            }
	            //如果选了颜色2
	            else if(e.getSource()==color2){
	            	JColorChooser chooser=new JColorChooser();
	                c2=chooser.showDialog(chooser,"选取颜色",Color.LIGHT_GRAY);
	                temp.c2 =c2;//设置颜色2
	            }
	    }//结束方法：actionPerform
	 }//结束类：ButtonHandler
	   
	  //内部类：TextFieldHandler，继承ActionListener
	  private  class TextFieldHandler implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
	    		if(e.getSource()==widthField){//如果是输入线条宽度
	    			temp.lineW=Integer.parseInt(widthField.getText());//获取线条宽度
	    			lineW = Integer.parseInt(widthField.getText());
	    		}    			
	    	}//结束方法 actionPerformed(ActionEvent e) 
    }//结束类：TextFieldHandler
}//结束类：Painter