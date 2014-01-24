package com.tutorials4u.web;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sun.security.jgss.LoginConfigImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import com.tutorials4u.dao.EmailDAO;
import com.tutorials4u.dao.EmailDAOImpl;
import com.tutorials4u.domain.Email;


public class EmailAction extends ActionSupport implements ModelDriven<Email> {

	private Email email = new Email();
	private List<Email> emailList = new ArrayList<Email>();
	private EmailDAO emailDAO = new EmailDAOImpl();
	
	public Email getModel() {
		return email;
	}
	
	/**
	 * To save or update email.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		emailDAO.saveOrUpdateEmail(email);
		return SUCCESS;
	}
	
	/**
	 * To list all emails.
	 * @return String
	 */
	public String list()
	{
		emailList = emailDAO.listEmail();
		return SUCCESS;
	}
	
	/**
	 * To delete a email.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		emailDAO.deleteEmail(request.getParameter("sipuri"));
		return SUCCESS;
	}
	
	/**
	 * To list a single email by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		email = emailDAO.listEmailById(request.getParameter("sipuri"));
		return SUCCESS;
	}
	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Email> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}
}
