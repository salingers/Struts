package action;

import java.util.Map;

import biz.Users;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.DbService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		DbService dbservice = new DbService();
		Users user = new Users();
		user = dbservice.hasUser(username, password);
		if (user.getUsername() == null) {
			this.addFieldError("username", "使用者名稱或密碼不正確");
			return INPUT;
		} else {

			ActionContext actionContext = ActionContext.getContext();
			Map session = actionContext.getSession();
			session.put("user", user.getUsername());
		}

		return SUCCESS;
	}

}
