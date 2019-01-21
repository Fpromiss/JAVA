package Two;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//类：StudentFrame，继承JFrame
public class StudentFrame extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton add;//增加
    private JButton delete;//删除
    private JButton change;//修改
    private JButton search;//查询
    private JButton show;//显示
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    private JButton next_line;//上一个
    private JButton former_line;//下一个
    
    private JLabel number,name,tel,email;//学号、姓名、电话、邮箱label
    private JTextField Tnumber,Tname,Ttel,Temail;//学号、姓名、电话、邮箱输入/显示
    
    StudentFrame(){
    	super("学生信息管理");//title
    	panel1=new JPanel();
    	add=new JButton("添加");//创建添加按钮
    	delete=new JButton("删除");//创建删除按钮
    	change=new JButton("修改");//创建修改按钮
    	search=new JButton("查询");//创建查询按钮
    	show=new JButton("显示");//创建显示按钮
    	
    	//添加到panel1
    	panel1.add(add);
    	panel1.add(delete);
    	panel1.add(change);
    	panel1.add(search);
    	panel1.add(show);
    	
    	//监听
    	ButtonHandler handler =new ButtonHandler();
    	add.addActionListener(handler);
    	delete.addActionListener(handler);
    	change.addActionListener(handler);
    	search.addActionListener(handler);
    	show.addActionListener(handler);
    	
    	panel2=new JPanel();
    	next_line=new JButton("下一条");//创建下一条按钮
    	former_line=new JButton("上一条");//创建上一条按钮
    	
    	//添加到panel2
    	panel2.add(former_line);
    	panel2.add(next_line);
    	
    	//监听
    	former_line.addActionListener(handler);
    	next_line.addActionListener(handler);
    	
    	panel3=new JPanel();
    	//创建label 输入框
    	number=new JLabel("学号：");
    	name=new JLabel("姓名：");
    	tel=new JLabel("电话：");
    	email=new JLabel("邮箱：");
    	Tnumber=new JTextField(15);
    	Tname=new JTextField(15);
    	Ttel=new JTextField(15);
    	Temail=new JTextField(15);
    	//添加到panel3
    	panel3.add(number);
    	panel3.add(Tnumber);
    	panel3.add(name);
    	panel3.add(Tname);
    	panel3.add(tel);
    	panel3.add(Ttel);
    	panel3.add(email);
    	panel3.add(Temail);
    	
    	//添加到JFrame
    	this.add(panel1,BorderLayout.NORTH);
    	this.add(panel3,BorderLayout.CENTER);
    	this.add(panel2,BorderLayout.SOUTH);
    }
	
    //内部类：ButtonHandler，继承ActionListener
	private  class ButtonHandler implements ActionListener{
		    private Student temp_stu=new Student();//临时学生对象
		    ReadFile read_all=new ReadFile();//读文件
		    ArrayList<Student> stu_list;//所有学生list
		    ArrayList<Student> search_list=new ArrayList<Student>();//查询方法得到的list
		    int search_flag=0;//标记是否执行查询操作
		    int key=1;//stu_list的key值
		    int key2=1;//search_list的key值
	    	public void actionPerformed(ActionEvent e) {
	    		//添加
	    		if(e.getSource()==add){
	    			//提示
	    			String add_infor=JOptionPane.showInputDialog("请依次输入学生学号、姓名、电话、邮箱(以空格分隔)");
	    			CreateFile add_student=new CreateFile();//读文件
	    			add_student.openFile("student.txt");//打开
	    			add_student.add_student_infor(add_infor);//添加到文件
	    			add_student.closeFile();//关闭文件
	    		}//结束添加操作判断
	    		//删除
	    		else if(e.getSource()==delete){
	    			//当TextField显示非空的时候才能删除当前学生信息
	    				if(Tnumber.getText()!=null){
		    				stu_list.remove(key);//从stu_list中删除当前学生信息
		    				CreateFile over_file=new CreateFile();//读文件
		    				over_file.openFile("student.txt", false);//完全覆盖打开文件student.txt
		    				over_file.write_file(stu_list);//用stu_list完全覆盖原来的文件信息
		    				over_file.closeFile();//关闭文件
		    				//输出删除成功
		    				JOptionPane.showMessageDialog(null,"删除成功！","Success：",JOptionPane.INFORMATION_MESSAGE);
		    				//以下操作是对于TextField显示的操作
		    				if(stu_list.size()>1){//如果删除完 ，stu_list中除了第一个空的学生信息外 还有学生信息
		    					if(key<stu_list.size()){//如果删除学生之后还有学生
		    						//那么当前显示为原来学生的后一个学生 
			    					temp_stu=stu_list.get(key);	    					
			    					TextSet();	    						
		    					}
		    					else{//如果删除学生为最后一个，那么显示这个学生的前一个学生
		    						key=key-1;
		    						temp_stu=stu_list.get(key);	    					
			    					TextSet();	   
		    					}
		    				}
		    				else{//如果stu_list中只剩下第一个空学生信息，显示也为空
		    					key=1;//角标置为1
		    					Tnumber.setText("");
		    					Tname.setText("");
		    					Ttel.setText("");
		    					Temail.setText("");
		    				}
	    			    }
	    		}//结束删除操作判断
	    		//修改
	    		else if(e.getSource()==change){
	    				Student temp=new Student();
	    				//获取当前的文本信息
		    			temp.set_student_number(Tnumber.getText());
		    			temp.set_student_name(Tname.getText());
		    			temp.set_student_tel(Ttel.getText());
		    			temp.set_student_email(Temail.getText());
		    			if(temp.check_student_info()){//如果检查符合基本学生信息要求
		    				stu_list.set(key, temp);//修改原来stu_list中这个学生的信息
		    				CreateFile over_file=new CreateFile();
		    				over_file.openFile("student.txt", false);//打开文件
		    				over_file.write_file(stu_list);//完全覆盖
		    				over_file.closeFile();//关闭文件
		    				//输出修改成功
		    				JOptionPane.showMessageDialog(null,"修改学生信息成功！","Success：",JOptionPane.INFORMATION_MESSAGE);
		    			}			
	    		}//结束修改操作判断
	    		//查询
	    		else if(e.getSource()==search){
	    			search_list.clear();//先清空原来的search_list
	    			search_flag=1;//标记已经执行了查询操作
	    			Student temp=new Student();
	    			search_list.add(temp);//这里的temp也是为了避免删除第一个带来的bug
	    			//获取查找的姓名
	    			String search_infor=JOptionPane.showInputDialog("请输入要查找学生的姓名：");
	    			read_all.openFile("student.txt");//打开文件
	    			read_all.readStudent_Info();//获取所有学生信息
	    			stu_list=read_all.getTetrieve();//获取此刻所有学生的stu_list
	    			read_all.closeFile();//关闭文件
	    			for(int i=1;i<stu_list.size();++i){//遍历list
	    				if(stu_list.get(i).get_student_name().equals(search_infor)){//如果找到符合名字的
	    					search_list.add(stu_list.get(i));//放入search_list中
	    				}
	    			}
	    			if(search_list.size()==1){//如果大小等于1 说明没有找到
	    				JOptionPane.showMessageDialog(null,"没有找到名字为"+search_infor+"的学生","Error：",JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else{//否则 显示找到的第一个信息
	    				temp_stu=search_list.get(1);
	    				TextSet();
	    			}
	    		}//结束查询
	    		//显示
	    		else if(e.getSource()==show){  
	    			search_flag=0;//显示操作时候，结束查询操作的结果
	    			read_all.openFile("student.txt");//打开文件
	    			read_all.readStudent_Info();//获取所有学生信息
	    			stu_list=read_all.getTetrieve();//获取list
	    			read_all.closeFile();//关闭文件
	    			if(stu_list.size()>1){//如果有学生信息
		    			temp_stu=stu_list.get(key);//显示学生信息（第一个）
		    			TextSet();//设置Text显示值	    				
	    			}
	    			//如果没有学生信息
	    			else if(stu_list.size()==1){
	    				//输出错误
	    				JOptionPane.showMessageDialog(null,"没有学生信息！","Error：",JOptionPane.INFORMATION_MESSAGE);
	    			}
	    		}//结束显示操作判断
	    	    //上一个
	    		else if(e.getSource()==former_line){
	    			if(search_flag==1){//如果是查询后的界面，上一个是查询结果的上一个
	    				key2=key2-1;
	    				if(key2>0){//这时候说明上一个学生信息存在
	    					temp_stu=search_list.get(key2);
	 		    			TextSet();
	    				}
	    				else{//这说明此时的已经是第一个学生信息
	    					key2=key2+1;
		    				JOptionPane.showMessageDialog(null,"当前信息已经是第一条！","Warning：",JOptionPane.INFORMATION_MESSAGE);
	    				}
	    			}
	    			else{
	    				read_all.openFile("student.txt");
		    			read_all.readStudent_Info();
		    			stu_list=read_all.getTetrieve();
		    			read_all.closeFile();
		    			key=key-1;
		    			if(key>0){//如果上一个学生信息存在
		    			    temp_stu=stu_list.get(key);
			    			TextSet();
		    			}
		    			else{//如果已经是第一个学生信息
		    				key=key+1;
		    				JOptionPane.showMessageDialog(null,"当前信息已经是第一条！","Warning：",JOptionPane.INFORMATION_MESSAGE);
		    			}	
	    			}
	    		}//结束上一个
	    		//下一个
	    		else if(e.getSource()==next_line){
	    			if(search_flag==1){//如果是查询结果的下一个
	    				key2=key2+1;
		    			if(key2<search_list.size()){//如果有下一个
		    			    temp_stu=search_list.get(key2);
			    			TextSet();
		    			}
		    			else{//如果是最后一个
		    		        key2=key2-1;
		    				JOptionPane.showMessageDialog(null,"当前信息已经是最后一条！","Warning：",JOptionPane.INFORMATION_MESSAGE);
		    			}	
	    			}
	    			else{//如果是全部学生信息的下一个
	    				read_all.openFile("student.txt");
		    			read_all.readStudent_Info();
		    			stu_list=read_all.getTetrieve();
		    			read_all.closeFile();
		    			key=key+1;
		    			if(key<stu_list.size()){//如果有下一个
		    			    temp_stu=stu_list.get(key);
			    			TextSet();
		    			}
		    			else{//如果是最后一个
		    		        key=key-1;
		    				JOptionPane.showMessageDialog(null,"当前信息已经是最后一条！","Warning：",JOptionPane.INFORMATION_MESSAGE);
		    			}	
	    			}
	    		}//结束下一个
	    	}//结束方法
	    	
	    	//方法：设置四个TextField的显示值
	    	public void TextSet(){
	    		Tnumber.setText(temp_stu.get_student_number());
    			Tname.setText(temp_stu.get_student_name());
    			Ttel.setText(temp_stu.get_student_tel());
    			Temail.setText(temp_stu.get_student_email());
	    	}//结束方法
	  }//结束类：ButtonHandler
}//结束类：StudentFrame
