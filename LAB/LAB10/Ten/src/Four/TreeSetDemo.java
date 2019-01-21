package Four;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
//begin class TreeSetDemo
public class TreeSetDemo {  
	  @SuppressWarnings("resource")
	  //begin method main
	public static void main(String[] args) {
	  //create TreeSet
	  TreeSet<String> ts = new TreeSet<String>(new Comparator<String>(){
		@Override
		//create comparator and override method compare
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			int num = s1.compareTo(s2);
			return num;//return compare result
		 }//end method compare
	  });
	  
	  Scanner scan=new Scanner(System.in);//create object Scanner
	  String input="";//input string
	  System.out.println("请输入一行");
      input=scan.nextLine();//input by line
      String[] parts = input.trim().split("\\s+");//divide by space +	
	  
      //begin for circle and add string parts[i] to TreeSet
      for(int i=0;i<parts.length;++i){
    	  ts.add(parts[i]);
      }//end for circle
      
      System.out.println("按照升序排序：");//output
      for(String s : ts){//for TreeSet ,print string
          System.out.println(s);
      }//end for circle
    }//end method main
}//end class TreeSetDemo
