package Two;
//begin class Result
public class Result {
	//begin method get_Result
	public String get_Result(String user,String pass,String email){
		String result="";
		if(user.isEmpty()){//if the user is empty
			result="用户名不能为空！";
		}
		else if(pass.isEmpty()){//if the password is empty
			result="密码不能为空！";
		}
		else if(email.isEmpty()){//if the email is empty
			result="邮箱不能为空！";
		}
		else if(user.matches("^[a-zA-Z_][a-zA-Z_0-9]{0,}")==false){//if the user can not matches 
			result="用户名只能由字母、数字和_组成，第一位不能为数字。";
		}
		else if(pass.matches("[a-zA-Z0-9_]{8,}")==false){//if the password can not matches
			result="密码长度至少8位，由字母、数字、下划线组成。";
		}
		//if the email can not matches
		else if(email.matches("[a-zA-Z_]{1,}[a-zA-Z0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,}[a-zA-z\\-]{1,}")==false){
			result="需包含”@”符号。”@”符号后需要出现多个由”. ”分割的词。";
		}
		//if the user , password and email all  matches
		else {
			result="匹配成功！";
		}		
	    return result;	
	}//end method
}//end class
