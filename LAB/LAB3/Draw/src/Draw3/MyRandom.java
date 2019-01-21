package Draw3;

import java.util.Random;

public class MyRandom {
    //create location random number
	int My_Location_Random(int line){//参数line 传进来的是当前窗口的宽或者高
		Random rand=new Random();
        int line_size=rand.nextInt(line)+1; //生成坐标随机数 处于1到宽或者高之间
        return line_size;//返回生成的坐标位置
	}
	//create size random number
	int My_Size_Random(int line){//参数line 传进来的是当前窗口的宽或者高的一半 要控制大小在窗口宽或高的一半
		Random rand=new Random();
        int size=rand.nextInt(line)+1;//生成大小参数; 
        return size;//返回生成的大小参数
	}
    //生成随机数判断是画椭圆还是画矩形 如果是1就画矩形 如果是0 就画椭圆
	int Draw_Rec_Or_Oval(){
		Random rand=new Random();
		return rand.nextInt(2);//生成0，1随机数
	}
}
