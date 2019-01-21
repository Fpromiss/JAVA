package Three;

//类：AccountRecord，记录
public class AccountRecord {
	
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
	   
    //构造函数：赋值全空或0
	public AccountRecord() {
		this(0,null,null,0.0);
	}//结束方法

	//构造函数：设置account、firstName、lastName、balance的值
	public AccountRecord(int account, String firstName, String lastName,
			double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}//结束方法

	//方法:getAccount(),获取account的值
	public int getAccount() {
		return account;
	}//结束方法
	
	//方法:setAccount(account),设置account的值
	public void setAccount(int account) {
		this.account = account;
	}//结束方法
	
	//方法:getFirstName(),获取firstName
	public String getFirstName() {
		return firstName;
	}//结束方法
	
	//方法：setFirstName(String firstName)，设置firstName的值
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}//结束方法
	
	//方法：getLastName()，获取lastName
	public String getLastName() {
		return lastName;
	}//结束方法
	
	//方法：setLastName(String lastName)，设置lastName的值
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}//结束方法
	
	//方法：getBalance()，获取balance的值
	public double getBalance() {
		return balance;
	}//结束方法
	
	//方法：setBalance(double balance)，设置balance的值
	public void setBalance(double balance) {
		this.balance = balance;
	}//结束方法

	//方法：Combine(TransactionRecord t)，返回balance+account的值
	public double Combine(TransactionRecord t){
		return this.balance+t.getAmount();
	}//结束方法
}//结束类：AccountRecord
