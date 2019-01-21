package One;
//begin class Verify
public class Verify {
	private String username;//the user name have design
	private String password;//the password have design
	//begin Verify
	Verify(){
		username="2432016220";
		password="123456";
	}//end
	
	//begin method VerifyLogin 
    public String VerifyLogin(String user,String pass){
    	String ret="";//result
    	
    	if(user.length()==0){//if user is empty
    		ret="用户名不能为空！";
    	}
    	else if(pass.length()==0){//if password is empty
    		ret="密码不能为空";
    	}
    	else if(pass.length()<3){//if the length of password <3
    		ret="密码长度至少为3！";
    	}
    	else if(user.equals(username)==false||user.equals(username)&&pass.equals(password)==false){
    		ret="密码错误";//if the user is wrong or the password is wrong
    	}  	
    	else if(user.equals(username)&&pass.equals(password)){
    		ret="登陆成功";//if the user is right and the password is right
    	}
    	return ret;//return result
    }//end method VerifyLogin
}//end class Verify
