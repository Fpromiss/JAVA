package Three;

//类：TransactionRecord，事务记录
public class TransactionRecord {
	
	private int accountNumber;//账号
	private double amount;  //金额
	 
	//构造函数：设置为0，0
	public TransactionRecord(){
		this(0,0.0);
	}//结束方法
	
	//构造函数：设置accountNumber、amount
	public TransactionRecord(int accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}//结束方法

	//方法：getAccountNumber()，获取accountNumber的值
	public int getAccountNumber() {
		return accountNumber;
	}//结束方法
	
	//方法：setAccountNumber(int accountNumber)，设置accountNumber的值
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}//结束方法
	
	//方法:getAmount(),获取amount的值
	public double getAmount() {
		return amount;
	}//结束方法
	
	//方法:setTransactionAmount(double amount),设置amount的值
	public void setTransactionAmount(double amount) {
		this.amount = amount;
	}//结束方法
}//结束类：TransactionRecord

