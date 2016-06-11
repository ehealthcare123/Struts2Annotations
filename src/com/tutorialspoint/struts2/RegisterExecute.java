package com.tutorialspoint.struts2;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
@Results({
	   @Result(name="success", location="/success.jsp"),
	   @Result(name="input", location="/register.jsp")
	})
public class RegisterExecute extends ActionSupport {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 224532928379636400L;
	private String name;
	   private String password;
	   private String password2;
	   
	   
	// xxx
	   @Action(value="registerex")
	   public String execute() 
	   {
	       return SUCCESS;
	   }

	   @RequiredStringValidator( message = "Please enter a user name!")
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }

	   @RequiredStringValidator(message = "Please enter a password!")
	   public String getPassword() {
	       return password;
	   }
	   
	   public void setPassword(String password) {
	       this.password = password;
	   }
	   
	   @Override
		public void validate() {
		   if(!password.equals(password2)){
			   addFieldError("password2", "Passwörter stimmen nicht überein!");
		   }
		}

 @RequiredStringValidator(message = "Please reenter your password!")
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
