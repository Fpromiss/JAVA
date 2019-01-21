package Three;

import java.util.Random;
//类： ArrayWriter
public class ArrayWriter implements Runnable{
	private final SimpleArray sharedSimpleArray;
	private static final Random genetator=new Random();
	//构造函数
	public ArrayWriter(SimpleArray sharedSimpleArray) {
		this.sharedSimpleArray = sharedSimpleArray;
	}//结束方法
	
	//run方法
	public void run()
	{
		//当线程生成元素小于50个时候，返回false，持续循环
		while(true){
			if(sharedSimpleArray.add((genetator.nextInt(6)+1)))
				break;			
		}//结束循环
	}//结束方法
}//结束类： ArrayWriter

