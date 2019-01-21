package One;

public class IllegalAddressException extends Exception{
    
	 public IllegalAddressException(){
		 super();
	 }
	 
	 public IllegalAddressException(String address){
		 super(address);
	 }
}
