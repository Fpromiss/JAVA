package Three;

import java.util.Scanner;
//begin class Test
public class Test {
	 /** 
     * @param FileName Test 
     * @author fang _jun
     */  
    //begin method main
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DuplicateWords duplicate =new DuplicateWords();//create object DuplicateWords
        Scanner scan=new Scanner(System.in);//create object Scanner
        String input="";//input string
        System.out.println("请输入一行以 '.'结尾");//output
        input=scan.nextLine();//input by line
        duplicate.decide_duplicate(input);//get result
	}//end method main
}//end class Test
