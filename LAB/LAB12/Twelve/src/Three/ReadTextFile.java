package Three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
//类：ReadTextFile<F>
public class ReadTextFile<F> {
  private Scanner input;
  private Map<Integer,F> tetrieve = new HashMap<Integer,F>();
  
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
  
  //方法：读取AccountRecords
  public void readAccountRecords(){ 
	  try{
		  while(input.hasNext()){//非空时候
			  AccountRecord record = new AccountRecord(); //创建新纪录
			  record.setAccount(input.nextInt());//获取account并设置record的account
			  record.setFirstName(input.next());//获取firstName并设置record的firstName
			  record.setLastName(input.next());//获取lastName并设置record的lastName
			  record.setBalance(input.nextDouble());//获取balance并设置record的balance
			  tetrieve.put(record.getAccount(),(F)record);//放入map中	  
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
  
  //方法：读取TransactionRecord()
  public void readTransactionRecord(){
	  try{
		  while(input.hasNext()){//非空时候
			  TransactionRecord record = new TransactionRecord();//创建事务记录
			  record.setAccountNumber(input.nextInt());//获取accountNumber并设置record的accountNumber
			  record.setTransactionAmount(input.nextDouble());//获取account并设置record的account
			  tetrieve.put(record.getAccountNumber(),(F)record);//存入map
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
  public Map<Integer, F> getTetrieve() {
	return tetrieve;
   }//结束方法
  
  //方法：关闭文件
   public void closeFile(){
	  if(input != null)//文件存在
		  input.close();//关闭
   }//结束方法
}//结束类：ReadTextFile<F>
