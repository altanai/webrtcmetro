package com.tutorials4u.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import sun.security.jgss.LoginConfigImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import com.tutorials4u.dao.CredentialsDAO;
import com.tutorials4u.dao.CredentialsDAOImpl;
import com.tutorials4u.domain.Credentials;

public class LoginAction extends ActionSupport  {

	private static final long serialVersionUID = -6659925652584240539L;

	private Credentials credentials = new Credentials();
	private List<Credentials> credentialsList = new ArrayList<Credentials>();
	private CredentialsDAO credentialsDAO = new CredentialsDAOImpl();
	

	
	public String login(String sipuri, String password)
	{
		
			credentials = credentialsDAO.searchlogin(sipuri,password);
		return SUCCESS;
	}




	  private String sipuri;
	    private String password;


	    public String execute() {
	        return SUCCESS;
	    }

	    public void validate() {
	    	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			setSipuri(request.getParameter("sipuri"));
			setPassword(request.getParameter("password"));
			
			System.out.println(" values from front end to action class "+ getSipuri()+ " "+ getPassword());
			
	    	if (getSipuri().length() == 0) {
	            addFieldError("sipuri", "sipuri is required");
	        } 
	        
	    	else if (getPassword().length() == 0) {
	            addFieldError("password", getText("password.required"));
	        }
	        else{
	        	System.out.println("validations passed ");
	            login(getSipuri(),getPassword());
	        }
	
	    }

		public String getSipuri() {
			return sipuri;
		}

		public void setSipuri(String sipuri) {
			this.sipuri = sipuri;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}



}
