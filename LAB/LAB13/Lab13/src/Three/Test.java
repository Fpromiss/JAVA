package Three;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//类：Test
public class Test {
     //main方法
	public static void main(String[] args)
	{
		SimpleArray shared=new SimpleArray(50);//创建一个大小为50的数组
		//线程1-5
		ArrayWriter writer1=new ArrayWriter(shared);
		ArrayWriter writer2=new ArrayWriter(shared);
		ArrayWriter writer3=new ArrayWriter(shared);
		ArrayWriter writer4=new ArrayWriter(shared);
		ArrayWriter writer5=new ArrayWriter(shared);
		
		//线程池接口
		ExecutorService executor=Executors.newCachedThreadPool();
		//执行线程
		executor.execute(writer1);
		executor.execute(writer2);
		executor.execute(writer3);
		executor.execute(writer4);
		executor.execute(writer5);
		//结束
		executor.shutdown();
	}//结束main方法
}//结束类：Test
