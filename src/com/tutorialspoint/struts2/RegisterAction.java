package com.tutorialspoint.struts2;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	   @Result(name="success", location="/register.jsp")
	})
public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4275931729403707462L;


	// xxx
	   @Action(value="register")
	   public String execute() 
	   {
	       return SUCCESS;
	   }
}
