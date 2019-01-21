package One;

import java.util.Scanner;

public class MainTest {
	
	public static void main(String args[]) throws Exception{
		String name;
		String address;
		Student stu=new Student();
		Scanner scan = new Scanner(System.in);
		boolean continueloop=true;
		do{
			try{
				System.out.print("please input name:");
				name=scan.nextLine();
				stu.setName(name);	
				System.out.print("please input address:");
				address=scan.nextLine();
				stu.setAddress(address);
				continueloop=false;
			}
			catch(IllegalNameException illgelnameexception){
				System.out.printf(" \nException: %s \n",illgelnameexception);
				//scan.nextLine();
				System.out.println("you must continue to input again!");
			}
			catch(IllegalAddressException illegaladdressexception){
				System.out.printf("\nException: %s \n",illegaladdressexception);
				//scan.nextLine();
				System.out.println("you must continue to input again!");
			}
		}while(continueloop);		
		stu.display();
	}

}
