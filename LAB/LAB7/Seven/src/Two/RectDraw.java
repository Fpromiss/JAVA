package Two;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//begin class RectDraw
public class RectDraw extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int orgx, orgy;//begin point location
	int endx, endy;//end point location
    int finalx,finaly;//finally point location
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    int rec_point[]=new int[10000];//get rectangle begin and final point
    int rec_key=1;//the sub for rectangle point
    
    int line_point[]=new int[10000];//get line begin and final point
    int line_key=1;//the sub for line point
    
    JRadioButton jrb1, jrb2,jrb3;//choose button for line ,rectangle and clear
    JPanel jp;//_jpanel for set line, rectangle and clear button
    
    //begin method
    public RectDraw() {
   	 setTitle("拖动画图！");//set title
   	 setResizable(false);//can not change size
   	 setSize(500,300);//set size
     setVisible(true);
        
     jrb1 = new JRadioButton("直线");//create line button
	 jrb2 = new JRadioButton("矩形");//create rectangle button
	 jrb3 = new JRadioButton("清空");//create clear button
	 ButtonGroup bg = new ButtonGroup();//button group
	 bg.add(jrb1);//add to button group
	 bg.add(jrb2);//add to button group
	 bg.add(jrb3);//add to button group
     jp = new JPanel();//create _jpanel object
	 jp.add(jrb1);//add to _jpanle
	 jp.add(jrb2);//add to _jpanel
	 jp.add(jrb3);//add to _jpanel
	 add(jp);//add _jpanel to _jframe
		
	 //add listen to mouse press
     this.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
             orgx = e.getX();//get begin point x
             orgy = e.getY();//get begin point y
             int flag=getJrb();//get button type
             if(flag==1){//if choose line
             line_point[line_key]=orgx;//set line begin point x
             line_point[line_key+1]=orgy;//set line begin point y
             }
             else if(flag==2){//if choose rectangle
                rec_point[rec_key]=orgx;//set rectangle point x
                rec_point[rec_key+1]=orgy;//set rectangle point y
             }        
          }
      });//end listen mouse press
        
     //add listen to mouse released
     this.addMouseListener(new MouseAdapter(){
       	 public void mouseReleased(MouseEvent e)
         {
       		 finalx=e.getX();//get final point x
       		 finaly=e.getY();//get final point y
       		 int flag=getJrb();//get choose type
       		 if(flag==1){//if choose line
       			 line_point[line_key+2]=finalx;//set line final point x
       			 line_point[line_key+3]=finaly;//set line final point y
       			 line_key=line_key+4;//sub +4
       		 }
       		 else if(flag==2){//if choose rectangle
           		 rec_point[rec_key+2]=finalx;//set rectangle final point x
           		 rec_point[rec_key+3]=finaly;//set rectangle final point y
           		 rec_key=rec_key+4;//sub+4
       		 }
    	 }  
     });//end listen mouse released
        
     //add listen to mouse drag
     this.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent e) {
           	 int flag=getJrb();//get choose type
             endx = e.getX();//get end point x
             endy = e.getY();//get end point y
             Graphics g = getGraphics();//get g
             g.clearRect(0, 0, d.width, d.height);//clear 
             g.setColor(Color.BLUE);//set color
             if(flag==3){//if choose to clear
      			line_key=1;//set line sub = 1
       			rec_key=1;//set rectangle sub = 1
       		 }
       		 else if(flag==1){//if choose line
              	 g.drawLine(orgx, orgy, endx, endy);//draw the last line
             }
             else if(flag==2){//if choose rectangle
                 g.drawRect(orgx, orgy, endx - orgx, endy - orgy);//draw the last rectangle
             }
             paintFormat(flag);//draw format line or rectangle
          }
     });//end listen mouse drag
  
}//end method RectDraw();
    
    //begin method paintFormat
    public void paintFormat(int flag){
   	 Graphics g = getGraphics();//get g
   	 if(flag==1){//if choose line
   		 //draw format line
   		 for(int i=1;i<line_key;i=i+4){
       		 g.drawLine(line_point[i],line_point[i+1],line_point[i+2],line_point[i+3]);
       	 }
   	 }
   	 else if(flag==2){//if choose rectangle
   		 //draw format rectangle
   		 for(int i=1;i<rec_key;i=i+4){
       		 g.drawRect(rec_point[i],rec_point[i+1],rec_point[i+2]-rec_point[i],rec_point[i+3]-rec_point[i+1]);
       	 } 
   	 }
    }
    
    //get choose type
    public int getJrb()		//判断判断并返回选择的是哪个单选按钮
	 {
			int jrb=1;
			if(jrb1.isSelected())//if the line button is selected
				jrb = 1;//type=1
			else if(jrb2.isSelected())//if the rectangle is selected
				jrb = 2;//type=2
			else if(jrb3.isSelected())//if the clear is selected
				jrb = 3;//type=3
			return jrb;//return type;
	}//end method getJrb;
    
}//end class RectDraw;
