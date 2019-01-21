package Two;

import javax.swing.JOptionPane;

//类：Student
public class Student {
	String student_number;//学号
	String student_name;//姓名
	String student_tel;//电话
	String student_email;//邮箱
	
	//构造函数
	Student(){
		student_number="";
		student_name="";
		student_tel="";
		student_email="";
	}//结束方法
	
	//带参数的构造函数
	Student(String student_number,String student_name,String student_tel,String student_email){
		this.student_number=student_number;
		this.student_name=student_name;
		this.student_tel=student_tel;
		this.student_email=student_email;
	}//结束方法
	
	//方法：获取学生学号
	public String get_student_number(){
		return student_number;
	}//结束方法
	
	//方法:设置学生学号
	public void set_student_number(String student_number){
		this.student_number=student_number;
	}//结束方法
	
	//方法：获取学生姓名
	public String get_student_name(){
		return student_name;
	}//结束方法
	
	//方法：设置学生姓名
	public void set_student_name(String student_name){
		this.student_name=student_name;
	}//结束方法
	
	//方法：获取学生电话
	public String get_student_tel(){
		return student_tel;
	}//结束方法
	
	//方法：设置学生电话
	public void set_student_tel(String student_tel){
		this.student_tel=student_tel;
	}//结束方法
	
	//方法：获取学生邮箱
	public String get_student_email(){
		return student_email;
	}//结束方法
	
	//方法：设置学生邮箱
	public void set_student_email(String student_email){
		this.student_email=student_email;
	}//结束方法
	
	//方法：检查学生学号、姓名、电话、邮箱是否满足要求
	 public boolean check_student_info(){
		boolean f1=true;
		//学生学号长度应该在3-15
		if(student_number.length()<3||student_number.length()>15){
			JOptionPane.showMessageDialog(null,"学生学号长度应该在3-15","添加学生信息有误",JOptionPane.INFORMATION_MESSAGE);
			f1=false;
		}
		//学生姓名长度应该在1-10
		else if(student_name.length()<=0||student_name.length()>10){
			JOptionPane.showMessageDialog(null,"学生姓名长度应该在1-10","添加学生信息有误",JOptionPane.INFORMATION_MESSAGE);
			f1=false;
		}
		//学生电话长度应该在5-15
		else if(student_tel.length()<5||student_tel.length()>15){
			JOptionPane.showMessageDialog(null,"学生电话长度应该在5-15","添加学生信息有误",JOptionPane.INFORMATION_MESSAGE);
			f1=false;
		}
		//学生邮箱应该正则匹配
		else if(student_email.matches("[a-zA-Z_]{1,}[a-zA-Z0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,}[a-zA-z\\-]{1,}")==false){
			JOptionPane.showMessageDialog(null,"学生邮箱格式错误","添加学生信息有误",JOptionPane.INFORMATION_MESSAGE);
			f1=false;
		}
		 return f1;//返回是否匹配
	  }//结束方法
}//结束类：Student
