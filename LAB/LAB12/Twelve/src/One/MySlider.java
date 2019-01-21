package One;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//begin class MySlider
public class MySlider extends JFrame implements ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JSlider slider;
	private MyPanel mypanel;
	
	//begin method
	MySlider(){
		super();
		
		slider=new JSlider(JSlider.HORIZONTAL,0,50,20);//设置最小值0，最大值50，初始值20
		slider.setMajorTickSpacing(10);//10等分
		slider.setMinorTickSpacing(1);//刻度1
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		mypanel=new MyPanel();//create _mypanel
		
		add(slider,BorderLayout.CENTER);//add
		add(mypanel,BorderLayout.SOUTH);//add
		
		slider.addChangeListener(this);//listen to slider
	}//end method

	@Override
	//react to slider
	public void stateChanged(ChangeEvent event) {
		// TODO Auto-generated method stub
		  JSlider source = (JSlider) event.getSource();
	        if (source.getValueIsAdjusting() != true) {
	              mypanel.repaint();//repaint 
	        }
	}//end method
}//end class
