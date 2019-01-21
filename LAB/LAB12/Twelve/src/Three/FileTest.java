package Three;

import java.io.IOException;
import java.util.Map;

//类：FileTest，测试类
public class FileTest {
	//main方法
    static public void main(String[] argv) throws IOException{
  
	  CreateTextFile accountFile = new CreateTextFile();//创建 CreateTextFile对象
	  CreateTextFile transactionFile = new CreateTextFile();//创建 CreateTextFile对象
	  ReadTextFile<AccountRecord>   readAccountFile = new ReadTextFile<AccountRecord>();//创建ReadTextFile对象
	  ReadTextFile<TransactionRecord>   readTransactionFile = new ReadTextFile<TransactionRecord>();//创建ReadTextFile对象
	  
//创建Account文件并输入数据
/*Data
100 Apple Joke 348.17
200 Mary Smith 27.19
500 Sam Sharp 0.00
700 Sunny Green -14.22
end
*/
	  accountFile.openFile("oldmast.txt");//打开或创建文件oldmast.txt
	  accountFile.addAccountRecords();//从console输入添加记录到oldmast.txt
	  accountFile.closeFile();//关闭文件oldmast.txt
	  
//创建Transaction文件并输入数据
/*Data
100 12.34
200 23.45
400 111.11
800 888.88
end
*/
	  transactionFile.openFile("trans.txt");//打开或者创建trans.txt
	  transactionFile.addTransactionRecord();//从console输入添加到trans.txt
	  transactionFile.closeFile();//关闭文件trans.txt
	  
	  //读取创建的Account文件
	  readAccountFile.openFile("oldmast.txt");//打开文件oldmast.txt
	  readAccountFile.readAccountRecords();//读取记录从oldmast.txt
	  readAccountFile.closeFile();//关闭文件oldmast.txt
	  
	  //读取创建的Transaction文件
	  readTransactionFile.openFile("trans.txt");//打开文件trans.txt
	  readTransactionFile.readTransactionRecord();//读取记录从trans.txt
	  readTransactionFile.closeFile();//关闭文件trans.txt
	  
	  Map<Integer, AccountRecord> account = readAccountFile.getTetrieve();//map 存信息记录
	  Map<Integer, TransactionRecord> tran= readTransactionFile.getTetrieve();//map 存事务记录

	  //提示信息输出
	  System.out.printf("%s %s \t\t%s %s %s \n","AccNumber",
			 "Name","Balance","TranAmount","Combine");
	  
	  //遍历map
	  for(Map.Entry<Integer,AccountRecord>entry : account.entrySet()){
		  AccountRecord temp = entry.getValue();//临时记录
		  if(tran.get(temp.getAccount())!=null)//如果有事务记录，输出和
		  System.out.printf("%-5d%15s\t%.2f\t%.2f\t%.2f\n",
				  temp.getAccount(),temp.getFirstName()+" "+temp.getLastName()
				  ,temp.getBalance(),tran.get(temp.getAccount()).getAmount(),
				  temp.Combine(tran.get(temp.getAccount())));
		  else//否则 输出 0.00
			  System.out.printf("%-5d%15s\t%.2f\t%.2f\t%.2f\n",
					  temp.getAccount(),temp.getFirstName()+" "+temp.getLastName()
					  ,temp.getBalance(),0.00,temp.getBalance());
	  }//结束for循环
	}//结束main方法
}//结束类：FileTest
