package Two;

import java.awt.Color;
import java.util.HashMap;
//begin class
public class MyHashMap{
	//key ,the name of color
    String keys[]=new String[]{
    	"blue","red","white","black","orange",
    	"pink","yellow","green","cyan","magenta",
    	"light_gray","dark_gray","gray"
    };
    //value ,the value of color
    Color value[]=new Color[]{
    	Color.BLUE,Color.RED,Color.WHITE,Color.BLACK,Color.ORANGE,
    	Color.PINK,Color.YELLOW,Color.GREEN,Color.cyan,Color.MAGENTA,
    	Color.LIGHT_GRAY,Color.darkGray,Color.gray
    };
    //the _hashmap
   public HashMap<String, Color> map = new HashMap<String, Color>();
    //add to hash map
    public MyHashMap(){
    	for(int i=0;i<13;++i){
    		map.put(keys[i],value[i]);
    	}
    }

    
}
