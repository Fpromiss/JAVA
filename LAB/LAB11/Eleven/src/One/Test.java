package One;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
//begin class Test
public class Test {
	//begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);//create object Scanner
        Student student[]=new Student[4];//the four student
        String num;//student number
        String name;//student name
        String stu_class;//student class
        int score;//student score
        
        System.out.println("请依次输入四个学生的信息"); //output
        for(int i=0;i<4;i++){//for circle to input
        	System.out.print("请输入学生学号：");//out
        	num=scan.nextLine();//in
        	System.out.print("请输入学生姓名：");//out
        	name=scan.nextLine();//in
        	System.out.print("请输入学生班级：");//out
        	stu_class=scan.nextLine();//in
        	System.out.print("请输入学生已修学分：");//out
        	score=scan.nextInt();//in
        	student[i]=new Student();//create student object
        	student[i].set(num, name, stu_class, score);//set student information
        	scan.nextLine();//in line
        }//end for circle
        
        //the first function
        System.out.println("(1)按照输入顺序输出所有学生信息:");
        List<Student> stu=Arrays.asList(student);//set array list
        stu.stream().forEach(s->s.display());//out student by original 
        
        //the second function
        System.out.println("(2)按照先按班级再按学号排序的顺序输出所有学生信息:");
        stu.stream().sorted((s1,s2)->{
             if(s1.getstuClass().equals(s2.getstuClass())){
            	return s1.getStuNumber().compareTo(s2.getStuNumber()); 
             }
             return s1.getstuClass().compareTo(s2.getstuClass());
        }//sort student
        ).forEach(s->s.display());//output
        
        //the third function ,output average score
        System.out.printf("(3)输出全部学生所修学分的平均分:%f\n",stu.stream().mapToDouble(s->s.getScore()).summaryStatistics().getAverage());
        
        //the forth function
        System.out.println("(4)分班级分组输出所有学生");
        Map<String,List<Student>>group= stu.stream().collect(Collectors.groupingBy(s->s.getstuClass()));
        for (String s : group.keySet()) {
        	System.out.println("class:" + s);
        	group.get(s).forEach(g->g.display(1));
        	}//group student by class
	}//end method main
}//end class Test
