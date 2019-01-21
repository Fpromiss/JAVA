package Two;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

//begin class MouseHandler 
public class MouseHandler implements MouseListener,MouseMotionListener{
	private Graphic temp;//图形类 
	private int x1,y1;//mouse pressed 时候的坐标
	private int x2,y2;//mouse Released 时候的坐标
    private int temp1,temp2;//mouse drag时候的坐标
	public static ArrayList<Graphic> list=new ArrayList<Graphic>();//图形类型的list 用于记录画图形历史
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//当鼠标按下的时候
	//begin method
	public void mousePressed(MouseEvent e) {
		x1=e.getX();//获取x坐标
		y1=e.getY();//获取y坐标
		temp=new Graphic();//新图形
		list.add(temp);//加入list
	}//end method

	@Override
	//鼠标释放的时候
	//begin method 
	public void mouseReleased(MouseEvent event) {
		x2=event.getX();//获取释放时候的x坐标
		y2=event.getY();//获取释放时候的Y坐标

	    list.remove(list.size()-1);//删除中间drag时候画出来的 留下的 最后一个图形
		temp.set_posi(x1,y1,x2,y2);//设置图形参数
		list.add(temp);//加入list
		Graphics g=Shape.panel.getGraphics();//get g
		g.setColor(Color.white);//设置颜色 白色
		g.fillRect(0, 0, 2000, 2000);//清空画布
		for(Graphic t:list)//重画
		{
			t.draw();
		}//end circle
	}//end method

	@Override
	//鼠标drag时候
	//begin method
	public void mouseDragged(MouseEvent event) {
		temp1=event.getX();//获取每个瞬间的鼠标drag x坐标
		temp2=event.getY();//获取每个瞬间的鼠标drag y坐标

	    list.remove(list.size()-1);//删除前一个移动中间图形 
		temp.set_posi(x1,y1,temp1,temp2);//设置当前移动中间图形的参数
		list.add(temp);//加入 list
		Graphics g=Shape.panel.getGraphics();//get g
		g.setColor(Color.white);//设置颜色 白色
		g.fillRect(0, 0, 2000, 2000);//清空画布
		for(Graphic t:list)//重画
		{
			t.draw();
		}//end circle	
	}//end method

	@Override
	public void mouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub
	}
	//begin method
	public void get_list(ArrayList<Graphic> t)
	{
		list=t;
	}//end method
}//end class

