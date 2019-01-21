package Three;

import java.security.SecureRandom;
import java.util.Arrays;
//类：SimpleArray
public class SimpleArray {

	private static final SecureRandom genetator=new SecureRandom();
	private final int [] array;
	private int writeIndex=0;//数组下标
	
	//创建一个大小为size的数组
	public SimpleArray(int size)
	{
		array=new int [size];
	}//结束方法
	
	//为数组添加一个值为value的元素
	public synchronized boolean add(int value)
	{
		//如果数组角标等于50 说明已经生成了50个元素了 ，那么此时结束添加
		if(writeIndex==50)
			{
			System.out.printf("%s have done\n",
					Thread.currentThread().getName());
			return true;
			}
		int position=writeIndex;//记录下标
		try
		{
			//当前线程随机睡眠
			Thread.sleep(genetator.nextInt(500));
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		array[position]=value;//记录数组值
		System.out.printf("%s wrote %2d to element %d.%n",
				Thread.currentThread().getName(),value,position);//输出console
		++writeIndex;//下标加1
		return false;//返回false说明还没有生成50个元素
	}//结束方法
	
	//转换为字符串
	public synchronized String toString()
	{
		return Arrays.toString(array);
	}//结束方法
}//结束类：SimpleArray
