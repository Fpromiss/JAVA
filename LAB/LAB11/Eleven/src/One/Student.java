package One;
//begin class Student 
public class Student implements Comparable<Student> {
     private String stu_number; //student number
	 private String name;//student name
	 private String stu_class;//student class
	 private int score;//student score
	 
	 //begin method _init
	 Student(){
		 stu_number="";
		 name="";
		 stu_class="";
		 score=0;
	 }//end method 
	 
	 //begin method set
	 public void set(String stu_number,String name,String stu_class,int score){
		 this.stu_number=stu_number;
		 this.name=name;
		 this.stu_class=stu_class;
		 this.score=score;
	 }//end method
	 
	 //begin method display 
	 //display stu_number , name, stu_class,score
	 public void display(){
		 System.out.println("stu_number:"+stu_number+" name:"+name+" stu_class:"+stu_class+" score:"+score);
	 }//end method
	 
	 //begin method display
	 //display the  stu_number , name, score
	 public void display(int i){
		 System.out.println("stu_number:"+stu_number+" name:"+name+" score:"+score);
	 }//end method
	 
     //begin method get student name 
	 public String getName(){
		 return name;
	 }//end method
	 
	 //begin method get student class
	 public String getstuClass(){
		 return stu_class;
	 }//end class
	 
    //begin method get student number
	public String getStuNumber(){
		return stu_number;
	}//end method
	
	//begin method get score
	public int getScore(){
		return score;
	}//end method
	 
	 @Override
     public boolean equals(final Object obj) {
       if (obj == null) {//if the object is null
          return false;//return false
       }
       final Student std = (Student) obj;
       if (this == std) {//if this == _std 
          return true;//return true
       } else {
    	   //return stu_class and stu_number result
          return (this.stu_class.equals(std.stu_class) && (this.stu_number == std.stu_number));
       }
     }//end method

	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	 
}//end class
