package action;

import java.util.Map;

import biz.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DbService;


public class RegisterAction extends ActionSupport  
{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String  repassword;
	private String sex;
	private String email;
	private String validate;
	
	
	
	public String getValidate()
	{
		return validate;
	}

	public void setValidate(String validate)
	{
		this.validate = validate;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String execute() throws Exception
	{
		int sex1=Integer.parseInt(sex);
		Users user = new Users();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setSex(sex1);
		DbService dbservice = new DbService();
		if(dbservice.hasSameName(username))
		{
			this.addFieldError(username, "使用者名稱已存在");
			return INPUT;
		}
		else {
			dbservice.addUser(user);
		}
	  return SUCCESS;	
	}

	@Override
	public void validate()
	{
		 ActionContext actionContext = ActionContext.getContext();   
	        
	        Map session = actionContext.getSession();  
		if( !repassword.equals(password) )
		{
			this.addFieldError(repassword, "重復密碼不一致");
		}
		if (!session.get("random").equals(validate))
		{
		     this.addFieldError(validate, "驗證碼錯誤");
		}
		
	}
}
