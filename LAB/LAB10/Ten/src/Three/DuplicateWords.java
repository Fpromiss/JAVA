package Three;
//begin class DuplicateWords
public class DuplicateWords {
    int duplicateNum;//the number for each word duplicate times
    int count;//the count type for duplicate word 
    int count_num;//the number for all duplicate word
    
    //begin method construct
    DuplicateWords(){
    	duplicateNum=1;//set duplicateNum=1
    	count=0;//set count=0
    	count_num=0;//set count_num=0 
    }//end method
    
    //begin method printCount
    //print the result for count and count_num
    public void printCount(){
    	System.out.println("the all type word is: "+count+" the all num is : "+count_num);
    }//end method
    
    //begin method decide_duplicate 
    /*
     * param:String word
     * 
     */
    public void decide_duplicate(String word){
    	if(word.endsWith(".")){//if the string end with '.',decide the word is sentence
    		word=word.substring(0, word.length()-1);
    		String[] parts = word.trim().split("\\s+");//divide by space +	
        	if(parts.length>0){//if parts length >0,the sentence is not null
        		for(int i=0;i<parts.length;++i){//for each word
        			parts[i]=getWord(parts[i]);//get pure word,with not punctuation.
        			if(parts[i].equals(" ")==false){//if the word is not null
        				for(int j=i+1;j<parts.length;++j){
            				if(parts[i].equals(parts[j])){//count duplicate word
            					duplicateNum++;//duplicate number +1
            					parts[j]=" ";//set parts[j] null
            				}//end if
            			}//end for circle
        			}//end if
        			if(duplicateNum>1){//if duplicateNum>1,the word have duplicate word
        				//out result
        			     System.out.println("the duplicate number of "+parts[i]+ " in the sentence is "+duplicateNum);
        			     count++;//count type +1
        			     count_num+=duplicateNum;//all number+duplicateNum
        			}//end duplicateNum>1
        			duplicateNum=1;//reset duplicateNum
          		}
        		printCount();//print the count and count_num
        	}//end parts length>0
        	else {//if parts length <=0
        		System.out.println("the sentence is wrong!");//out error
        	}
    	}
    	else{//if the string is not end with '.'
    		System.out.println("the sentence is wrong!");//out error
    	}
    }//end method
    
    //begin method getWord
    //get pure word , ignore punctuation.
    public String getWord(String word){
    	String temp="";
    	temp=word.toLowerCase();//to lower case
		if(temp.startsWith("\"")||temp.startsWith("“")){
			temp=temp.substring(1);
		}
		if(temp.endsWith("\"")||temp.endsWith("”")||temp.endsWith(",")||temp.endsWith(".")){
			temp=temp.substring(0,temp.length()-1);
		}
    	return temp;//return 
    }//end method
    
}//end class
