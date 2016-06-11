package com.tutorialspoint.struts2;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.tutorialspoint.db.DBConnect;


@Results({
   @Result(name="success", location="/success.jsp"),
   @Result(name="input", location="/index.jsp")
})
public class Employee extends ActionSupport{
	
   /**
	 * 
	 */
   private static final long serialVersionUID = -1682820702274153891L;
   private String name;
   private String password;

   // xxx
   @Action(value="login")
   public String execute() 
   {
	   Map<String, Object> session = ActionContext.getContext().getSession();
	   session.put("datum",new Date());
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
//		DBConnect db = new DBConnect();
//		if(db.connectTOsqlite() && db.insertData("a", this.getName(), "secret")){
//			LOG.debug("User gespeichert: [#0]", this.getName());
//		}
	}
}