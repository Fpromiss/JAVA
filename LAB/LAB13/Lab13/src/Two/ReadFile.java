package Two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
//类： ReadFile
public class ReadFile {
	private Scanner input;//输入
	private ArrayList<Student>tetrieve = new ArrayList<Student>();//存学生信息list
	//方法：打开文件
	  public void openFile(String fileName){
		  try{
			  input = new Scanner(new File(fileName));//打开文件
		  }
		  catch(FileNotFoundException fileNotFoundException){//异常处理
			  System.err.println("Open file error");
			  System.exit(-1);
		  }
	  }//结束方法
	  
	//方法：读取所有学生信息
	  public void readStudent_Info(){ 
		  tetrieve.clear();//list先清空
		  Student temp=new Student();//一个临时学生对象
		  tetrieve.add(temp);//这个temp加入list是为了删除第一个的时候不会下标越界
		  
		  try{
			  while(input.hasNext()){//一直到非空
				  Student stu=new Student();//读学生信息
				  stu.set_student_number(input.next());
				  stu.set_student_name(input.next());
				  stu.set_student_tel(input.next());
				  stu.set_student_email(input.next());
				  tetrieve.add((Student)stu);//放入map中	  
			  }
		  }		
		  catch(NoSuchElementException elementException){//异常处理1
			  System.err.println("File improperly formed.");
			  input.close();
			  System.exit(1);
		  }
		  catch(IllegalStateException stateException){//异常处理2
			  System.err.println("Error reading from file");
			  System.exit(1);
		  }
	  }//结束方法
	  
	//方法：getTetrieve()，获取map
	  public ArrayList<Student> getTetrieve() {
		return tetrieve;
	   }//结束方法
	  
	  //方法：关闭文件
	   public void closeFile(){
		  if(input != null)//文件存在
			  input.close();//关闭
	   }//结束方法
}
