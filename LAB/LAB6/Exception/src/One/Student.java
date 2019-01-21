package One;

public class Student {
     private String name;
     private String address;
     
     Student(){
    	 name="";
    	 address="";
     }
     
     public void setName(String n) throws Exception{
    	 if(n.length()<1||n.length()>5){
    		 throw new IllegalNameException("name 长度应该在1-5之间！");
    	 }
    	 else{
    		 name=n;
    	 }
     }
     
     public void setAddress(String a) throws Exception{
    	 if(a.indexOf("省")==-1||a.indexOf("市")==-1){
    		 throw new IllegalAddressException("address应该包含关键字：“省”和“市”！");
    	 }
    	 else{
    		 address=a;
    	 }
     }
     
     void display(){
    	 System.out.println("hello "+name+" , you are in "+address);
     }
}
