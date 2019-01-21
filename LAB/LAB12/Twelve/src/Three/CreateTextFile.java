package Three;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//类：CreateTextFile 
public class CreateTextFile {
  private Formatter output;//输出格式控制
  
  //方法：openFile(String fileName)，打开文件
  public void openFile(String fileName){
	  try{
		  output = new Formatter(fileName);//创建一个Formatter
	  }
	  catch (SecurityException securityException){//权限安全
			System.err.println("You don't have write access to this file");
			System.exit(-1);
	  } 
	  catch (FileNotFoundException fileNotFoundException) {//打开文件失败
		System.err.println("Error opening or creating file.");
		System.exit(-1);
	}
  }//结束方法
  
  //方法：添加记录
  public void addAccountRecords(){
	  AccountRecord record = new AccountRecord();//创建一个记录对象
	  @SuppressWarnings("resource")
	  Scanner input =new Scanner(System.in);//scanner
	  
	  //输出提示信息
	  System.out.println("Print \"end\" to terminate input.");
	  System.out.println("Enter account number(>0) ,first name,last name and balance");
	  
	  while(true){	 
		  try{
			  String temp = input.nextLine();//获取输入的一行
			  String[] s = temp.split(" ");//将一行按照空格分隔
			  
			  if(s[0].equals("end"))break;//如果输入end，结束输入循环
			  else{
			      record.setAccount(Integer.valueOf(s[0]));//设置account的值
			      record.setFirstName(s[1]);//设置firstName
			      record.setLastName(s[2]);//设置lastName
			      record.setBalance(Double.valueOf(s[3]));//设置balance
			  }
              //如果account>0
			  if(record.getAccount()>0){
				  output.format("%d %s %s %.4f \n",
						  record.getAccount(),record.getFirstName(),
						  record.getLastName(),record.getBalance());
			  }
			  //如果account<=0
			  else{
				  System.out.println("Illegal Account");
			  }
		  }
		  catch(FormatterClosedException formatterClosedException){
			  System.err.println("Error writing to file.");
			  return;
		  }
		  catch(NoSuchElementException elementException){
			  System.err.println("Invalid input.Please try again.");
			  input.nextLine();
		  }	 
	  }//结束while循环
  }//结束方法
  
  //添加交易记录
  @SuppressWarnings("resource")
public void addTransactionRecord() throws IOException{
	  TransactionRecord record = new TransactionRecord();//创建一个事务记录
	  Scanner input = new Scanner(System.in);//scanner
	  
	  //输入提示
      System.out.println("Print \"end\" to terminate input.");
      System.out.println("Enter account number(>0) and transaction amount");
 
      while(true){	 
	       try{
		      String temp = input.nextLine();//读取一行
		      String[] s = temp.split(" ");//将一行按空格分隔
		  
		      if(s[0].equals("end"))break;//如果读入了end 结束读入循环
		      else{
			      record.setAccountNumber(Integer.valueOf(s[0]));//设置_accountNumber
			      record.setTransactionAmount(Double.valueOf(s[1]));//设置account
		       }
		      //如果_accountNumber的值>0
			  if(record.getAccountNumber()>0){
				  output.format("%d  %.4f \n",
						  record.getAccountNumber(),record.getAmount());
			  }
			//如果_accountNumber的值<=0
			  else{
				  System.out.println("Illegal Account");
			  }
		  }
		  catch(FormatterClosedException formatterClosedException){
			  System.err.println("Error writing to file.");
			  return;
		  }
		  catch(NoSuchElementException elementException){
			  System.err.println("Invalid input.Please try again.");
			  input.nextLine();
		  }	  
	  }//结束while循环
  }//结束方法
  
  //方法：关闭文件
  public void closeFile(){
	  if(output != null)//如果文件存在
		  output.close();//关闭文件
  }//结束方法
}//结束类：CreateTextFile