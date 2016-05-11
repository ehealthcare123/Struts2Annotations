package com.tutorialspoint.struts2;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.tutorialspoint.db.DBConnect;


@Results({
   @Result(name="success", location="/success.jsp"),
   @Result(name="input", location="/index.jsp")
})
public class Employee extends ActionSupport{
	
   private String name;
   private int age;
// xxx
   @Action(value="empinfo")
   public String execute() 
   {
       return SUCCESS;
   }

   @RequiredStringValidator( message = "The name is required")
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }

   @IntRangeFieldValidator(message = "Age must be in between 29 and 65",
                                      min = "29", max = "65")
   public int getAge() {
       return age;
   }
   public void setAge(int age) {
       this.age = age;
   }
   
   @Override
	public void validate() {
//		DBConnect db = new DBConnect();
//		if(db.connectTOsqlite() && db.insertData("a", this.getName(), "secret")){
//			LOG.debug("User gespeichert: [#0]", this.getName());
//		}
	}
}