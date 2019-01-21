package Two;

public class Main {
    public static void m1() throws Exception{
    	try{
    		m2();	
    	}
    	catch(Exception exception){
    		throw exception;
    	}
    	
    }
	
    public static void m2()throws Exception{
    	throw new Exception("错误的处理");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try{
        	 m1();
         }
         catch(Exception exception){
        	 System.err.printf("%s\n\n",exception.getMessage());
        	 exception.printStackTrace();
        	 
        	 StackTraceElement[] traceElements=exception.getStackTrace();
        	 
        	 System.out.println("\nStack trace from getStackTrace:");
        	 System.out.println("Class\t\tFile\t\t\tLine\tMethod");
        	 
        	 for(StackTraceElement element:traceElements){
        		 System.out.printf("%s\t",element.getClassName());
        		 System.out.printf("%s\t",element.getFileName());
        		 System.out.printf("%s\t",element.getLineNumber());
        		 System.out.printf("%s\t",element.getMethodName());
        	 }
         }
	}

}
