package Fractional;

//begin class Fractional and the class extends Number and own the implements Comparable
public class Fractional extends Number implements Comparable{
	private long numerator;
	private long denominator;
	
	//begin method Fractional
	Fractional ()
	{
		numerator=0;//set  numerator= 0
		denominator=1;//set denominator =1 
	}//end method Fractional
	
	//begin method Fractional
	Fractional(long numeral,long denomi)
	{
		numerator=numeral;//set  numerator= numeral	
	    denominator=denomi;//set denominator =_denomi	
	    reduce();//reduction			
	}//end method Fractional
	
	//begin method getNumerator
	public long getNumerator()
	{
		return numerator;//return numerator
	}//end method getNumerator
	
	//begin method getDenominator
	public long getDenominator()
	{
		return denominator;//return denominator
	}//end method denominator
	
	//begin method add
	public Fractional add(Fractional second_rational)
	{
		long first_num,first_deno,second_num,second_deno;
		first_num=second_rational.getNumerator();//get the first numerator
		first_deno=second_rational.getDenominator();//get the first denominator
		second_num=this.getNumerator();//get the second numerator
		second_deno=this.getDenominator();//get the second denominator
		Fractional temp=new Fractional(first_num*second_deno+second_num*first_deno,first_deno*second_deno);//set add answer
		return temp;//return 
	}//end method add
	
	//begin method subtract
	public Fractional subtract(Fractional second_rational)
	{
		long first_num,first_deno,second_num,second_deno;
		first_num=second_rational.getNumerator();//get the first numerator
		first_deno=second_rational.getDenominator();//get the first denominator
		second_num=this.getNumerator();//get the second numerator
		second_deno=this.getDenominator();//get the second denominator
		Fractional temp=new Fractional(second_num*first_deno-first_num*second_deno,first_deno*second_deno);//set subtract answer
		return temp;//return 
	}//end method subtract
	
	//begin method multiply
	public Fractional multiply(Fractional second_rational)
	{
		long first_num,first_deno,second_num,second_deno;
		first_num=second_rational.getNumerator();//get the first numerator
		first_deno=second_rational.getDenominator();//get the first denominator
		second_num=this.getNumerator();//get the second numerator
		second_deno=this.getDenominator();//get the second denominator
		Fractional temp=new Fractional(first_num*second_num,first_deno*second_deno);//set multiply answer
		return temp;//return 
	}//end method multiply
	
	//begin method divide
	public Fractional divide(Fractional second_rational)
	{
		long first_num,first_deno,second_num,second_deno;
		first_num=second_rational.getNumerator();//get the first numerator
		first_deno=second_rational.getDenominator();//get the first denominator
		second_num=this.getNumerator();//get the second numerator
		second_deno=this.getDenominator();//get the second denominator
		Fractional temp=new Fractional(first_deno*second_num,first_num*second_deno);//set divide answer
		return temp;//return 
	}//end method divide
	
	//begin method reduce
	public void reduce()
	{
		//get the _min _abs numerator or _abs denominator
		long min=Math.abs(numerator)<Math.abs(denominator) ? Math.abs(numerator):Math.abs(denominator);
		for(long i= min;i>0;i--)
		{
			//if numerator>0 and denominator >0
			if(numerator>0&&denominator>0){
				if(numerator%i==0 &&denominator%i==0)//if i is common division
				{
					if(i==1)return;
					numerator/=i;
					denominator/=i;
					reduce();
					return;
				}
			}
			//if numerator >0 and denominator<0
			else if(numerator>0&&denominator<0){
				if(numerator%i==0 &&(-denominator)%i==0)//if i is common division
				{
					if(i==1)return;
					numerator/=i;
					denominator/=i;
					reduce();
					return;
				}
			}
			//if numerator<0 and denominator>0
			else if(numerator<0&&denominator>0){
				if((-numerator)%i==0 &&denominator%i==0)//if i is common division
				{
					if(i==1)return;
					numerator/=i;
					denominator/=i;
					reduce();
					return;
				}
			}
		}//end for circle
	}//end method reduce

	@Override
	//begin method toString
	public String toString()
	{
		String str=new String("");
		if(denominator==1){//if denominator =1
			str+=""+numerator;
		}
		else if(numerator==0){//if numerator=0
			str+=""+numerator;
		}
		else{
		   str+=""+numerator+'/'+denominator;
		}
		return str;//return 
	}//end method toString

	@Override
	//begin method double value
	public double doubleValue() {
		// TODO Auto-generated method stub
		double temp=(double)numerator/denominator;//get double value
		return temp;//return
	}//end method double value

	@Override
	//begin method float value
	public float floatValue() {
		// TODO Auto-generated method stub
		float temp=(float)numerator/denominator;//get double value
		return temp;//return
	}//end method float value

	@Override
	//begin method _int value
	public int intValue() {
		// TODO Auto-generated method stub
		int temp=(int)numerator/(int)denominator;
		return temp;//return
	}//end method _int value

	@Override
	//begin method long value
	public long longValue() {
		// TODO Auto-generated method stub
		long temp=(long)numerator/denominator;
		return temp;//return
	}//end method long value
	
	
	//begin the method _gcd , and the method is to the max common divisor
	public long gcd(long n,long d) 
	{
		long i=n>d?d:n;//i=_min(n,d)
		while((n%i!=0)||d%i!=0){//if i is not the common divisor
			--i;
		}
		return i;//return i
	}//end method _gcd
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
