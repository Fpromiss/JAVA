package Three;
import java.util.Scanner;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Pair<Double, String> pair=new Pair<Double, String>();//create object pair
        double f1;
        String s1;
        @SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
        System.out.println("请输入一个数：");
        f1=scan.nextDouble();
        scan.nextLine();
        System.out.println("请输入一个字符串：");
        s1=scan.nextLine();
        pair.setF(f1);//setF
        pair.setS(s1);//setS
        
        System.out.println("getF:"+pair.getF());//get and output F
        System.out.println("getS:"+pair.getS());//get and output S
	}//end method main
}//end class Test
