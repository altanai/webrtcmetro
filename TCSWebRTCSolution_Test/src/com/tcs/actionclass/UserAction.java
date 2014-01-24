package com.tcs.actionclass;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.bean.Login;
import com.tcs.dao.MyLoginDao;
import com.tcs.dao.MyLoginDao_Interface;



public class UserAction extends ActionSupport implements ModelDriven<Login> {
	static Logger log = Logger.getLogger(UserAction.class.getName());
	
	private MyLoginDao_Interface loginDAO = new MyLoginDao();
	private Login loginmodel= new Login(); 
	@Override
	public Login getModel() {
		log.info("-----------Action Class----------");
		// TODO Auto-generated method stub
		return loginmodel;
	}

	public String list()
	{
		log.info("-----------Action Class---------- list");
		return "SUCCESS";
	}
	


}
