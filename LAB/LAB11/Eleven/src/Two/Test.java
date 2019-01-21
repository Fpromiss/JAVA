package Two;
//begin class Test
public class Test {
    //begin method main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test Integer
		System.out.println("Integer:");
        int a1=10,b1=20;
        Isequal<Integer, Integer> isequal=new Isequal<Integer, Integer>();
		System.out.println("a1:"+a1+" b1:"+b1+" "+isequal.isEqualTo(a1,b1));
		int a2=20,b2=20;
		System.out.println("a2:"+a2+" b2:"+b2+" "+isequal.isEqualTo(a2,b2));
		
		//test double
		System.out.println("Double:");
		double d1=3.14,d2=5.20;
		Isequal<Double, Double> isequal2=new Isequal<Double, Double>();
		System.out.println("d1:"+d1+" d2:"+d2+" "+isequal2.isEqualTo(d1,d2));
		double d3=3.1415,d4=3.1415;
		System.out.println("d3:"+d3+" d4:"+d4+" "+isequal2.isEqualTo(d3,d4));
		
		//test string
		System.out.println("String:");
		String s1="hello",s2="world";
		Isequal<String, String> isequal3=new Isequal<String, String>();
		System.out.println("s1:"+s1+" s2:"+s2+" "+isequal3.isEqualTo(s1,s2));
		String s3="hello",s4="hello";
		System.out.println("s3:"+s3+" s4:"+s4+" "+isequal3.isEqualTo(s3,s4));
	}//end method main
}//end class 
