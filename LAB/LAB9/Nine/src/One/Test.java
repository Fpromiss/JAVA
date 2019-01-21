package One;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//begin class Test
public class Test {
    //begin method main
	public static void main(String args[]) throws IOException{
		  //the set for get word
		 Set<String> set = new HashSet<String>();
		 String new1=null;
		 new1=readFileByLines("news.txt");//read string from news.txt
		
		 String[] parts = new1.trim().split("\\s+");//divide by space +
			 for(int j=0;j<parts.length;++j){//for each word in each line
				 parts[j]=parts[j].toLowerCase();//to lower case
				//if the word stars with " “ " or starts with "(" 
				if(parts[j].startsWith("“")||parts[j].startsWith("(")){
					parts[j]=parts[j].substring(1);
				}
				//if the word end with " “ " or starts with ")" 
				if(parts[j].endsWith(")")||parts[j].endsWith("”")){
					parts[j]=parts[j].substring(0, parts[j].length()-1);
				}
				//if the word end with " , " or starts with "." 
				if(parts[j].endsWith(",")||parts[j].endsWith(".")){
					parts[j]=parts[j].substring(0, parts[j].length()-1);
				}
				////if the word equal to " - "
				if(parts[j].equals("—")){
					continue;
				}
				//add word to set
				set.add(parts[j]);
			 }//end circle j	   

		 Iterator<String> it = set.iterator();  //the iterator it
	     while (it.hasNext()) {  //while the set has next
	            System.out.println(it.next()); //out print 
	     }  //end while
	}//end method main
	
	//begin method
	public static String readFileByLines(String fileName) throws IOException {
        File file = new File(fileName);//open file
        BufferedReader reader = null;//reader

        reader = new BufferedReader(new FileReader(file));
        String tempString = " ";
        String tempString2= null;
         // get file by line
        while ((tempString2 = reader.readLine()) != null) {
            tempString=tempString+" "+tempString2;//record the string
         }
         reader.close();//close
         return tempString;//return string
    }//end method
	
}//end class Test
