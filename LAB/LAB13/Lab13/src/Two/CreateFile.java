package Two;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//类：CreateFile
public class CreateFile {
	FileWriter fw ;
	
	//方法：openFile(String fileName)，打开文件，此时如果写文件是以追加方式
	  public void openFile(String fileName){
		  try{
			 fw =new FileWriter(fileName,true);//创建一个FileWriter
		  }
		 catch (IOException e) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null,"打开文件失败！","Error",JOptionPane.INFORMATION_MESSAGE);
		}
	  }//结束方法
	  
	  //方法：openFile(String fileName，Boolean over)，打开文件，此时如果写文件，以覆盖的方式
	  public void openFile(String fileName,boolean over){
		  try{
			  fw=new FileWriter(fileName,false);//创建一个FileWriter
		  }
		  catch (IOException e) {
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null,"打开文件失败！","Error",JOptionPane.INFORMATION_MESSAGE);
			}
	  }//结束方法
	  
	  //方法：add_student_infor(String temp)，添加一条学生信息，参数temp是用户输入的用于添加的学生信息
	  public void add_student_infor(String temp){
		  Student stu= new Student();//创建一个学生对象	 
		  ReadFile read_former=new ReadFile();//创建一个ReadFile 对象read_former
		  read_former.openFile("student.txt");//read_former打开文件student.txt
		  ArrayList<Student> list=read_former.getTetrieve();//获取读入所有学生信息的Arraylist
		  read_former.closeFile();//关闭文件student.txt
		 		
		 try {
                String[] s = temp.split("\\s+");//将一行按照空格分隔
	 			  
				stu.set_student_number(s[0]);//设置学号
			    stu.set_student_name(s[1]);//设置姓名
			    stu.set_student_tel(s[2]);//设置电话
			    stu.set_student_email(s[3]);//设置邮箱
	            //检查是否满足学号、姓名、电话、邮件的要求
			    if(stu.check_student_info()){
					  list.add(stu);//当前学生加入list
					  for(int i=0;i<list.size();++i){//依次写入文件
						  fw.write(list.get(i).get_student_number()+" ");
						  fw.write(list.get(i).get_student_name()+" ");
						  fw.write(list.get(i).get_student_tel()+" ");
						  fw.write(list.get(i).get_student_email()+" ");	  
					  }
					  //输出成功
					  JOptionPane.showMessageDialog(null,"添加学生信息成功！","添加学生成功",JOptionPane.INFORMATION_MESSAGE);
				   }	
		   }
		  catch (IOException e) {
	           System.out.println("文件写入失败！");
	       }  	 	  
	  }//方法
	
	//方法：write_file(ArrayList<Student> list)，用list中的信息把原文件完全覆盖
	public void write_file(ArrayList<Student> list){
		for(int i=0;i<list.size();++i){//遍历list
			try {
				//依次写入文件
				fw.write(list.get(i).get_student_number()+" ");
				fw.write(list.get(i).get_student_name()+" ");
			    fw.write(list.get(i).get_student_tel()+" ");
			    fw.write(list.get(i).get_student_email()+" ");	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
		}//结束for循环
	}//结束方法
	  
	 //方法：关闭文件
	  public void closeFile(){
		  if(fw != null)
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"关闭文件失败！","Error",JOptionPane.INFORMATION_MESSAGE);
			}//关闭文件
	  }//结束方法  
}//结束类：CreateFile
